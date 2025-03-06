package com.idforideas.bancosaintpatrick.service;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.entity.Transaction;
import com.idforideas.bancosaintpatrick.entity.dto.CardBalanceDto;
import com.idforideas.bancosaintpatrick.exception.InvalidCardException;
import com.idforideas.bancosaintpatrick.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    public CardBalanceDto getCardBalance() {
        String cardNumber = getCurrentCardNumber();
        Card card = cardRepository.findCardByNumber(cardNumber).orElseThrow();
        CardBalanceDto dto = new CardBalanceDto();

        dto.setAmount(calculateCardAmount(card));

        return (dto);
    }

    public void validateCardNumber(String cardNumber) {
        String cardNumberCleaned = cardNumber.replace(" ", "");

        if (cardNumberCleaned.length() != 16 || !StringUtils.isNumeric(cardNumberCleaned)) {
            String message = String.format("The card \"%s\" is not a valid card number.", cardNumber);
            log.warn(message);
            throw new InvalidCardException(message);
        }

    }

    public Card getCurrentCard() {
        return findCardByNumber(getCurrentCardNumber());
    }

    public Card findCardByNumber(String number) {
        validateCardNumber(number);
        return cardRepository.findCardByNumber(number).orElseThrow();
    }

    private BigDecimal calculateCardAmount(Card card) {
        BigDecimal amount = new BigDecimal("0");
        Set<Transaction> transactions = card.getTransactions();

        for (Transaction t : transactions) {
            amount = switch (t.getTransactionType()) {
                case INCOME -> amount.add(t.getAmount());
                case OUTCOME -> amount.subtract(t.getAmount());
            };
        }

        return (amount);
    }

    private String getCurrentCardNumber() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}
