package com.idforideas.bancosaintpatrick.service.card;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentCardService {

    private AuthenticatedCardService authenticatedCardService;
    private CardRepository cardRepository;

    public Card getCurrentCard() {
        return cardRepository.findCardByNumber(authenticatedCardService.getAuthenticatedCardNumber()).orElseThrow();
    }

}
