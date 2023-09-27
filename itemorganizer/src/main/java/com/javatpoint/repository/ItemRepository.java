package com.javatpoint.repository;

import com.javatpoint.model.Item;

import org.springframework.data.repository.CrudRepository;


public interface ItemRepository extends CrudRepository<Item, Integer> {
}
