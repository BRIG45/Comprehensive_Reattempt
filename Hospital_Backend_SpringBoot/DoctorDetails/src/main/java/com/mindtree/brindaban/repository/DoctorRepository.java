package com.mindtree.brindaban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.brindaban.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	// Here Doctor id send Doctor name to Patient Microservices
	@Query(value = "SELECT name FROM doctor WHERE id=:id", nativeQuery = true)
	String getName(long id);
}
