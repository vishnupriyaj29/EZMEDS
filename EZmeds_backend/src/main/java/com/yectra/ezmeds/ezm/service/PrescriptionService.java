package com.yectra.ezmeds.ezm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yectra.ezmeds.ezm.model.Patient;
import com.yectra.ezmeds.ezm.model.Prescription;

@Service
public interface PrescriptionService {
	
	List<Prescription> getAll();
	ResponseEntity<Prescription> getOne(String drId,String patientId);
	ResponseEntity<Prescription> insert(Prescription prescription);
	ResponseEntity<Prescription> update(Prescription prescription);
	Patient delete(String id);
}
