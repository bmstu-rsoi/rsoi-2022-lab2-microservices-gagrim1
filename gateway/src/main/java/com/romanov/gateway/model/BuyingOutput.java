package com.romanov.gateway.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class BuyingOutput {
    private UUID ticketUid;
    private String flightNumber;
    private String fromAirport;
    private String toAirport;
    private LocalDateTime dateTime;
    private Integer price;
    private Integer paidByMoney;
    private Integer paidByBonus;
    private String status;
    private PrivilegeOutput privilege;
}