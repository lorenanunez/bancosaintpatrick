package com.idforideas.bancosaintpatrick.service.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
@AllArgsConstructor
public class TransactionService {

    private GetTransactionsService getTransactionsService;
    private CreateTransactionService createTransactionService;

}
