package com.api.restassured;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	
	
	public static void main(String[] args) {
JsonPath js=new JsonPath(payload.CoursePrice());
js.getInt("courses.size()");
System.out.println(js.getInt("courses.size()"));
System.out.println(js.getInt("dashboard.purchaseAmount"));
System.out.println(js.getString("courses[0].title"));
for(int i=0;i<js.getInt("courses.size()");i++) {
	System.out.println("Course Title "+js.getString("courses["+i+"].title")+"   Prices::-->"+js.getString("courses["+i+"].price"));

if(js.getString("courses["+i+"].title").equals("RPA")) {
	System.out.println(js.get("courses["+i+"].copies"));
	break;
}
}

	}
	
}
