package com.mindtree.brindaban;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mindtree.brindaban.controller.DoctorController;
import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;

@SpringBootTest
class DoctorDetailsApplicationTests {

	@Autowired
	DoctorController dControl;

	@Test
	void testList() throws CustomException {
		assertThat(dControl.list().size()).isGreaterThan(0);
	}

	@Test
	void testAdd() {
		Doctor p1 = null;
		try {
			p1 = new Doctor(34, "Sanjeeban Roy", 52, "Male", "Specialist Heart Surgeon");
		} catch (Exception e) {
			e.printStackTrace();
		}

		dControl.add(p1);

	}

	@Test
	void testListPatient() throws CustomException {
		assertThat(dControl.list().size()).isGreaterThan(0);
	}

}
