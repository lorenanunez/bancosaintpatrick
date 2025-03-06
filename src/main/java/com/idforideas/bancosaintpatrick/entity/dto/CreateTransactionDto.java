package com.idforideas.bancosaintpatrick.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CreateTransactionDto implements Serializable {

    @NotBlank(message = "Destination card must not be null or blank")
    @Size(min = 16, max = 16, message = "Destination card number must be 16 characters long")
    private String destination;

    @NotNull(message = "The amount must not be null")
    @Positive(message = "The amount must be higher than zero")
    private BigDecimal amount;

    @NotBlank(message = "Description cannot be null or blank")
    @Size(min = 1, max = 45, message = "Description must have at least 1 character and max length of 45")
    private String description;

}
