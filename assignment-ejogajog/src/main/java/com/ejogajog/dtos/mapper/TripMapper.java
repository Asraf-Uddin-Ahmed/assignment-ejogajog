package com.ejogajog.dtos.mapper;

import com.ejogajog.dtos.request.entities.TripRequestDto;
import com.ejogajog.dtos.response.entities.TripResponseDto;
import com.ejogajog.entities.Trip;

public interface TripMapper extends RequestResponseDtoMapper<Trip, TripResponseDto, TripRequestDto> {

}
