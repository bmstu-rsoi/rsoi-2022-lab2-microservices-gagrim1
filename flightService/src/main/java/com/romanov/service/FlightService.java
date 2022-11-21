package com.romanov.service;

import com.romanov.model.dto.FlightOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    Page<FlightOutput> getAll(Integer page, Integer size);
}
