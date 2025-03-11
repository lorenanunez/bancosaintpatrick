package com.idforideas.bancosaintpatrick.service.card;

import com.idforideas.bancosaintpatrick.entity.AppUser;
import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.entity.dto.CardInfoDto;
import com.idforideas.bancosaintpatrick.entity.dto.TransactionEntryDto;
import com.idforideas.bancosaintpatrick.service.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CardInfoService {

    private TransactionService transactionService;
    private CardAmountService cardAmountService;
    private CurrentCardService currentCardService;

    public CardInfoDto getCurrentCardInformation() {
        Card currentCard = currentCardService.getCurrentCard();
        AppUser currentCardUser = currentCard.getUser();
        BigDecimal currentCardAmount = cardAmountService.calculateCardAmount(currentCard);
        List<TransactionEntryDto> transactions = transactionService.getGetTransactionsService().getCurrentCardTransactions();

        String currentUserName = currentCardUser.getName() + " " + currentCardUser.getSurname();

        return CardInfoDto.builder()
                .proprietary(currentUserName)
                .number(currentCard.getNumber())
                .amount(currentCardAmount)
                .transactions(transactions)
                .build();
    }

}
