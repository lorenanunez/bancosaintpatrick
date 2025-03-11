package com.idforideas.bancosaintpatrick.service.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
@AllArgsConstructor
public class CardService {

    private CardAmountService cardAmountService;
    private CardValidationService cardValidationService;
    private CurrentCardService currentCardService;
    private CardInfoService cardInfoService;

}
