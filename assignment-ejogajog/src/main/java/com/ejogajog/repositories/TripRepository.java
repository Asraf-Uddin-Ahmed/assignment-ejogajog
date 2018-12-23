package com.ejogajog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ejogajog.entities.Trip;

@Transactional
public interface TripRepository extends TripRepositoryCrud, JpaSpecificationExecutor<Trip> {

}
