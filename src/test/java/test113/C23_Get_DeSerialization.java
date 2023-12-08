package test113;

import TestDataKlasoru.TestDataDummy;
import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_DeSerialization extends DummyBaseUrl {
    @Test
    public void get01(){

        // 1 - Url hazirla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        TestDataDummy testDataDummy=new TestDataDummy();

        HashMap<String , Object> expData=testDataDummy.expectedBodyOlusturMap();

        // 3 - Response'i kaydet

        Response response=given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();


        // 4 - Assertion

        assertEquals(testDataDummy.basariliStatusCode, response.getStatusCode());
        assertEquals(testDataDummy.contentType, response.getContentType());

        HashMap<String , Object> respMap=response.as(HashMap.class);

        assertEquals(((Map)expData.get("data")).get("id"),
                ((Map)respMap.get("data")).get("id"));
        assertEquals(((Map)(expData.get("data"))).get("employee_name"),
                ( (Map)respMap.get("data")).get("employee_name"));
        assertEquals(((Map)(expData.get("data"))).get("employee_salary"),
                ( (Map)respMap.get("data")).get("employee_salary"));
        assertEquals(((Map)(expData.get("data"))).get("employee_age"),
                ( (Map)respMap.get("data")).get("employee_age"));
        assertEquals(((Map)(expData.get("data"))).get("profile_image"),
                ( (Map)respMap.get("data")).get("profile_image"));
    }
}
