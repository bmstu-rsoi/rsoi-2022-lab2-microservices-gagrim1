package com.romanov.privilege.endpoint;

import com.romanov.privilege.model.dto.DiscountOutput;
import com.romanov.privilege.model.dto.PrivilegeOutput;
import com.romanov.privilege.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/privileges")
@RequiredArgsConstructor
public class PrivilegeEndpoint {
    private final PrivilegeService service;

    @GetMapping
    public PrivilegeOutput get(@RequestHeader("X-User-Name") String username) {
        return service.get(username);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam("id") Integer id,
                        @RequestParam("price") Integer price) {
        service.deposit(id, price);
    }

    @PostMapping("/discount")
    public DiscountOutput discountPrice(@RequestParam("id") Integer id,
                                        @RequestParam("price") Integer price) {
        return service.discountPrice(id, price);
    }

    @DeleteMapping
    public void returnBonus(@RequestHeader("X-User-Name") String username,
                            @RequestParam("ticketUid") UUID ticketUid) {
        service.returnBonus(username, ticketUid);
    }
}
