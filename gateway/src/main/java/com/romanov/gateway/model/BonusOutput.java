package com.romanov.gateway.model;

import lombok.Value;

@Value
public class BonusOutput {
    Integer paidByMoney;
    Integer paidByBonus;
    PrivilegeOutput privilege;
}
