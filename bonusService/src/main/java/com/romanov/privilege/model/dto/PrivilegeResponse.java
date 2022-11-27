package com.romanov.privilege.model.dto;

import lombok.Value;

import java.util.List;

@Value
public class PrivilegeResponse {
    PrivilegeOutput output;
    List<PrivilegeHistoryOutput> history;
}
