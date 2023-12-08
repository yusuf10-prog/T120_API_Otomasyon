package test113;

import TestDataKlasoru.TestDataJsonPlace;
import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;
import static org.junit.Assert.assertEquals;


public class C22_Put_DeSeralitizaon extends JsonPlaceHolderBaseURL {

    @Test
    public void put01(){
        // 1 - Url ve request body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        HashMap<String , Object> reqBodyy=testDataJsonPlace.requestBodyOlusturMap();


        // 2 - Expected Data Hazirla

        HashMap<String , Object> expData=testDataJsonPlace.requestBodyOlusturMap();

        // 3 - Response 'i kaydet

        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBodyy)
                .put("/{pp1}/{pp2}");
        response.prettyPrint();


        // 4 - Assertion

        HashMap<String , Object> respMap=response.as(HashMap.class);

        assertEquals(expData.get("title"),respMap.get("title"));
        assertEquals(expData.get("body"), respMap.get("body"));
        assertEquals(expData.get("userId"), respMap.get("userId"));
        assertEquals(expData.get("id"), respMap.get("id"));
    }
}
