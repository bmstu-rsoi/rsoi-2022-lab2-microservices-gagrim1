package com.romanov.ticket.model.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class TicketOutput {
    Integer id;
    UUID ticketUid;
    String username;
    String flightNumber;
    Integer price;
    String status; // PAID или CANCELED
}
