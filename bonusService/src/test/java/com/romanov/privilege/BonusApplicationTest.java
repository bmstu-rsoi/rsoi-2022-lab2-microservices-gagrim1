package com.romanov.privilege;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = {
        "/endpoint/privilege_init.sql"
},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/endpoint/truncate.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class BonusApplicationTest extends EndpointTest {
    @Test
    void shouldReturnPrivilege() throws Exception {
        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Roman"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(500));
        //todo create tests
    }

    @Test
    void shouldDiscountPrice() throws Exception {
        mockMvc.perform(post("/privileges/discount")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
                        .param("price", "1500"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.privilegeId").value(1))
                .andExpect(jsonPath("$.price").value(1500))
                .andExpect(jsonPath("$.priceAfterDiscount").value(1000))
                .andExpect(jsonPath("$.priceDifference").value(500))
                .andExpect(jsonPath("$.newBalance").value(0));
    }

    @Test
    void shouldDeposit() throws Exception {
        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Roman"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(500));

        mockMvc.perform(post("/privileges/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1")
                        .param("price", "2000"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Roman"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(700));
    }

    @Test
    void shouldReturnWithdrawing() throws Exception {
        mockMvc.perform(delete("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman")
                        .param("ticketUid", "d6818ec1-3d27-4a14-b660-1922b14c515d"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Roman"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(2000));
    }

    @Test
    void shouldReturnDepositing() throws Exception {
        mockMvc.perform(delete("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman")
                        .param("ticketUid", "6c10f0e9-170c-4d69-bc8b-56f303e59a10"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Roman"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(300));
    }
}
