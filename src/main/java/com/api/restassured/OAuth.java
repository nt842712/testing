package com.api.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import PoJo.GetCourse;

public class OAuth {

	public static void main(String[] args) {

		String[] courseTitles = { "Selenium Webdriver Java", "Cypres", "Protractor" };
		// TODO Auto-generated method stub

		// RestAssured.baseURI="https://gateway.optum.com";
		/*
		 * String
		 * response=given().log().all().header("Content-Type","application/json").
		 * headers("cache-control","no-cache") .body("{\n" +
		 * "    \"grant_type\":\"client_credentials\",\n" +
		 * "    \"client_id\":\"wSj4Er9Jv0CTDnDzPdRVYdrJpywv7Prx\",\n" +
		 * "    \"client_secret\":\"03r0xRorJEcMLrG8b5rrDPwsi281Z7IV\"\n" + "}")
		 * .relaxedHTTPSValidation().when().post("/auth/oauth2/token")
		 * .then().log().all().statusCode(200).extract().response().asString();
		 * 
		 * JsonPath json=new JsonPath(response); json.getString("access_token"); String
		 * tokenType=json.getString("token_type");
		 * 
		 * Assert.assertEquals("Beare",tokenType);
		 */

		/*
		 * String
		 * response=given().log().all().contentType("application/x-www-form-urlencoded")
		 * .formParams("grant_type", "client_credentials","client_id",
		 * "nx2hzW5UPhANTEIrTvZETKfG5TfBdGX4","client_secret",
		 * "c2FpQFxT5KYjVQEVVXgcl3eCe71iJzSO") //.formParams("client_id",
		 * "nx2hzW5UPhANTEIrTvZETKfG5TfBdGX4") //.formParams("client_secret",
		 * "c2FpQFxT5KYjVQEVVXgcl3eCe71iJzSO")
		 * .relaxedHTTPSValidation().when().post("/auth/oauth2/token")
		 * .then().log().all().statusCode(200).extract().response().asString();
		 * 
		 * JsonPath json=new JsonPath(response); json.getString("access_token"); String
		 * tokenType=json.getString("token_type");
		 * 
		 * Assert.assertEquals("Bearer",tokenType);
		 * 
		 * 
		 * String responseprofile=given().log().all().headers("uuid",
		 * "bd1e151c-f0eb-4c05-b8b0-3617d9f91163","actor","MYUHC","Authorization",json.
		 * getString("access_token"))
		 * .when().get("/api/cel/rx/commoncapability/v2.0/profile/index")
		 * .then().statusCode(200).extract().body().asString();
		 * 
		 * System.out.println(responseprofile);
		 */

		String response = given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		System.out.println(response);
		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);
		GetCourse course = given().queryParams("access_token", accessToken).when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

		System.out.println(course.getInstructor());
		System.out.println(course.getLinkedIn());
		System.out.println(course.getCourses().getApi().get(1).getCourseTitle());

		// System.out.println(r2);

		int sizeofApi = course.getCourses().getApi().size();

		for (int i = 0; i < sizeofApi; i++) {
			if (course.getCourses().getApi().get(i).getCourseTitle().equals("SoapUI Webservices testing")) {
				System.out.println(course.getCourses().getApi().get(i).getPrice());
			}
		}

		// int sizeofApi=course.getCourses().getWebAutomation().size();
		List<String> actualWebAutomationCOurse = new ArrayList<String>();
		for (int i = 0; i < course.getCourses().getWebAutomation().size(); i++) {
			/*
			 * if(course.getCourses().getWebAutomation().get(i).getCourseTitle().
			 * equals("SoapUI Webservices testing")) {
			 * System.out.println(course.getCourses().getApi().get(i).getPrice()); }
			 */
			actualWebAutomationCOurse.add(course.getCourses().getWebAutomation().get(i).getCourseTitle());
			//System.out.println(course.getCourses().getWebAutomation().get(i).getCourseTitle());
			//System.out.println(actualWebAutomationCOurse);

		}
		
		Assert.assertEquals(actualWebAutomationCOurse, Arrays.asList(courseTitles));

	}

}
