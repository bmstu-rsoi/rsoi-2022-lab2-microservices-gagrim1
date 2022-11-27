package com.romanov.gateway.model;

import lombok.Value;

@Value
public class CalculationPriceInput {
    String username;
    Integer price;
    Boolean paidFromBonus;
}
