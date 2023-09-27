package com.javatpoint.service;

import com.javatpoint.model.Shelf;

import com.javatpoint.repository.ShelfRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//defining the business logic
@Service public class ShelfService {
    @Autowired ShelfRepository shelfRepository;

//getting all shelf records
    public List<Shelf> getAllShelf() {
        List<Shelf> shelfs = new ArrayList<Shelf>();
        shelfRepository.findAll().forEach(shelf -> shelfs.add(shelf));

        return shelfs;
    }

//getting a specific record
    public Shelf getShelfById(int id) {
        return shelfRepository.findById(id).get();
    }

    public List<Integer> saveOrUpdate(List<Shelf> shelfs) {
        List<Integer> ids = new ArrayList<Integer>();

        for (Shelf shelf : shelfs) {
            Shelf savedShelf = shelfRepository.save(shelf);

            ids.add(savedShelf.getShelfId());
        }

        return ids;
    }

//deleting a specific record
    public void delete(int id) {
        Optional<Shelf> shelf = shelfRepository.findById(id);

        if (shelf.isPresent()) {
            System.out.println(shelf.get().toString());
        }

        shelfRepository.deleteById(id);
    }
}
