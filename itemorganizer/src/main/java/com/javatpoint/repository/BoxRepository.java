package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Box;
public interface BoxRepository extends CrudRepository<Box, Integer>
{
}
