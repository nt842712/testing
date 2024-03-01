package endToendAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class eCommAPICalls {

	
	public static void main(String[] args) {
		
		RequestSpecification requestSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		ResponseSpecification responseSpec=new ResponseSpecBuilder().expectStatusCode(200).build();
		ResponseSpecification responseSpecCreat=new ResponseSpecBuilder().expectStatusCode(201).build();
		
		
		//Login to APIS
		LoginRequest loginReq=new LoginRequest();
		loginReq.setUserEmail("peret20675@telvetto.com");
		loginReq.setUserPassword("Password@1");
		
		RequestSpecification requestLogin=given().spec(requestSpec).body(loginReq).contentType(ContentType.JSON);
		
		LoginResponse response=requestLogin.when().post("/api/ecom/auth/login").then().log().all().spec(responseSpec).extract().response().as(LoginResponse.class);
		String token=response.getToken();
		String userID=response.getUserId();
		
		System.out.println(token);
		System.out.println(userID);
		

		//Add Product
		RequestSpecification addProductSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();
		
		
		RequestSpecification requestAdd=given().spec(addProductSpec).formParams("productName","qqqqq", "productAddedBy",""+userID+"","productCategory","fashion","productSubCategory","shirts"
				,"productPrice","11500","productDescription","Addias","productFor","women").multiPart("productImage",new File("/Users/ntalesha/Documents/Images/Screenshot (13).png"));
		
		addProductResponse productRes=requestAdd.when().post("/api/ecom/product/add-product").then().log().all().extract().response().as(addProductResponse.class);
		
		String productID=productRes.getProductId();
		
		System.out.println(productID);
		
		//Create Order
		
		orders order=new orders();
		order.setProductOrderedId(productID);
		order.setCountry("India");
		
		createOrders createorders=new createOrders();
		List<orders> array=new ArrayList<orders>();
		array.add(order);
		createorders.setOrders(array);
		
		RequestSpecification createOrderReq=given().log().all().spec(requestSpec).header("Authorization",token).body(createorders);
		
		createOrderRes createOrdRes=createOrderReq.when().post("api/ecom/order/create-order").then().spec(responseSpecCreat).extract().response().as(createOrderRes.class);
		String productOrderID=createOrdRes.getProductOrderId().get(0);
		String orders=createOrdRes.getOrders().get(0);
		System.out.println(productOrderID);
		System.out.println(orders);
		
		
		//Delete Order
		
		
		RequestSpecification   deletereq=given().spec(requestSpec).pathParam("productId", productID).header("Authorization",token);
		String deleresponse=deletereq.when().delete("api/ecom/product/delete-product/{productId}").then().spec(responseSpec).extract().response().asString();
		
		System.out.println(deleresponse);
		
		
		
		
		
	
	}
}

