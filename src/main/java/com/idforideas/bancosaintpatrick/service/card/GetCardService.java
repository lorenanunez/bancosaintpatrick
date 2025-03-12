package com.idforideas.bancosaintpatrick.service.card;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetCardService {

    private CardRepository cardRepository;
    private CardValidationService cardValidationService;

    public Card getCardByNumber(String number) {
        cardValidationService.validateCardNumber(number);
        return cardRepository.findCardByNumber(number).orElseThrow();
    }

}
