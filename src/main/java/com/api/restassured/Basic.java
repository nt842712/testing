package com.api.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class Basic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//given --> all input details
		//when --> submit the api (resource ,http method)
		//Then --> validate the response
		
		
		Map<String,Object> jsnTomap=new HashMap<String, Object>();
		jsnTomap.put("","");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		//Add Place 
		
		
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		//.body(payload.AddPlace())
				.body(new String(Files.readAllBytes(Paths.get("//Users//ntalesha//eclipseNew//restassured//src//test//java//resources//addPlace.json"))))
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").extract().body().asString();
		System.out.println(response);
		JsonPath json=new JsonPath(response);
		String place_ID=json.getString("place_id");
		System.out.println(place_ID);
		
		
		//update place
		String newAddress="70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\n"
				+ "\"place_id\":\""+place_ID+"\",\n"
				+ "\"address\":\""+newAddress+"\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().body("msg", equalTo("Address successfully updated"));
		//.then().extract().body().asString();
		//System.out.println(response1);
		
		
		//get place
		
		String responseGet=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_ID)
		.when().get("maps/api/place/get/json")
		.then().extract().body().asString();
		//.then().assertThat().body("address", equalTo(newAddress)).statusCode(200);
		
		
		//json=new JsonPath(responseGet);
		String extractedAddress=ReusableMethods.rawToJSON(responseGet).getString("address");
		
		Assert.assertEquals(extractedAddress, newAddress);
		
		
		
		//System.out.println(responseGet);
		

		
		
	}

}
