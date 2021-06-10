package com.yectra.ezmeds.ezm.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.yectra.ezmeds.ezm.model.Doctor;
import com.yectra.ezmeds.ezm.model.Patient;
import com.yectra.ezmeds.ezm.repo.DoctorRepository;
import com.yectra.ezmeds.ezm.repo.PatientRepository;

@SpringBootTest(classes = PatientServiceImpl.class)
@RunWith(SpringRunner.class)
public class TestPatientServiceImpl {
	
	@Autowired
	PatientServiceImpl patientService;
	
	@MockBean
	private DoctorRepository doctorRepository;
	
	@MockBean
	private PatientRepository patientRepository;
	
	@MockBean
	private MongoTemplate mongoTemplate;
	
	@Test
	public void update() {
		Patient mockPatient = new Patient();
		mockPatient.setId("123");
		mockPatient.setFirstName("Patient 1");
		mockPatient.setLastName("Patient");
		mockPatient.setPhoneNo("123456789");
		
		Mockito.when(mongoTemplate.findAndModify(Mockito.any(), Mockito.any(), Mockito.any()))
		.thenReturn(mockPatient);
		Mockito.when(patientRepository.existsById("123")).thenReturn(true);
		Mockito.when(mongoTemplate.findById("123", Patient.class)).thenReturn(mockPatient);
		
		ResponseEntity<Patient> result = patientService.update(mockPatient);
		
		assertThat(mockPatient).isEqualTo(result.getBody());
		assertThat(200).isEqualTo(result.getStatusCodeValue());
	}
	
	@Test
	public void get() {
		Patient patient = new Patient();
		patient.setId("123");
		patient.setFirstName("Patient 1");
		patient.setLastName("Patient");
		patient.setPhoneNo("123456789");
		List<Patient> mockPatient = (List<Patient>) patient;
		
		Doctor doctor = new Doctor();
		doctor.setId("123");
		doctor.setFirstName("Dr. Doctor");
		doctor.setLastName("Doctor");
		doctor.setEmail("doctor@ezmeds.com");
		doctor.setSpecialization("Test");
		doctor.setPatient(mockPatient);
		List<Doctor> mockDoctor = (List<Doctor>) doctor;
		
		Mockito.when(patientRepository.existsById("123")).thenReturn(true);
		Mockito.when(mongoTemplate.find(Mockito.any(), Doctor.class)).thenReturn(mockDoctor);
		
		ResponseEntity<List<Doctor>> patientList = patientService.getOne("123");
		
		assertThat(patientList).isEqualTo(patientList.getBody());
		assertThat(200).isEqualTo(patientList.getStatusCodeValue());
	}
	
	@Test
	public void insert() {
		Patient mockPatient = new Patient();
		mockPatient.setId("123");
		mockPatient.setFirstName("Patient 1");
		mockPatient.setLastName("Patient");
		mockPatient.setPhoneNo("123456789");
		
		Mockito.when(doctorRepository.existsById("456")).thenReturn(true);
		Mockito.when(mongoTemplate.upsert(Mockito.any(), Mockito.any(Update.class), Mockito.eq(Doctor.class)))
		.thenReturn(null);
		Mockito.when(patientRepository.findByPhoneNo("123456789")).thenReturn(mockPatient);
		
		ResponseEntity<Patient> insertedPatient = patientService.insert(mockPatient, "456");
		
		assertThat(mockPatient).isEqualTo(insertedPatient.getBody());
		assertThat(200).isEqualTo(insertedPatient.getStatusCodeValue());
	}
	
}
