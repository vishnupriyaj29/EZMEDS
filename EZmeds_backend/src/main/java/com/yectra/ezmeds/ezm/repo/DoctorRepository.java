package com.yectra.ezmeds.ezm.repo;





import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yectra.ezmeds.ezm.model.Doctor;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
	
Doctor findByEmail(String email);
}
