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

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.service.PatientService;
import com.mindtree.brindaban.valueobject.PatientWithDoctor;

//Synchronizing controller layer with RestAPI
@RestController

//To Perform the CRUD operation
@RequestMapping("/patient")
public class PatientController {

// Created an object of doc service ---DI	
	@Autowired
	PatientService patServe;

// To Add Patient values	
	@PostMapping("/add")
	public Patient add(@RequestBody Patient patient) { // Maps httpRequest body to bind the domain object
		return patServe.add(patient);
	}

// It will return the Patient details along with doctor name to the patient search page table (from ValueObject package)
	@GetMapping("/search/{id}")
	public PatientWithDoctor searchById(@PathVariable long id) throws CustomException { // It will bind the value from
																						// the URI(uniform resource
																						// identifier) to local java
																						// variable
		try {
			return patServe.searchById(id);
		} catch (CustomException e) {
			throw new CustomException(e.getMessage());
		}
	}

	@GetMapping("/patient-of-doctor/{docId}") // This method called by doctor microservice internally for getting
												// patient count
	public int numberOfPatientInDoctor(@PathVariable long docId) {
		return patServe.numberOfPatientInDoctor(docId);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) throws CustomException {
		patServe.deleteById(id);
	}
	
	public List<Patient> Patlist(){ // this is use for JUnit Testing
	return patServe.patientlist();	
	}
}