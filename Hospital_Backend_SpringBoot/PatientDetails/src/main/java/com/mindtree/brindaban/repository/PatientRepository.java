package com.mindtree.brindaban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.brindaban.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	// Use for Patient JUnit Testing
	@Query(value = "SELECT * FROM patient WHERE name=:name", nativeQuery = true)
	Patient byName(String name);

	// Patient count send to doctor microsevices for showing the front end page nonOfPatient
	@Query(value = "SELECT COUNT(id) AS noOfPatient FROM patient WHERE visited_doctor=:docId", nativeQuery = true)
	int countPatByDoc(long docId);
}
