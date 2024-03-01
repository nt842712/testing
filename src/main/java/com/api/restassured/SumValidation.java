package com.api.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourse() {
		JsonPath js=new JsonPath(payload.CoursePrice());
		js.getInt("courses.size()");
		System.out.println(js.getInt("courses.size()"));
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		System.out.println(js.getString("courses[0].title"));
		int sumOfCoursesPrice=0;
		for(int i=0;i<js.getInt("courses.size()");i++) {
			//System.out.println("Course Title "+js.getString("courses["+i+"].title")+"   Prices::-->"+js.getString("courses["+i+"].price"));

			sumOfCoursesPrice=sumOfCoursesPrice+(js.getInt("courses["+i+"].price"))*js.getInt("courses["+i+"].copies");
			/*
			 * if(js.getString("courses["+i+"].title").equals("RPA")) {
			 * System.out.println(js.get("courses["+i+"].copies")); break; }
			 */
			
			
		}
		System.out.println(sumOfCoursesPrice);
	  Assert.assertEquals(sumOfCoursesPrice, js.getInt("dashboard.purchaseAmount"));
		
	}
}
