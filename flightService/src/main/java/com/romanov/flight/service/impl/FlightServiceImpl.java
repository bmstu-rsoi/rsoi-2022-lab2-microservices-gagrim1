package com.romanov.flight.service.impl;

import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.repository.FlightRepository;
import com.romanov.flight.service.FlightService;
import com.romanov.flight.service.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final FlightMapper mapper;

    @Override
    public Page<FlightOutput> getAll(Integer page, Integer size) {
        List<FlightOutput> outputs = repository.findAll()
                .stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
        return new PageImpl<>(outputs, PageRequest.of(page, size), outputs.size());
    }
}