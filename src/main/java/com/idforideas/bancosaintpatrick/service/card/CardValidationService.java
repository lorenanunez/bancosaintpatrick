package com.idforideas.bancosaintpatrick.service.card;

import com.idforideas.bancosaintpatrick.exception.InvalidCardException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
public class CardValidationService {

    public void validateCardNumber(String cardNumber) {
        String cardNumberCleaned = cardNumber.replace(" ", "");

        if (cardNumberCleaned.length() != 16 || !StringUtils.isNumeric(cardNumberCleaned)) {
            String message = String.format("The card \"%s\" is not a valid card number.", cardNumber);
            log.warn(message);
            throw new InvalidCardException(message);
        }

    }

}
