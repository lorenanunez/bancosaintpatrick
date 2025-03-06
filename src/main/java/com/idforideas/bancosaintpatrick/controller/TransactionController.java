package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.entity.dto.TransactionEntryDto;
import com.idforideas.bancosaintpatrick.service.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void receiveTransaction(@RequestBody @Valid CreateTransactionDto dto) {
        log.info("Incoming transaction: {}", dto);
        transactionService.createTransaction(dto);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TransactionEntryDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
