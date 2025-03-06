package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CardBalanceDto;
import com.idforideas.bancosaintpatrick.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class CardController {

    private CardService cardService;

    @GetMapping(value = "/balance", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CardBalanceDto getBalance() {
        return cardService.getCardBalance();
    }

}
