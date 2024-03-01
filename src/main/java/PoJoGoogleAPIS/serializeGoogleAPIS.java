package PoJoGoogleAPIS;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class serializeGoogleAPIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";

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

		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				// .body(payload.AddPlace())
				.body(addplace)
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);

	}

}
