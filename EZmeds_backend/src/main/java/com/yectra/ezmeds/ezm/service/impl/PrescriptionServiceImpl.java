package com.yectra.ezmeds.ezm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yectra.ezmeds.ezm.exception.ResourceNotFoundException;
import com.yectra.ezmeds.ezm.model.Patient;
import com.yectra.ezmeds.ezm.model.Prescription;
import com.yectra.ezmeds.ezm.repo.DoctorRepository;
import com.yectra.ezmeds.ezm.repo.PatientRepository;
import com.yectra.ezmeds.ezm.repo.PrescriptionRepository;
import com.yectra.ezmeds.ezm.service.PrescriptionService;

@Service("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Prescription> getAll() {
		return prescriptionRepository.findAll();
	}

	@Override
	public ResponseEntity<Prescription> getOne(String drId,String patientId) {
		if(!doctorRepository.existsById(drId)) {
			throw new ResourceNotFoundException("Doctor with ID : " + drId + " not found");
		}
		if(!patientRepository.existsById(patientId)) {
			throw new ResourceNotFoundException("Patient with ID : " + patientId + " not found");
		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("patientId").is(patientId)
				.andOperator(Criteria.where("drId").is(drId)));
		
		Prescription prescription = mongoTemplate.findOne(query, Prescription.class);
		
		return ResponseEntity.ok(prescription);
	}

	
	@Override
	public ResponseEntity<Prescription> insert(Prescription prescription) {
		if(!doctorRepository.existsById(prescription.getDrId())) {
			throw new ResourceNotFoundException("Doctor with ID : " + prescription.getDrId() + " not found");
		}
		if(!patientRepository.existsById(prescription.getPatientId())) {
			throw new ResourceNotFoundException("Patient with ID : " + prescription.getPatientId() + " not found");
		}
		
		return ResponseEntity.ok(prescriptionRepository.insert(prescription));
	}

	
	@Override
	public ResponseEntity<Prescription> update(Prescription prescription) {
		if(!doctorRepository.existsById(prescription.getDrId())) {
			throw new ResourceNotFoundException("Doctor with ID : " + prescription.getDrId() + " not found");
		}
		if(!patientRepository.existsById(prescription.getPatientId())) {
			throw new ResourceNotFoundException("Patient with ID : " + prescription.getPatientId() + " not found");
		}
		
		return ResponseEntity.ok(prescriptionRepository.save(prescription));
	}

	
	@Override
	public Patient delete(String id) {
		prescriptionRepository.deleteById(id);
		return null;
	}

}
