package com.idforideas.bancosaintpatrick.service.transaction;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.entity.Transaction;
import com.idforideas.bancosaintpatrick.entity.TransactionType;
import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.exception.NotEnoughBalanceException;
import com.idforideas.bancosaintpatrick.repository.TransactionRepository;
import com.idforideas.bancosaintpatrick.service.card.CardAmountService;
import com.idforideas.bancosaintpatrick.service.card.CurrentCardService;
import com.idforideas.bancosaintpatrick.service.card.GetCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class CreateTransactionService {

    private TransactionRepository transactionRepository;
    private CurrentCardService currentCardService;
    private CardAmountService cardAmountService;
    private GetCardService getCardService;

    @Transactional
    public void createTransaction(CreateTransactionDto dto) {
        Card currentCard = currentCardService.getCurrentCard();
        Card destinationCard = getCardService.getCardByNumber(dto.getDestination());

        // Validations if the card exists, and it's valid, occurs on it's corresponding services

        if (cardAmountService.calculateCardAmount(currentCard).compareTo(dto.getAmount()) < 0) {
            String message = "Card has not enough balance";
            log.warn(message);
            throw new NotEnoughBalanceException(message);
        }

        BigDecimal amount = dto.getAmount();
        String description = dto.getDescription().trim();

        Transaction outcomeTransaction = createTransaction(currentCard, amount, description, TransactionType.OUTCOME);
        Transaction incomeTransaction = createTransaction(destinationCard, amount, description, TransactionType.INCOME);

        transactionRepository.save(outcomeTransaction);
        transactionRepository.save(incomeTransaction);

    }

    private Transaction createTransaction(Card card, BigDecimal amount, String descrpiton, TransactionType type) {

        Transaction transaction = new Transaction();
        transaction.setTransactionType(type);
        transaction.setAmount(amount);
        transaction.setDescription(descrpiton);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setCard(card);

        return (transaction);
    }

}
