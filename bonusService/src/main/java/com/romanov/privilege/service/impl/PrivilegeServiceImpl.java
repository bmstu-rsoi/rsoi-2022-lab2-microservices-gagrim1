package com.romanov.privilege.service.impl;

import com.romanov.privilege.exception.NotFoundException;
import com.romanov.privilege.model.PrivilegeEntity;
import com.romanov.privilege.model.dto.DiscountOutput;
import com.romanov.privilege.model.dto.PrivilegeHistoryOutput;
import com.romanov.privilege.model.dto.PrivilegeOutput;
import com.romanov.privilege.model.mapper.PrivilegeMapper;
import com.romanov.privilege.repository.PrivilegeRepository;
import com.romanov.privilege.service.PrivilegeHistoryService;
import com.romanov.privilege.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository repository;
    private final PrivilegeMapper mapper;
    private final PrivilegeHistoryService historyService;

    @Override
    public PrivilegeOutput get(String username) {
        PrivilegeEntity entity = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User do not have a privilege."));
        return mapper.convert(entity);
    }

    @Override
    @Transactional
    public void deposit(Integer id, Integer price) {
        Double cashback = price * 0.1;
        repository.deposit(id, cashback.intValue());
        log.info(cashback + " was deposited to the privilege with id: " + id);
    }

    @Override
    public DiscountOutput discountPrice(Integer id, Integer price) {
        PrivilegeEntity entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Privilege with id: " + id + " not found!"));
        int balance = entity.getBalance();
        int priceAfterDiscount;
        int difference = price - balance;

        if (difference > 0) {
            priceAfterDiscount = difference;
            balance = 0;
        } else {
            priceAfterDiscount = 0;
            balance = -difference;
        }
        updateBalance(entity, balance);

        log.info("Price: " + price + " was withdrawn from " + entity.getUsername() + "'s bonus account");
        return DiscountOutput.builder()
                .privilegeId(id)
                .price(price)
                .priceAfterDiscount(priceAfterDiscount)
                .priceDifference(price - priceAfterDiscount)
                .newBalance(balance)
                .build();
    }

    public void updateBalance(PrivilegeEntity entity, Integer newBalance) {
        entity.setBalance(newBalance);
        repository.save(entity);
    }

    @Override
    public void returnBonus(String username, UUID ticketUid) {
        PrivilegeHistoryOutput history = historyService.getByTicketUid(ticketUid);
        PrivilegeEntity privilege = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(""));
        String operationType = history.getOperationType();
        Integer balance = privilege.getBalance();
        Integer balanceDiff = history.getBalanceDiff();
        if (operationType.equals("FILL_IN_BALANCE")) {
            privilege.setBalance(balance - balanceDiff);
        } else if (operationType.equals("DEBIT_THE_ACCOUNT")) {
            privilege.setBalance(balance + balanceDiff);
        }
        repository.save(privilege);
    }

}
