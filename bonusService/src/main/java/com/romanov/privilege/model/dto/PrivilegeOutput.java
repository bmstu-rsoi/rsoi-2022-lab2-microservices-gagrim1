package com.romanov.privilege.model.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PrivilegeOutput {
    Integer id;
    String username;
    String status;
    Integer balance;

}
