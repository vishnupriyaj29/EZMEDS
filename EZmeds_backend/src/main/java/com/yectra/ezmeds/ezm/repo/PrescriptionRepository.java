package com.yectra.ezmeds.ezm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yectra.ezmeds.ezm.model.Prescription;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, String> {

}
