package com.idforideas.bancosaintpatrick.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CardInfoDto implements Serializable {

    private String proprietary;
    private String number;
    private BigDecimal amount;
    private List<TransactionEntryDto> transactions;

}
