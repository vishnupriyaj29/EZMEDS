package com.yectra.ezmeds.ezm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yectra.ezmeds.ezm.model.Doctor;
import com.yectra.ezmeds.ezm.model.Patient;

@Service
public interface PatientService {
	
	List<Patient> getAll();
	
	ResponseEntity<List<Doctor>> getOne(String drId);
	ResponseEntity<Patient> insert(Patient patient, String drId);
	ResponseEntity<Patient> update(Patient patient);
//	Patient delete(String id);
}
