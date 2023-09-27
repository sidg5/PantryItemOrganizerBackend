package com.javatpoint.controller;

import com.javatpoint.model.Box;
import com.javatpoint.model.CategoryENUM;
import com.javatpoint.model.Item;

import com.javatpoint.service.BoxService;
import com.javatpoint.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//creating RestController
@CrossOrigin(
    origins = "http://192.168.0.102:4200",
    maxAge = 3600
)
@RestController
@RequestMapping("/itemorganizer")
public class BoxController {
//autowired the StudentService class
    @Autowired BoxService service;

    @Autowired ItemService itemService;

//creating a get mapping that retrieves all the students detail from the database
    @GetMapping("/getAllBoxes")
    private List<Box> getAllBoxes() {
        return service.getAllBox();
    }

    @GetMapping("/getAllBoxesForShelf/{id}")
    private List<Box> getAllBoxesForShelf(@PathVariable("id") int id) {
        return service.getAllBoxesForShelf(id);
    }

    @GetMapping("/getAllItems")
    private List<Item> getAllItems() {
        return itemService.getAllItems();
    }


//creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/Box/{id}")
    private Box getBox(@PathVariable("id") int id) {
        return service.getBoxById(id);
    }

//creating a delete mapping that deletes a specific student
    @DeleteMapping("/box/{id}")
    private void deleteBox(@PathVariable("id") int id) {
        service.delete(id);
    }

//creating post mapping that post the student detail in the database
    @PostMapping("/box")
    private Integer saveBox(@RequestBody Box box,
        @Param(value = "shelfId") int shelfId) {

        return service.saveOrUpdate(box, 1);
    }

    @PostMapping("/addbox/{shelfId}")
    public Integer addBox(@PathVariable(value = "shelfId") int shelfId,
        @RequestBody Box box) {
        return service.saveOrUpdate(box, shelfId);
    }

    @PostMapping("/addItem/{shelfId}/{boxId}")
    public void addItem(@PathVariable(value = "shelfId") int shelfId,
        @PathVariable(value = "boxId") int boxId, @RequestBody Item item) {
        itemService.saveOrUpdate(item, shelfId, boxId);
    }

    @GetMapping("/category")
    public CategoryENUM[] getCategories() {
        return CategoryENUM.values();
    }

}
