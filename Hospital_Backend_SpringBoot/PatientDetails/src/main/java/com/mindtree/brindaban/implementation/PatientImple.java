package com.mindtree.brindaban.implementation;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.repository.PatientRepository;
import com.mindtree.brindaban.service.PatientService;
import com.mindtree.brindaban.valueobject.PatientWithDoctor;

@Component
public class PatientImple implements PatientService {
	
	

	@Autowired
	PatientRepository patRepo;

	
	// Created an object of rest template ---DI
	@Autowired
	RestTemplate restTemplate;

	
	
	@Override
	public Patient add(Patient patient) {
		return patRepo.save(patient);
	}

	
	
	
    // It will return the Patient details along with doctor name to the patient  search page (from ValueObject package)	
	@Override
	public PatientWithDoctor searchById(long id) throws CustomException {

		Optional<Patient> patient=patRepo.findById(id);// it will throw null pointer exception , thats why we use Optional class

	
		if(patient.isPresent()) {
			
			Patient pat=patient.get(); // if respective Patient is present in optional class then it will assign patient object
			
			String visitedDoctorName= restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/get-name/"+pat.getVisitedDoctor(),String.class);
			PatientWithDoctor patWdoc= new PatientWithDoctor(pat.getId(),pat.getName(),
					pat.getAge(),visitedDoctorName,pat.getDataOfVist(),pat.getPrescription()); 
			return patWdoc;
		}
		
		throw new CustomException("No Such Patient found in the database");	
					
		}
	
	
	
	@Override
	public int numberOfPatientInDoctor(long docId) {
		return patRepo.countPatByDoc(docId);
	}

	
	
	
	@Override
	public void deleteById(long id) {
		patRepo.deleteById(id);
	}


	@Override
	public List<Patient> patientlist() {  // This is for JUnit testing only it will return the list of patient
		return patRepo.findAll();
	}
}