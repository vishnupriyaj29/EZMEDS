package com.yectra.ezmeds.ezm.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yectra.ezmeds.ezm.model.Medicine;

import com.yectra.ezmeds.ezm.repo.MedicineRepository;



@RestController
@RequestMapping("/v1/api/medicine")
public class MedicineController {
	
	@Autowired
	public MedicineRepository medicineRepository;
	
	
	
	@GetMapping
	public List<Medicine> getMedicine() {
		return medicineRepository.findAll();
	}
	
	@GetMapping("/{drug}")
	public List<Medicine> findByDrugName(@PathVariable("drug") String drug) {
		
		List<Medicine> drugList = medicineRepository.findByDrugNameStartingWith("^" + drug);
		return drugList;
	}
	
	@PostMapping
	public Medicine insert(@RequestBody Medicine medicine) {
		
		Medicine insertedMedicine = this.medicineRepository.insert(medicine);
		return insertedMedicine;
	}
	
	
	
	

}
