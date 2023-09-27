package com.javatpoint.repository;

import com.javatpoint.model.Shelf;

import org.springframework.data.repository.CrudRepository;


public interface ShelfRepository extends CrudRepository<Shelf, Integer> {
}
