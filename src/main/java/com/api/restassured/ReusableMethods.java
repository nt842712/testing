package com.api.restassured;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJSON(String response) {	 
		return new JsonPath(response);
	}
}
