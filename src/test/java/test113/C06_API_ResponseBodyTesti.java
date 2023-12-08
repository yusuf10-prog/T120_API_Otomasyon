package test113;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class C06_API_ResponseBodyTesti {
    @Test
    public void post01(){
        // 1 - Url ve request body hazırla

        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API öğrenmek ne güzel");
        reqBody.put("userId",10);

        System.out.println("reqBody :"+reqBody);

        // 2 - Expected daha hazırla

        // 3 - Response hazırla

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",lessThan(100))
                .body("body",Matchers.containsString("API"));

    }
}
