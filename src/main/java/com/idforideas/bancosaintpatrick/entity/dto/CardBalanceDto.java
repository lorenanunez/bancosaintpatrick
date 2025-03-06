package com.idforideas.bancosaintpatrick.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardBalanceDto implements Serializable {
    private BigDecimal amount;
}
