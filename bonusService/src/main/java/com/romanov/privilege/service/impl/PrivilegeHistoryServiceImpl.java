package com.romanov.privilege.service.impl;

import com.romanov.privilege.exception.NotFoundException;

import com.romanov.privilege.model.PrivilegeHistoryEntity;
import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import com.romanov.privilege.model.mapper.PrivilegeHistoryMapper;
import com.romanov.privilege.repository.PrivilegeHistoryRepository;
import com.romanov.privilege.service.PrivilegeHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrivilegeHistoryServiceImpl implements PrivilegeHistoryService {
    private final PrivilegeHistoryRepository repository;
    private final PrivilegeHistoryMapper mapper;

    @Override
    public PrivilegeHistoryOutput getByTicketUid(UUID ticketUid) {
        PrivilegeHistoryEntity entity = repository.findByTicketUid(ticketUid)
                .orElseThrow(() -> new NotFoundException(""));
        return mapper.convert(entity);
    }
}
