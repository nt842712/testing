package com.api.restassured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
public class GraphQLScripts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String response=given().log().all().header("Content-type","application/json")
		.body("{\"query\":\"query($characterId:Int!,$episodeId:Int!){\\n  character(characterId: $characterId) {\\n    name\\n    gender\\n    status\\n    id\\n  }\\n  location(locationId: 5781){\\n    name\\n    dimension\\n  }\\n  episode(episodeId: $episodeId){\\n    name\\n    air_date\\n    episode\\n  }  \\n  characters(filters:{name: \\\"Rahul\\\"}){\\n    info{\\n      count\\n    }\\n    result{\\n      name\\n      type\\n      id\\n    }\\n  }\\n  episodes(filters:{episode:\\\"hulu\\\"}){\\n    result{\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n}\\n\",\"variables\":{\"characterId\":5178,\"episodeId\":4240}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath json=new JsonPath(response);
		
		System.out.println(json.getString("data.character.name"));
		//json.getString("character.name")
		
		
		//Mutation
		
		
		String response1=given().log().all().header("Content-type","application/json")
				.body("{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!){\\n  createLocation(location : {name: $locationName,type: \\\"West\\\",dimension:\\\"234\\\"}){\\n    id\\n  }\\n  \\n   createCharacter(character:{name:$characterName,type:\\\"test\\\",status:\\\"active\\\",species:\\\"male\\\",gender:\\\"male\\\",image:\\\"TEST\\\",originId:5781,locationId:5781})\\n  {\\n    id\\n  }\\n \\n  \\n  createEpisode(episode:{name:$episodeName,air_date:\\\"tomorrow\\\",episode:\\\"1\\\"}){\\n   id \\n  }\\n  \\n  deleteLocations(locationIds:[5785]){\\n    locationsDeleted\\n  }\\n    \\n  \\n}\",\"variables\":{\"locationName\":\"TESTING\",\"characterName\":\"TESTUUUU\",\"episodeName\":\"TETSJKCJLDDJLJ\"}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().statusCode(200).extract().response().asString();
				
				System.out.println(response1);
				
				JsonPath json1=new JsonPath(response1);
				
				System.out.println(json1.getString("data.createLocation.id"));
				//json.getString("character.name")
	}

}
