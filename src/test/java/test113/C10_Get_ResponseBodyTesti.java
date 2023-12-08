package test113;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ResponseBodyTesti {
    @Test
    public void get01(){


        // 1 - Url hazirla

        String url="http://dummy.restapiexample.com/api/v1/employees";

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response=given().when().get(url);

        response.prettyPrint();
        response.prettyPeek();

        // 4 -  Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", Matchers.hasSize(24),
                        "data.employee_name", Matchers.hasItem("Ashton Cox"),
                        "data.employee_age",Matchers.hasItems(61,30,40));
    }

}
