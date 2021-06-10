package com.yectra.ezmeds.ezm.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yectra.ezmeds.ezm.model.Prescription;

import com.yectra.ezmeds.ezm.service.PrescriptionService;

@RestController
@RequestMapping("/v1/api/prescription")
public class PrescriptionController {
	
	@Autowired
	public PrescriptionService prescriptionService;
	
	@GetMapping("/all")
	public List<Prescription> getAll() {
		return prescriptionService.getAll();
	}
	
	@GetMapping("/{drId}/{patientId}")
	public ResponseEntity<Prescription> getOne(@PathVariable("drId") String drId,@PathVariable("patientId") String patientId) {
		return prescriptionService.getOne(drId,patientId);
	}
	
	@PostMapping
	public ResponseEntity<Prescription> insert(@RequestBody Prescription prescription) {
		return prescriptionService.insert(prescription);
	}

	@PutMapping
	public ResponseEntity<Prescription> update(@RequestBody Prescription prescription) {
		return prescriptionService.update(prescription);
	}
}
