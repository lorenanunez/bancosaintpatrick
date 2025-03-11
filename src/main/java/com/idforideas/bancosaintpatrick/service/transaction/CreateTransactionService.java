package com.idforideas.bancosaintpatrick.service.transaction;

import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.repository.TransactionRepository;
import com.idforideas.bancosaintpatrick.service.card.CardValidationService;
import com.idforideas.bancosaintpatrick.service.card.CurrentCardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateTransactionService {

    private TransactionRepository transactionRepository;
    private CurrentCardService currentCardService;
    private CardValidationService cardValidationService;

    @Transactional
    public void createTransaction(CreateTransactionDto dto) {
        throw new UnsupportedOperationException();
    }

}
