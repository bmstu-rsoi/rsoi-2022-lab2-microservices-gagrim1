package com.romanov.model.dto;

import lombok.Value;

@Value
public class TicketInput {
    String flightNumber;
    Integer price;
}
