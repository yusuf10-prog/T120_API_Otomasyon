package test113;

import TestDataKlasoru.TestDataJsonPlace;
import baseUrl.JsonPlaceHolderBaseURL;
import  io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {
    @Test
    public void put01() {
        // 1 - Url ve Request Body hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 70);

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();
        JSONObject reqBody = testDataJsonPlace.requestBodyOlusturJSON();
        // 2 - Expected Data Hzirla

        JSONObject expData = testDataJsonPlace.requestBodyOlusturJSON();

        // 3 - Response'i kaydet

        Response response = given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();
        assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());
        assertEquals(testDataJsonPlace.contentType, response.getContentType());
        assertEquals(testDataJsonPlace.connectionHeaderDegeri, response.getHeader("Connection"));

        assertEquals(expData.get("userId"), respJP.get("userId"));
        assertEquals(expData.get("id"), respJP.get("id"));
        assertEquals(expData.get("title"), respJP.get("title"));
        assertEquals(expData.get("body"), respJP.get("body"));
    }
}


