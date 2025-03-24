package com.idforideas.bancosaintpatrick.controller;

import com.idforideas.bancosaintpatrick.entity.dto.CardInfoDto;
import com.idforideas.bancosaintpatrick.service.card.CardInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@AllArgsConstructor
@Tag(name = "Card controller", description = "Operations pertaining to the card")
public class CardController {

    private CardInfoService cardInfoServiceService;

    @Operation(summary = "Get the current card information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public CardInfoDto getCardInfo() {
        return cardInfoServiceService.getCurrentCardInformation();
    }

}
