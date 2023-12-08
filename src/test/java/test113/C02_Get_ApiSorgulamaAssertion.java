package test113;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ApiSorgulamaAssertion {
    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        //response.prettyPrint();

        response.
                then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }
}
