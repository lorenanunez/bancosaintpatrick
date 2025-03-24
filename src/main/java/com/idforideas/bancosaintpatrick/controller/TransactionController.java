package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CreateTransactionDto;
import com.idforideas.bancosaintpatrick.service.transaction.CreateTransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
@Tag(name = "Transaction controller", description = "Operations pertaining to the transaction")
public class TransactionController {

    private CreateTransactionService createTransactionService;

    @Operation(summary = "Create a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction created"),
            @ApiResponse(responseCode = "422", description = "Not Enough Balance"),
            @ApiResponse(responseCode = "400", description = "Arguments not valid"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody @Valid CreateTransactionDto dto) {
        createTransactionService.createTransaction(dto);
    }

}
