package com.romanov.service.mapper;

import com.romanov.model.FlightEntity;
import com.romanov.model.dto.FlightOutput;
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
