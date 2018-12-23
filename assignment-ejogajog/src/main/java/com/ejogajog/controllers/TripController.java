package com.ejogajog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejogajog.dtos.mapper.TripMapper;
import com.ejogajog.dtos.request.entities.TripRequestDto;
import com.ejogajog.dtos.response.entities.TripResponseDto;
import com.ejogajog.entities.Trip;
import com.ejogajog.services.TripService;

@RestController
@RequestMapping("/trips")
public class TripController extends BaseController {

	private TripService tripService;
	private TripMapper tripMapper;

	@Autowired
	public TripController(TripService tripService, TripMapper tripMapper) {
		this.tripService = tripService;
		this.tripMapper = tripMapper;
	}

	@GetMapping("")
	public List<TripResponseDto> getAll() {
		return tripMapper.getResponseDtos(tripService.getAll());
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public TripResponseDto create(@Valid @RequestBody TripRequestDto requestDto) {
		Trip trip = tripMapper.getEntity(requestDto);
		tripService.save(trip);
		return tripMapper.getResponseDto(trip);
	}

}
