package com.javatpoint.service;

import com.javatpoint.model.Box;
import com.javatpoint.model.Item;
import com.javatpoint.model.Shelf;

import com.javatpoint.repository.BoxRepository;
import com.javatpoint.repository.ItemRepository;
import com.javatpoint.repository.ShelfRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//defining the business logic
@Service public class ItemService {
    @Autowired ShelfRepository shelfRepository;

    @Autowired BoxRepository boxRepository;

    @Autowired ItemRepository itemRepository;

//getting all shelf records
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> items.add(item));

        return items;
    }

//getting a specific record
    public Item getItemByName(int id) {
        return itemRepository.findById(id).get();
    }

    public String saveOrUpdate(Item item, int shelfId, int boxId) {

        if (boxId > 0) {
            Optional<Box> boxOpt = boxRepository.findById(boxId);

            if (boxOpt.isPresent()) {
                item.setBox(boxOpt.get());
            }
        }

        if (shelfId > 0) {
            Optional<Shelf> boxOpt = shelfRepository.findById(shelfId);

            if (boxOpt.isEmpty()) {
                return null;
            }

            item.setShelf(boxOpt.get());
        }

        Item savedItem = itemRepository.save(item);

        return savedItem.getItemName();
    }

//deleting a specific record
    public void delete(int id) {
        itemRepository.deleteById(id);
    }
}
