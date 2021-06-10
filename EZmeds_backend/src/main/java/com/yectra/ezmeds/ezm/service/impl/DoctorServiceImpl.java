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
import com.yectra.ezmeds.ezm.repo.DoctorRepository;
import com.yectra.ezmeds.ezm.service.DoctorService;


@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Doctor> getAll() {
		return doctorRepository.findAll();
	}

	@Override
	public ResponseEntity<Doctor> getDrDetail(String id) {	
		if(!doctorRepository.existsById(id)) {
			throw new ResourceNotFoundException("Doctor with ID : " + id + " not found");
		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		query.fields().exclude("patient");
		
		Doctor doctor = mongoTemplate.findOne(query, Doctor.class);
		
		return ResponseEntity.ok().body(doctor);
	}
	
//	To be used when keycloak is used 
//	@Override
//	public Optional<Doctor> getDrDetail(String email) {
//		return doctorRepository.findByEmail(email);
//	}

	@Override
	public Doctor delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Doctor insert(Doctor doctor) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(doctor.getEmail()));
		
		Update update = new Update();
		update.set("firstName", doctor.getFirstName());
		update.set("lastName", doctor.getLastName());
        update.set("email", doctor.getEmail());
        update.set("specialization", doctor.getSpecialization());
		
        mongoTemplate.upsert(query, update, Doctor.class);
		
        return mongoTemplate.findOne(query, Doctor.class);
	}

	
	@Override
	public ResponseEntity<Doctor> update(Doctor doctor) {
		if(!doctorRepository.existsById(doctor.getId())) {
			throw new ResourceNotFoundException("Doctor with ID : " + doctor.getId() + " not found");
		}
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(doctor.getId()));
		
		Update update = new Update();
		update.set("firstName", doctor.getFirstName());
        update.set("lastName", doctor.getLastName());
        update.set("email", doctor.getEmail());
        update.set("specialization", doctor.getSpecialization());
        
        mongoTemplate.findAndModify(query, update, Doctor.class);
		
        return getDrDetail(doctor.getId());
	}

}
