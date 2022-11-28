package com.romanov.flight.service;

import com.romanov.flight.model.dto.FlightOutput;
import org.springframework.data.domain.Page;

public interface FlightService {
    Page<FlightOutput> getAll(Integer page, Integer size);
}
