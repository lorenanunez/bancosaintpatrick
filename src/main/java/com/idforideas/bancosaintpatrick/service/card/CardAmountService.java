package com.idforideas.bancosaintpatrick.service.card;

import com.idforideas.bancosaintpatrick.entity.Card;
import com.idforideas.bancosaintpatrick.entity.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class CardAmountService {

    public BigDecimal calculateCardAmount(Card card) {
        BigDecimal amount = new BigDecimal("0");
        Set<Transaction> transactions = card.getTransactions();

        for (Transaction t : transactions) {
            amount = switch (t.getTransactionType()) {
                case INCOME -> amount.add(t.getAmount());
                case OUTCOME -> amount.subtract(t.getAmount());
            };
        }

        return (amount);
    }

}
