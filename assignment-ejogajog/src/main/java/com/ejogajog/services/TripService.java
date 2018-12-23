package com.ejogajog.services;

import com.ejogajog.entities.Trip;


public interface TripService {

	Trip save(Trip trip);

	Iterable<Trip> getAll();

}
