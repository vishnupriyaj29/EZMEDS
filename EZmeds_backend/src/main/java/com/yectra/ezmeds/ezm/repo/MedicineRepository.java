package com.yectra.ezmeds.ezm.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.yectra.ezmeds.ezm.model.Medicine;

@Repository

public interface MedicineRepository extends MongoRepository<Medicine, String> {
	
	@Query("{ 'DrugName' : { $regex: ?0 } }")
	public List<Medicine> findByDrugNameStartingWith(String drug);

}
