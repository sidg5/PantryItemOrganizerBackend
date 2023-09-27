package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Shelf;
public interface ShelfRepository extends CrudRepository<Shelf, Integer>
{
}
