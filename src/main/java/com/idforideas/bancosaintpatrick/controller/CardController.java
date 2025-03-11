package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CardInfoDto;
import com.idforideas.bancosaintpatrick.service.card.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class CardController {

    private CardService cardService;

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public CardInfoDto getCardInfo() {
        return cardService.getCardInfoService().getCurrentCardInformation();
    }


}
