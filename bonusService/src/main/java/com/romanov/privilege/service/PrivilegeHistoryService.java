package com.romanov.privilege.service;

import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;

import java.util.UUID;

public interface PrivilegeHistoryService {
    PrivilegeHistoryOutput getByTicketUid(UUID ticketUid);
}