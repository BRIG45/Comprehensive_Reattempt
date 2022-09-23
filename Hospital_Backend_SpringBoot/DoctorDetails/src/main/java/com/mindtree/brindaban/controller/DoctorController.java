package com.mindtree.brindaban.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.service.DoctorService;
import com.mindtree.brindaban.valueobject.DoctorWithPatient;

//Synchronizing controller layer with RestAPI
@RestController


// To Perform the CRUD operation
@RequestMapping("/doctor")
public class DoctorController {
	
	
// Created an object of doc service ---DI
	@Autowired
	DoctorService docService;

	
// To Add Doc values
	@PostMapping
	public Doctor add(@RequestBody Doctor doc) {  // Maps httpRequest body to bind the domain object
		return docService.add(doc);
	}
	
	
	
// To select the doctor name from the drop down menu of Patient creation component and search doctor component 
	@GetMapping
	public List<Doctor> list() throws CustomException {
		if (docService.list().isEmpty()) {
			throw new CustomException("No such doctor there in the database");
		}
		return docService.list();
	}

	
	
// It will return the doctor details along with patient count to the doctor search page (from ValueObject package)	
	@GetMapping("/search-by-id/{id}")
	public DoctorWithPatient getByID(@PathVariable long id) throws CustomException { // It will bind the value from the URI(uniform resource identifier) to local java variable
		try {
			return docService.getById(id);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	
// For delete Doctor corresponding ID
	@DeleteMapping("/delete/{id}")
	public Doctor delete(@PathVariable long id) throws CustomException {
		return docService.delete(id);
	}

	
	
// It is use for getting name of the doctor to return string (doctor name) to Patient microservices 	
	@GetMapping("/get-name/{id}")
	public String getName(@PathVariable long id) {
		return docService.getName(id);
	}
}