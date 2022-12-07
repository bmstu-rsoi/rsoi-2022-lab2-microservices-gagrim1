package com.romanov.privilege.service;

import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.dto.*;

import java.util.UUID;

public interface PrivilegeService {
    PrivilegeOutput get(String username);
    PrivilegeResponse getWithHistory(String username);
    BonusOutput calculatePrice(CalculationPriceInput input);
    Integer deposit(Integer id, Integer price);
    DiscountOutput discountPrice(PrivilegeEntity entity, Integer price);
    void returnBonus(String username, UUID ticketUid);
}
