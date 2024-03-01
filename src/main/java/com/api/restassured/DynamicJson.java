package com.api.restassured;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DynamicJson {
	
	
	public static String  additionID;
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().header("contentType","application/json").body(payload.addBook(isbn,aisle))
		//String response=given().header("contentType","application/json").body(Files.readAllBytes(Paths.get(null)))
		.when().post("Library/Addbook.php")
		.then().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		String expectedmsg=ReusableMethods.rawToJSON(response).getString("Msg");
		
		additionID=ReusableMethods.rawToJSON(response).getString("ID");
		Assert.assertEquals("successfully added", expectedmsg);
	
		
	}
	
	/*
	 * @Test(dependsOnMethods = { "addBook" }) public void deleteBook() {
	 * RestAssured.baseURI="https://rahulshettyacademy.com/"; String
	 * response=given().header("contentType","application/json").body("{\n" +
	 * "    \"ID\": \""+additionID+"\"\n" + "}")
	 * .when().delete("Library/DeleteBook.php")
	 * .then().statusCode(200).extract().response().asString();
	 * System.out.println(response); }
	 */
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"fhrgfsf","2242"},{"sfsffssf","35546646"},{"zdjyjtjt","46689779"}
		};
	}

}
