package com.romanov.privilege.service;

import com.romanov.privilege.model.dto.DiscountOutput;
import com.romanov.privilege.model.dto.PrivilegeOutput;

import java.util.UUID;

public interface PrivilegeService {
    PrivilegeOutput get(String username);
    void deposit(Integer id, Integer price);
    DiscountOutput discountPrice(Integer id, Integer price);
    void returnBonus(String username, UUID ticketUid);
}
