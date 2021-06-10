package com.yectra.ezmeds.ezm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.yectra.ezmeds.ezm.model.Patient;

public class TestPatientController extends AbstractClass {
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	public void getPatientList() throws Exception {
	   String uri = "/v1/api/patient/all";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String patient = mvcResult.getResponse().getContentAsString();
	   Patient[] patientlist = super.mapFromJson(patient, Patient[].class);
	   assertTrue(patientlist.length > 0);
	}
	
	@Test
	public void createPatient() throws Exception {
	   String uri = "/v1/api/patient/5f9bb7c83bcad67f11fc3cb2";
	   Patient patient = new Patient();

	   patient.setPhoneNo("7894561230");
	   patient.setFirstName("Patient");
	  
	   
	   String inputJson = super.mapToJson(patient);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	  
	}
	
	@Test
	public void updatePatient() throws Exception {
	   String uri = "/v1/api/patient";
	   Patient patient = new Patient();
	   patient.setId("5f9beacc3bcad67f11fc4887");
	   patient.setPhoneNo("7894561230");
	   patient.setFirstName("Patient");
	   patient.setLastName("Patient");
	   patient.setEmail("patient@gmail.com");
	   String inputJson = super.mapToJson(patient);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   
	}
	
}
