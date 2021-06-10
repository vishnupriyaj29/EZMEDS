package com.yectra.ezmeds.ezm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yectra.ezmeds.ezm.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

	Patient findByPhoneNo(String phoneNo);

}
