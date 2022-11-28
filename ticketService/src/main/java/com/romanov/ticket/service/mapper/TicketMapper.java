package com.romanov.ticket.service.mapper;

import com.romanov.ticket.model.TicketEntity;
import com.romanov.ticket.model.dto.TicketOutput;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketOutput convert(TicketEntity entity) {
        return TicketOutput.builder()
                .id(entity.getId())
                .ticketUid(entity.getTicketUid())
                .username(entity.getUsername())
                .flightNumber(entity.getFlightNumber())
                .price(entity.getPrice())
                .status(entity.getStatus())
                .build();
    }
}
