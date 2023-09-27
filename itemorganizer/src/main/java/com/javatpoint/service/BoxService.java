package com.javatpoint.service;

import com.javatpoint.model.Box;
import com.javatpoint.model.Shelf;

import com.javatpoint.repository.BoxRepository;
import com.javatpoint.repository.ShelfRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//defining the business logic
@Service public class BoxService {
    @Autowired ShelfRepository shelfRepository;

    @Autowired BoxRepository boxRepository;

//getting all shelf records
    public List<Box> getAllBox() {
        List<Box> boxes = new ArrayList<Box>();
        boxRepository.findAll().forEach(box -> boxes.add(box));

        return boxes;
    }

//getting a specific record
    public Box getBoxById(int id) {
        return boxRepository.findById(id).get();
    }

    public Integer saveOrUpdate(Box box, int shelfId) {
        Optional<Shelf> shelfOpt = shelfRepository.findById(shelfId);

        if (shelfOpt.isEmpty()) {
            return -1;
        }

        box.setShelf(shelfOpt.get());

        Box savedStudent = boxRepository.save(box);

        return savedStudent.getBoxId();
    }

//deleting a specific record
    public void delete(int id) {
        boxRepository.deleteById(id);
    }

    public List<Box> getAllBoxesForShelf(int id) {
        List<Box> boxes = new ArrayList<Box>();
        Optional<Shelf> shelfOpt = shelfRepository.findById(id);

        if (shelfOpt.isPresent()) {
            boxes = shelfOpt.get().box;
        }

        return boxes;
    }
}
