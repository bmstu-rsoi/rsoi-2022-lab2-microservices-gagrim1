package com.romanov.privilege.model.dto;

import lombok.Value;

@Value
public class CalculationPriceInput {
    String username;
    Integer price;
    Boolean paidFromBonus;
}
