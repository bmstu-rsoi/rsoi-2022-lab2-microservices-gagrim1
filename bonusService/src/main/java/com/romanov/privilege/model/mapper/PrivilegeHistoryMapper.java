package com.romanov.privilege.model.mapper;

import com.romanov.privilege.model.PrivilegeHistoryEntity;
import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeHistoryMapper {
    public PrivilegeHistoryOutput convert(PrivilegeHistoryEntity entity) {
        return  PrivilegeHistoryOutput.builder()
                .id(entity.getId())
                .privilegeId(entity.getPrivilegeId().getId())
                .ticketUid(entity.getTicketUid())
                .dateTime(entity.getDateTime())
                .balanceDiff(entity.getBalanceDiff())
                .operationType(entity.getOperationType())
                .build();
    }
}
