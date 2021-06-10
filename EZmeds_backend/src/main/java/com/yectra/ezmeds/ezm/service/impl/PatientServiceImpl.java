package com.yectra.ezmeds.ezm.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yectra.ezmeds.ezm.exception.ResourceNotFoundException;
import com.yectra.ezmeds.ezm.model.Doctor;
import com.yectra.ezmeds.ezm.model.Patient;
import com.yectra.ezmeds.ezm.repo.DoctorRepository;
import com.yectra.ezmeds.ezm.repo.PatientRepository;
import com.yectra.ezmeds.ezm.service.PatientService;

@Service("patientService")
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public ResponseEntity<Patient> insert(Patient patient, String drId) {
		if(!doctorRepository.existsById(drId)) {
			throw new ResourceNotFoundException("Doctor with ID : " + drId + " not found");
		}
		
		Query patientQuery = new Query();
		patientQuery.addCriteria(Criteria.where("phoneNo").is(patient.getPhoneNo()));
		
		Update patientUpdate = new Update();
		patientUpdate.set("firstName", patient.getFirstName());
		patientUpdate.set("lastName", patient.getLastName());
		patientUpdate.set("email", patient.getEmail());
		patientUpdate.set("phoneNo", patient.getPhoneNo());
        
        mongoTemplate.upsert(patientQuery, patientUpdate, Patient.class);
		
        Patient newPatient = patientRepository.findByPhoneNo(patient.getPhoneNo());
        
		Query doctorQuery = new Query();
		doctorQuery.addCriteria(Criteria.where("_id").is(drId));
		
		Update doctorUpdate = new Update();
		doctorUpdate.push("patient", newPatient);
		
		mongoTemplate.findAndModify(doctorQuery, doctorUpdate, Doctor.class);
	
		return ResponseEntity.ok(newPatient);
	}

	
	@Override
	public ResponseEntity<Patient> update(Patient patient) {
		if(!patientRepository.existsById(patient.getId())) {
			throw new ResourceNotFoundException("Patient with ID : " + patient.getId() + " not found");
		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(patient.getId()));
        
		Update update = new Update();
        update.set("firstName", patient.getFirstName());
        update.set("lastName", patient.getLastName());
        update.set("email", patient.getEmail());
        update.set("phoneNo", patient.getPhoneNo());
        
        mongoTemplate.findAndModify(query, update, Patient.class);
        
        Patient updatedPatient = mongoTemplate.findById(patient.getId(), Patient.class);
        
    	return ResponseEntity.ok(updatedPatient);
	}

	
//	@Override
//	public Patient delete(String id) {
//		patientRepository.deleteById(id);
//		return null;
//	}

	
	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	
	@Override
	public ResponseEntity<List<Doctor>> getOne(String drId) {
		if(!doctorRepository.existsById(drId)) {
			throw new ResourceNotFoundException("Doctor with ID : " + drId + " not found");
		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(drId));
		query.fields().include("patient");
		
		List<Doctor> patientList = mongoTemplate.find(query, Doctor.class);
		
		return ResponseEntity.ok().body(patientList);
	}



}
