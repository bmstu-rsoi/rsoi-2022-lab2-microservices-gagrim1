package com.romanov.flight.model.dto;

import lombok.Builder;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Value
public class FlightOutput {
    Integer id;
    String flightNumber;
    String dateTime;
    String fromAirport;
    String toAirport;
    Integer price;
}
