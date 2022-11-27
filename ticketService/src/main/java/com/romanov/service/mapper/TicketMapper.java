package com.romanov.service.mapper;

import com.romanov.model.TicketEntity;
import com.romanov.model.dto.TicketOutput;
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
