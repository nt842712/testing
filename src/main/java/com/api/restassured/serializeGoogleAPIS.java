package com.api.restassured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import PoJoGoogleAPIS.addPlace;
import PoJoGoogleAPIS.location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class serializeGoogleAPIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		RequestSpecification reqspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		// Add Place
		
		
		
		addPlace addplace=new addPlace();
		
		location loc=new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addplace.setLocation(loc);
		
		
		addplace.setAccuracy(50);
		addplace.setName("Frontline house");
		addplace.setPhoneNumber("\"(+91) 983 893 3937");
		addplace.setAddress("29, side layout, cohen 09");
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		addplace.setTypes(list);
		
		addplace.setWebsite("http://google.com");
		addplace.setLanguage("French-IN");

		RequestSpecification request=given().log().all().spec(reqspec).body(addplace);
		
		String response=request.when().post("maps/api/place/add/json").then().spec(resspec).extract().response().asString();
		
		System.out.println(response);

	}

}
