package test113;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceRequestBodyPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseURL {
    @Test
    public void put01(){

        // 1 - Url 'i ve Request Body hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",70);



        JsonPlaceRequestBodyPOJO reqBody=
                new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);
        System.out.println("reqBody =" + reqBody);

        // 2 - Expected Data Hazirla


        JsonPlaceRequestBodyPOJO expBody=
                new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        // 3 - Response 'i kaydet

        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4 - Assertion

       // JsonPath respJP=response.jsonPath();
       // HashMap<String, Object> respMap=response.as(HashMap.class);

        JsonPlaceRequestBodyPOJO respPojo=response.as(JsonPlaceRequestBodyPOJO.class);

        assertEquals(expBody.getTitle(),respPojo.getTitle());
        assertEquals(expBody.getBody(), respPojo.getBody());
        assertEquals(expBody.getId(),respPojo.getId());
        assertEquals(expBody.getUserId(), respPojo.getUserId());

    }
}
