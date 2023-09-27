package com.javatpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.CategoryENUM;
import com.javatpoint.model.Item;
import com.javatpoint.service.BoxService;
import com.javatpoint.service.ItemService;
import com.javatpoint.service.ShelfService;

//creating RestController
@CrossOrigin(origins = "http://192.168.0.102:4200", maxAge = 3600)
@RestController
public class ItemController {
//autowired the StudentService class
	@Autowired
	private ItemService service;
	
	@Autowired
	private ShelfService shelfService;
	
	@Autowired
	private BoxService boxService;
	
	@GetMapping("/getAllShelves")
	private String getAllShelves(Model model) {
		model.addAttribute("getAllShelves", shelfService.getAllShelf());
        return "index";
	}
	
//creating a get mapping that retrieves all the students detail from the database 
	@GetMapping("/")
	private String getAllItems(Model model) {
		model.addAttribute("getAllItems", service.getAllItems());
		model.addAttribute("getAllShelves", shelfService.getAllShelf());
		model.addAttribute("getAllBoxes", boxService.getAllBox());
		model.addAttribute("getAllCategory", CategoryENUM.values());
        return "index";
	}

	@GetMapping("/loadAllBoxes")
	public String isSelected(Model model){
		model.addAttribute("getAllBoxes", boxService.getAllBox());
		return "index";
    } 
	
//creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/Item/{id}")
	private Item getItem(@PathVariable("id") int id) {
		return service.getItemByName(id);
	}

//creating a delete mapping that deletes a specific student
	@GetMapping("/deleteItem/{id}")
	private Item deleteItem(@PathVariable("id") int id) {
		service.delete(id);
		return new Item();
	}
//creating post mapping that post the student detail in the database
}
