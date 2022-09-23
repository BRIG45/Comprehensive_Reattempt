package com.mindtree.brindaban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.valueobject.PatientWithDoctor;


@Service
public interface PatientService {

	public Patient add(Patient patient);

	public PatientWithDoctor searchById(long id) throws CustomException;

	public int numberOfPatientInDoctor(long docId);

	public void deleteById(long id);
	
	public List<Patient> patientlist();
	
}
