package com.ejogajog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejogajog.entities.Trip;

@Transactional
public interface TripRepositoryCrud extends PagingAndSortingRepository<Trip, Long> {

}
