package com.javatpoint.repository;

import com.javatpoint.model.Box;

import org.springframework.data.repository.CrudRepository;


public interface BoxRepository extends CrudRepository<Box, Integer> {
}
