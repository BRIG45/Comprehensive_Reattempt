package com.mindtree.brindaban.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.repository.DoctorRepository;
import com.mindtree.brindaban.service.DoctorService;
import com.mindtree.brindaban.valueobject.DoctorWithPatient;

@Component
public class DoctorImple implements DoctorService {

	@Autowired
	DoctorRepository DocRepo;

    // Created an object of rest template ---DI
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Doctor add(Doctor doc) {
		return DocRepo.save(doc);
	}

	@Override
	public List<Doctor> list() { // It will return the list of the doctor search and drop down menu and patient create page drop down
		return DocRepo.findAll();
	}

	@Override
	public Doctor delete(long id) {
		Doctor doctor = DocRepo.findById(id).get();
		DocRepo.deleteById(id);
		return doctor;
	}

	@Override
	public String getName(long id) { 
		return DocRepo.getName(id);
	}

	@Override
	public DoctorWithPatient getById(long id) throws CustomException { // It will return the doctor details along with patient count to the doctor search page (from ValueObject package)

		Optional<Doctor> doc = DocRepo.findById(id); // it will throw null pointer exception , thats why we use Optional class

		if (doc.isPresent()) {
			Doctor doctor = doc.get(); // if respective doctor is present in optional class then it will assign doctor object

			Integer numberOfPateint = restTemplate
					.getForObject("http://PATIENT-SERVICE/patient/patient-of-doctor/" + id, Integer.class);

			DoctorWithPatient docWpat = new DoctorWithPatient(doctor.getId(), doctor.getName(), doctor.getAge(),
					doctor.getGender(), doctor.getSpecialist(), numberOfPateint);

			return docWpat;
		}
		throw new CustomException("No such Doctor found in the database");
	}
}
