package com.romanov.flight.service;

import com.romanov.flight.model.dto.PaginationOutput;

public interface FlightService {
    PaginationOutput getAll(Integer page, Integer size);
}
