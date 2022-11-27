package com.romanov.privilege.model.dto;

import lombok.Data;

@Data
public class BonusOutput {
    private Integer paidByMoney;
    private Integer paidByBonus;
    private PrivilegeOutput privilege;
}
