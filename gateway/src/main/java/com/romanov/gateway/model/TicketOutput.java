package com.romanov.gateway.model;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class TicketOutput {
    UUID ticketUid;
    String flightNumber;
    String fromAirport;
    String toAirport;
    LocalDateTime date;
    Integer price;
    String status;
}
