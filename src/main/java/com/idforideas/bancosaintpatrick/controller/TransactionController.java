package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.service.transaction.CreateTransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private CreateTransactionService createTransactionService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody @Valid CreateTransactionDto dto) {
        createTransactionService.createTransaction(dto);
    }

}
