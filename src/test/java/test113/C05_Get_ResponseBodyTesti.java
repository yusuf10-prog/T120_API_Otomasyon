package test113;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti {

    @Test
    public void get01(){
        // 1 - Enpoint hazırla

        String url="https://jsonplaceholder.typicode.com/posts/44";

        // 2 - Expected data hazırla.

        // 3 - Responseyi kaydet

        Response response=given().when().get(url);

        response.prettyPrint();

        //  4 - Assertion

        response
                .then()
                .assertThat().
                statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}
