package com.idforideas.bancosaintpatrick.service.transaction;

import com.idforideas.bancosaintpatrick.entity.dto.TransactionEntryDto;
import com.idforideas.bancosaintpatrick.repository.TransactionRepository;
import com.idforideas.bancosaintpatrick.service.card.CurrentCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetTransactionsService {

    private CurrentCardService currentCardService;
    private TransactionRepository transactionRepository;

    public List<TransactionEntryDto> getCurrentCardTransactions() {
        return transactionRepository.findTransactionByCard(currentCardService.getCurrentCard())
                .stream()
                .map(t ->
                    TransactionEntryDto.builder()
                            .dateTime(t.getDateTime())
                            .description(t.getDescription())
                            .amount(t.getAmount())
                            .transactionType(t.getTransactionType())
                            .build()
                ).toList();
    }

}
