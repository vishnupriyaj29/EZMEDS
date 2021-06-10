package com.yectra.ezmeds.ezm.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.yectra.ezmeds.ezm.model.Prescription;
import com.yectra.ezmeds.ezm.repo.DoctorRepository;
import com.yectra.ezmeds.ezm.repo.PatientRepository;
import com.yectra.ezmeds.ezm.repo.PrescriptionRepository;


@SpringBootTest(classes = PrescriptionServiceImpl.class)
@RunWith(SpringRunner.class)
public class TestPrescriptionServiceImpl {
	
	@Autowired
	PrescriptionServiceImpl prescriptionService;
	
	@MockBean
	private PrescriptionRepository prescriptionRepository;
	
	@MockBean
	private DoctorRepository doctorRepository;
	
	@MockBean
	private PatientRepository patientRepository;
	
	@MockBean
	private MongoTemplate mongoTemplate;
	
	@Test
	public void get() {
		Prescription mockPrescription = new Prescription();
		mockPrescription.setId("123");
		mockPrescription.setDrId("456");
		mockPrescription.setPatientId("789");
//		mockPrescription.setAfterBreakfast("Paracetamol");
//		mockPrescription.setAsPerNeed("Crocin");
//		mockPrescription.setBedtime("Dolo");
		
		Mockito.when(doctorRepository.existsById("456")).thenReturn(true);
		Mockito.when(patientRepository.existsById("789")).thenReturn(true);
		Mockito.when(mongoTemplate.findOne(Mockito.any(), Mockito.any())).thenReturn(mockPrescription);
		
		ResponseEntity<Prescription> result = prescriptionService.getOne("456", "789");
		
		assertThat(mockPrescription).isEqualTo(result.getBody());
		assertThat(200).isEqualTo(result.getStatusCodeValue());
	}
	
	@Test
	public void insert() {
		Prescription mockPrescription = new Prescription();
		mockPrescription.setId("123");
		mockPrescription.setDrId("456");
		mockPrescription.setPatientId("789");
//		mockPrescription.setAfterBreakfast("Paracetamol");
//		mockPrescription.setAsPerNeed("Crocin");
//		mockPrescription.setBedtime("Dolo");
		
		Mockito.when(doctorRepository.existsById("456")).thenReturn(true);
		Mockito.when(patientRepository.existsById("789")).thenReturn(true);
		Mockito.when(prescriptionRepository.insert(mockPrescription)).thenReturn(mockPrescription);
		
		ResponseEntity<Prescription> result = prescriptionService.insert(mockPrescription);
		
		assertThat(mockPrescription).isEqualTo(result.getBody());
		assertThat(200).isEqualTo(result.getStatusCodeValue());
	}
	
	@Test
	public void update() {
		Prescription mockPrescription = new Prescription();
		mockPrescription.setId("123");
		mockPrescription.setDrId("456");
		mockPrescription.setPatientId("789");
//		mockPrescription.setAfterBreakfast("Paracetamol");
//		mockPrescription.setAsPerNeed("Crocin");
//		mockPrescription.setBedtime("Dolo");
		
		Mockito.when(doctorRepository.existsById("456")).thenReturn(true);
		Mockito.when(patientRepository.existsById("789")).thenReturn(true);
		Mockito.when(prescriptionRepository.save(mockPrescription)).thenReturn(mockPrescription);
		
		ResponseEntity<Prescription> result = prescriptionService.update(mockPrescription);
		
		assertThat(mockPrescription).isEqualTo(result.getBody());
		assertThat(200).isEqualTo(result.getStatusCodeValue());
	}
}
