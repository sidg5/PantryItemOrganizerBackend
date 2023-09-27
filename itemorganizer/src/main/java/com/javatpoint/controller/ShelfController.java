package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.Shelf;
import com.javatpoint.model.Student;
import com.javatpoint.service.ShelfService;
import com.javatpoint.service.StudentService;

//creating RestController
@CrossOrigin(origins = "http://192.168.0.102:4200", maxAge = 3600)
@RestController
public class ShelfController {
//autowired the StudentService class
	@Autowired
	ShelfService service;

//creating a get mapping that retrieves all the students detail from the database 
	@GetMapping("/getAllShelfs")
	private List<Shelf> getAllShelfs() {
		return service.getAllShelf();
	}

//creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/shelf/{id}")
	private Shelf getShelf(@PathVariable("id") int id) {
		return service.getShelfById(id);
	}

//creating a delete mapping that deletes a specific student
	@DeleteMapping("/shelf/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		service.delete(id);
	}

//creating post mapping that post the student detail in the database
	@PostMapping("/shelf")
	private List<Integer> saveStudent(@RequestBody List<Shelf> shelf) {

		return service.saveOrUpdate(shelf);
	}
}
