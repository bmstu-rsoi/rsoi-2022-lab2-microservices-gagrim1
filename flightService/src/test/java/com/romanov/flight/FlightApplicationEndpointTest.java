package com.romanov.flight;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql(value = {
        "/endpoint/flight_init.sql"
},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/endpoint/truncate_flights.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FlightApplicationEndpointTest extends EndpointTest {
    @Test
    void shouldReturnFlights() throws Exception {
        mockMvc.perform(get("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("page", "1")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content.[0].id").value(1))
                .andExpect(jsonPath("$.content.[0].flightNumber").value("AFL031"));
    }

}
