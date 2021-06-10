package com.yectra.ezmeds.ezm.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.yectra.ezmeds.ezm.model.Doctor;
import com.yectra.ezmeds.ezm.repo.DoctorRepository;


@SpringBootTest(classes = DoctorServiceImpl.class)
@RunWith(SpringRunner.class)
public class TestDoctorServiceImpl {
	
	@Autowired
	private DoctorServiceImpl drService;
	
	@MockBean
	private DoctorRepository doctorRepository;
	
	@MockBean
	private MongoTemplate mongoTemplate;
	
	@Test
	public void getDoctor() {
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId("123");
		mockDoctor.setFirstName("Dr. Doctor");
		mockDoctor.setLastName("Doctor");
		mockDoctor.setEmail("doctor@ezmeds.com");
		mockDoctor.setSpecialization("Test");
		
		Mockito.when(mongoTemplate.findOne(Mockito.any(Query.class), Mockito.any()))
			.thenReturn(mockDoctor);
		Mockito.when(doctorRepository.existsById("123")).thenReturn(true);
		
		ResponseEntity<Doctor> getDr = drService.getDrDetail("123");
		
		assertThat(mockDoctor).isEqualTo(getDr.getBody());
		assertThat(200).isEqualTo(getDr.getStatusCodeValue());
	}
	
	@Test
	public void insert() {
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId("123");
		mockDoctor.setFirstName("Dr. Doctor");
		mockDoctor.setLastName("Doctor");
		mockDoctor.setEmail("doctor@ezmeds.com");
		mockDoctor.setSpecialization("Test");
		
		Mockito.when(mongoTemplate.upsert(Mockito.any(Query.class), Mockito.any(Update.class), Mockito.eq(Doctor.class)))
			.thenReturn(null);
		Mockito.when(mongoTemplate.findOne(Mockito.any(), Mockito.any())).thenReturn(mockDoctor);
		
		Doctor result = drService.insert(mockDoctor);
		
		assertThat(result).isEqualTo(mockDoctor);
	}
	
	@Test
	public void update() {
		Doctor mockDoctor = new Doctor();
		mockDoctor.setId("123");
		mockDoctor.setFirstName("Dr. Doctor");
		mockDoctor.setLastName("Doctor");
		mockDoctor.setEmail("doctor@ezmeds.com");
		mockDoctor.setSpecialization("Test");
		
		Mockito.when(mongoTemplate.findAndModify(Mockito.any(Query.class), Mockito.any(Update.class), Mockito.any()))
			.thenReturn(mockDoctor);
		Mockito.when(doctorRepository.existsById("123")).thenReturn(true);
		
		ResponseEntity<Doctor> updatedDr = drService.update(mockDoctor);
		
		assertThat(200).isEqualTo(updatedDr.getStatusCodeValue());
	}
}
