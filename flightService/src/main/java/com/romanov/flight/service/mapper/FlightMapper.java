package com.romanov.flight.service.mapper;

import com.romanov.flight.model.FlightEntity;
import com.romanov.flight.model.dto.FlightOutput;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightOutput convert(FlightEntity entity) {
        return new FlightOutput(
                entity.getId(),
                entity.getFlightNumber(),
                entity.getDateTime(),
                entity.getFromAirportId().getId(),
                entity.getToAirportId().getId(),
                entity.getPrice());
    }
}
