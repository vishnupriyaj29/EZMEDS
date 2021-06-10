package com.yectra.ezmeds.ezm.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.yectra.ezmeds.ezm.model.Doctor;

@Service
public interface DoctorService {
	
	List<Doctor> getAll();
	ResponseEntity<Doctor> getDrDetail(String id);
//	Optional<Doctor> getDrDetail(String email);
	Doctor insert(Doctor doctor);
	ResponseEntity<Doctor> update(Doctor doctor);
	Doctor delete(String id);
	
}
