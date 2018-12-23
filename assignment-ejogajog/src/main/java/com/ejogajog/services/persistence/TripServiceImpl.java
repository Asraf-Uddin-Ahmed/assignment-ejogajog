package com.ejogajog.services.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejogajog.entities.Trip;
import com.ejogajog.repositories.TripRepository;
import com.ejogajog.services.TripService;


@Service
@Transactional
public class TripServiceImpl implements TripService {

	private TripRepository tripRepository;

	@Autowired
	public TripServiceImpl(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}

	public Trip save(Trip trip) {
		return tripRepository.save(trip);
	}

	public Iterable<Trip> getAll() {
		return tripRepository.findAll();
	}

}
