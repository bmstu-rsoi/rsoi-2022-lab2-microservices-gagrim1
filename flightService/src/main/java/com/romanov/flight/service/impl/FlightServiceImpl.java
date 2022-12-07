package com.romanov.flight.service.impl;

import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.model.dto.PaginationOutput;
import com.romanov.flight.repository.FlightRepository;
import com.romanov.flight.service.FlightService;
import com.romanov.flight.service.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final FlightMapper mapper;

    @Override
    public PaginationOutput getAll(Integer page, Integer size) {
        Page<FlightOutput> flights = repository
                .findAll(PageRequest.of(page - 1, size))
                .map(mapper::convert);
        return mapper.convert(page, size, flights);
    }
}
