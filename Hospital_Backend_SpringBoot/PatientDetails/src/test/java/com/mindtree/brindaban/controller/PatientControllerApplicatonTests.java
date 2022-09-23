package com.mindtree.brindaban.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.repository.PatientRepository;

@SpringBootTest
public class PatientControllerApplicatonTests {

	@Autowired
	PatientController patControl;

	@Autowired
	PatientRepository patRepo;

	@Test
	void testAdd() {  
		Patient p1 = null;
		try {
			p1 = new Patient(18, "Bikash Roy", 36, 3L, new SimpleDateFormat("yyyy-MM-dd").parse("2022-08-22"),
					"High Feaver");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		patControl.add(p1);

		assertEquals("Bikash Roy", patRepo.byName("Bikash Roy").getName());
	}
	
	@Test
	void testlist() {
		assertThat(patControl.Patlist().size()).isGreaterThan(0);
	}
}