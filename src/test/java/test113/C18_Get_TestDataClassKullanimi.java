package test113;


import TestDataKlasoru.TestDataJsonPlace;
import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {
    @Test
    public void get01(){
        //  1 - Url hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",22);

        //  2 - Expected Data Hazirla

        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        JSONObject expData=testDataJsonPlace.expectedBodyOlusturJSON();

        // 3 - Response 'i kaydet

        Response response=given()
                .spec(specJsonPlace)
                .when()
                .get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP=response.jsonPath();

        assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());

        assertEquals(expData.get("userId"),respJP.get("userId"));
        assertEquals(expData.get("id"),respJP.get("id"));
        assertEquals(expData.get("title"),respJP.get("title"));
        assertEquals(expData.get("body"),respJP.get("body"));


    }
}
