package com.romanov.service;

import com.romanov.model.dto.TicketInput;
import com.romanov.model.dto.TicketOutput;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    List<TicketOutput> getAllByUsername(String username);
    TicketOutput createTicket(String username, TicketInput input);
    TicketOutput cancelTicket(String username, UUID uid);
    TicketOutput getTicketByUsernameAndUid(String username, UUID uid);
}
