package com.levi9.practice.controller;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashMap;
import java.util.Map;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class ApiComponentControllerTest {

	private static final String URL = "api/component";

	@Before
	public void setUp() {
		RestAssuredMockMvc.standaloneSetup(ApiComponentController.class);
	}

	@Test
	public void getComponent() {
		when().get(URL + "/1").then().body("id", equalTo(1)).statusCode(200);
	}

	@Test
	public void deleteComponent() {
		when().get(URL + "/1").then().body("id", equalTo(1)).statusCode(200);
	}

	@Test
	public void getComponents() {
		given().param("filter_query", "Procesor").when().get(URL).then().body("id", hasItem(2))
				.body("name", hasItem("Intel")).body("type", hasItem("Procesor")).statusCode(200);
	}

	@Test
	public void postComponent() {
		Map<String, String> json = new HashMap<>();
		json.put("type", "Monitor");
		json.put("name", "Dellov Hyper X");
		json.put("itemCode", "134");
		json.put("quantity", "12");
		json.put("price", "3216");
		json.put("value", "REQUIRED_ONE");
		given().contentType(ContentType.JSON)
		.body(json).when().post(URL)
		.then().
		body("name", equalTo("Dellov Hyper X"));
	}
	
	
}
