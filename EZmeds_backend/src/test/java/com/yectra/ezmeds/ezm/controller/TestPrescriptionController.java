package com.yectra.ezmeds.ezm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.yectra.ezmeds.ezm.model.Prescription;

public class TestPrescriptionController extends AbstractClass {

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	@Test
	public void getPrescriptionList() throws Exception {
	   String uri = "/v1/api/prescription/all";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String prescription = mvcResult.getResponse().getContentAsString();
	   Prescription[] prescriptionlist = super.mapFromJson(prescription, Prescription[].class);
	   assertTrue(prescriptionlist.length > 0);
	}
	@Test
	public void createPrescription() throws Exception {
	   String uri = "/v1/api/prescription";
	   Prescription prescription = new Prescription();
	   prescription.setPatientId("1234");
	   prescription.setDrId("5678");
//	   prescription.setBeforeBreakfast("Iodex");
	   
	   String inputJson = super.mapToJson(prescription);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   
	}
	@Test
	public void updatePrescription() throws Exception {
	   String uri = "/v1/api/prescription";
	   Prescription prescription = new Prescription();
	   prescription.setPatientId("1234");
	   prescription.setDrId("5678");
//	   prescription.setBeforeBreakfast("Crocin");
	   
	   String inputJson = super.mapToJson(prescription);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	  
	}
}
