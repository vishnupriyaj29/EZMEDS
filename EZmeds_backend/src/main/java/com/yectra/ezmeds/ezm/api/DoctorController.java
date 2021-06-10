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

import com.yectra.ezmeds.ezm.exception.ValidationException;
import com.yectra.ezmeds.ezm.model.Doctor;

import com.yectra.ezmeds.ezm.service.DoctorService;

@RestController
@RequestMapping("/v1/api/doctor")
public class DoctorController {

	@Autowired
	public DoctorService doctorService;

	@GetMapping("/all")
	public List<Doctor> getAll() {
		return doctorService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getOne(@PathVariable("id") String id) throws ValidationException {
		if (id == null) {
			throw new ValidationException(id, "String");
		}
		return doctorService.getDrDetail(id);
	}

	@PostMapping
	public Doctor insert(@RequestBody Doctor doctor) {
		return doctorService.insert(doctor);
	}

	@PutMapping
	public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
		return doctorService.update(doctor);
	}

//	@DeleteMapping
//	public ResponseEntity<Doctor> delete(@PathVariable("id") String Id) {
//		Doctor existingUser = this.doctorrepository.findById(Id)
//				.orElseThrow(() -> new ResourceNotFoundException("Userid : " + Id + " not found"));
//		this.doctorrepository.delete(existingUser);
//		return ResponseEntity.ok().build();
//	}

}
