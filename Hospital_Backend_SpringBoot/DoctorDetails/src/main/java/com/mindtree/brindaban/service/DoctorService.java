package com.mindtree.brindaban.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.valueobject.DoctorWithPatient;

@Service
public interface DoctorService {

	public Doctor add(Doctor doc); // create add doctor 

	public List<Doctor> list(); // return list of doctor to PE & DS

	public DoctorWithPatient getById(long id) throws CustomException; // return list of doctor of VO obj

	public Doctor delete(long id) throws CustomException; // for delete operation 

	public String getName(long id); 
}
