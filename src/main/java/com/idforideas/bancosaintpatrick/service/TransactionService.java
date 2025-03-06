package com.idforideas.bancosaintpatrick.service;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.entity.Transaction;
import com.idforideas.bancosaintpatrick.entity.TransactionType;
import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.entity.dto.TransactionEntryDto;
import com.idforideas.bancosaintpatrick.exception.NotEnoughBalanceException;
import com.idforideas.bancosaintpatrick.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionService {

    private TransactionRepository transactionRepository;
    private CardService cardService;

    @Transactional
    public void createTransaction(CreateTransactionDto dto) {

        Card originCard = cardService.getCurrentCard();
        Card destinationCard = cardService.findCardByNumber(dto.getDestination());

        BigDecimal originCardBalance = cardService.getCardBalance().getAmount();

        if( originCardBalance.compareTo(dto.getAmount()) < 0) {
            String message = "Origin card does not have enough balance to perform this transaction";
            log.error(message);
            throw new NotEnoughBalanceException(message);
        }

        Transaction originCardTransaction = new Transaction();
        Transaction destinationCardTransaction = new Transaction();

        originCardTransaction.setCard(originCard);
        originCardTransaction.setDateTime(LocalDateTime.now());
        originCardTransaction.setAmount(dto.getAmount());
        originCardTransaction.setDescription(dto.getDescription());
        originCardTransaction.setTransactionType(TransactionType.OUTCOME);

        destinationCardTransaction.setCard(destinationCard);
        destinationCardTransaction.setDateTime(LocalDateTime.now());
        destinationCardTransaction.setAmount(dto.getAmount());
        destinationCardTransaction.setDescription(dto.getDescription());
        destinationCardTransaction.setTransactionType(TransactionType.INCOME);

        transactionRepository.save(originCardTransaction);
        transactionRepository.save(destinationCardTransaction);

    }

    public List<TransactionEntryDto> getAllTransactions() {
        List<TransactionEntryDto> transactionEntryDtos = new ArrayList<>(1000);

        transactionRepository.findTransactionByCard(cardService.getCurrentCard()).forEach(t ->
                transactionEntryDtos.add(TransactionEntryDto.builder()
                    .dateTime(t.getDateTime())
                    .description(t.getDescription())
                    .amount(t.getAmount())
                    .transactionType(t.getTransactionType())
                    .build()
            ));

        return (transactionEntryDtos);

    }



}
