package com.api.restassured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;

public class OAuth2_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		given().queryParam("code", "ya29.a0AfB_byCRxFeypz76_K2E7Pwju8owT0yVIfntwKHAKDow6D6jFpJnxw1Kzd5AzRYxYT6JVpJ4rUqrtk0sC4_kO21ZxfqVq3xbyo_cDJ27GluOI17UIUCl0xGt5Gc030yRCJ4vUjgiMk_V_k3jgqHGMJhIpA1yBKF_ZJQxaCgYKAYwSARISFQHGX2Mi9jCDlPNQZIMaR8A1Etul-g0171")
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when().post("https://www.googleapis.com/oauth2/v4/token")
		.then().statusCode(200).extract().response().asString();
		
		
		String response=given().queryParam("access_token", "ya29.a0AfB_byCRxFeypz76_K2E7Pwju8owT0yVIfntwKHAKDow6D6jFpJnxw1Kzd5AzRYxYT6JVpJ4rUqrtk0sC4_kO21ZxfqVq3xbyo_cDJ27GluOI17UIUCl0xGt5Gc030yRCJ4vUjgiMk_V_k3jgqHGMJhIpA1yBKF_ZJQxaCgYKAYwSARISFQHGX2Mi9jCDlPNQZIMaR8A1Etul-g0171")
		.when().get("https://rahulshettyacademy.com/getCourse.php")
		.then().statusCode(200).extract().response().asString();
		
		JsonPath json=new JsonPath(response);
		
		
		System.out.println(json.prettify());
		
		System.out.println();
		
	}

}
