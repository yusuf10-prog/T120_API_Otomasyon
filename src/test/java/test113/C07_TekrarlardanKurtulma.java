package test113;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_TekrarlardanKurtulma {
    @Test
    public void get01(){

        // 1 - url hazırla

        String url ="https://restful-booker.herokuapp.com/booking/10";

        // 2 - Expected data hazırla

        // 3 - Response yi kaydet

        Response response=given()
                .when().get(url);

        response.prettyPrint();
/*

        response
                .then()
                .statusCode(200)  //"application/json; charset=utf-8"
                .contentType("application/json; charset=utf-8")
                .body("firstname", Matchers.equalTo("Susan"),
                        "lastname", Matchers.equalTo("Wilson"),
                        "totalprice",Matchers.equalTo(613),
                        "depositpaid", Matchers.equalTo(false),
                        "additionalneeds", Matchers.equalTo("Breakfast"));

 */

        response
                .then()
                .statusCode(200)  //"application/json; charset=utf-8"
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Jones"),
                        "totalprice",equalTo(469),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));

    }

}
