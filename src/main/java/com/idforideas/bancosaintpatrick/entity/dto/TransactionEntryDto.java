package com.idforideas.bancosaintpatrick.entity.dto;

import com.idforideas.bancosaintpatrick.entity.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionEntryDto implements Serializable {

    private LocalDateTime dateTime;
    private String description;
    private BigDecimal amount;
    private TransactionType transactionType;

}
