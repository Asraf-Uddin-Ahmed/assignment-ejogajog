package com.ejogajog.dtos.mapper.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ejogajog.dtos.mapper.TripMapper;
import com.ejogajog.dtos.request.entities.TripRequestDto;
import com.ejogajog.dtos.response.entities.TripResponseDto;
import com.ejogajog.entities.Trip;

@Component
@Scope(value = "prototype")
public class TripMapperImpl extends RequestResponseDtoMapperImpl<Trip, TripResponseDto, TripRequestDto>
		implements TripMapper {

	protected TripMapperImpl(ModelMapper modelMapper) {
		super(modelMapper, TripResponseDto.class, Trip.class);
	}

}
