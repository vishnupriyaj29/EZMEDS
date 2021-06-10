package com.yectra.ezmeds.ezm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.yectra.ezmeds.ezm.model.Doctor;

public class TestDoctorController extends AbstractClass {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getDoctorList() throws Exception {
		String uri = "/v1/api/doctor/all";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String doctor = mvcResult.getResponse().getContentAsString();
		Doctor[] doctorlist = super.mapFromJson(doctor, Doctor[].class);
		assertTrue(doctorlist.length > 0);
	}

	@Test
	public void createDoctor() throws Exception {
		String uri = "/v1/api/doctor";
		Doctor doctor = new Doctor();
		doctor.setId("5f9bb7c83bcad67f11fc3cb2");
		doctor.setEmail("xyz@ezmeds.com");
		doctor.setFirstName("Admin");
		doctor.setLastName("Admin");
		doctor.setSpecialization("Neuro");

		String inputJson = super.mapToJson(doctor);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void updateDoctor() throws Exception {
		String uri = "/v1/api/doctor";
		Doctor doctor = new Doctor();
		doctor.setId("5f9bb7c83bcad67f11fc3cb2");
		doctor.setFirstName("Admin1");
		doctor.setLastName("Admin1");
		doctor.setEmail("xyz@ezmeds.com");
		doctor.setSpecialization("Neuro");

		String inputJson = super.mapToJson(doctor);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

}
