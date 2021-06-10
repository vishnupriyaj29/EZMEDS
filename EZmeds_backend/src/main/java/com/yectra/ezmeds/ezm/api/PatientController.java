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


import com.yectra.ezmeds.ezm.model.Doctor;
import com.yectra.ezmeds.ezm.model.Patient;

import com.yectra.ezmeds.ezm.service.PatientService;

@RestController

@RequestMapping("/v1/api/patient")
public class PatientController {

	@Autowired
	public PatientService patientService;

	@GetMapping("/all")
	public List<Patient> getAll() {
		return patientService.getAll();
	}

	@GetMapping("/{drId}")
	public ResponseEntity<List<Doctor>> get(@PathVariable("drId") String drId) {
		return patientService.getOne(drId);
	}

	@PostMapping("/{drId}")
	public ResponseEntity<Patient> insert(@RequestBody Patient patient,@PathVariable("drId") String drId) {
		return patientService.insert(patient,drId);
	}

	@PutMapping
	public ResponseEntity<Patient> update(@RequestBody Patient patient) {
		return patientService.update(patient);
	}

//	@DeleteMapping("/{id}")
//	public Patient delete(@PathVariable("id") String id) {
//		return patientService.delete(id);
//	}
	
}
