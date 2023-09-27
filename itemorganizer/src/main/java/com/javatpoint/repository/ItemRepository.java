package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Item;
public interface ItemRepository extends CrudRepository<Item, Integer>
{
}
