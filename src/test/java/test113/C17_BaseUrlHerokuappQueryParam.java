package test113;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {


    @Test
    public void get01(){


        // 1 - Url hazirla

        specHerokuApp.pathParam("pp1","booking");

        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasItem(1628));

    }
    @Test
    public void get02(){


        // 1 - Url hazirla

        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Eric");

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response.then().assertThat().statusCode(200).body("bookingid",hasSize(2));

    }
    @Test
    public void get03(){


        // 1 - Url hazirla

        specHerokuApp
                .pathParam("pp1","booking")
                .queryParams("firstname","Jim","lastname","Jackson");

        // 2 - Expected Data

        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",hasSize(3));

    }

}


///package test113;
//
//import baseUrl.HerokuAppBaseUrl;
//import io.restassured.response.Response;
////import org.testng.annotations.Test;
//import org.junit.Test;
//import static org.hamcrest.Matchers.*;
//import static io.restassured.RestAssured.given;
//
//
//public class C17_BaseUrlHerokuappQueryParam extends HerokuAppBaseUrl {
//    @Test
//    public void get01(){
//        // 1 - Url hazirla
//
//        specHerokuApp.pathParam("pp1","booking");
//
//        // 3 - Response kaydet
//
//        //Response response=given().spec(specHerokuApp).when().get("/{pp1}");
//        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
//
//        response.prettyPrint();
//
//        // 4 - Assertion
//
//        response
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("bookinid", hasItem(1628));
//
//
//    }
//    @Test
//    public void get02(){
//        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Eric");
//
//        // 2 - Expected Data hazirla
//
//        // 3 -  Response'i kaydet
//
//        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
//
//        response.prettyPrint();
//
//        // 4 - Assertion
//
//        response.then().assertThat().statusCode(200).body("bookingid", greaterThan(1));
//
//    }
//    @Test
//    public void get03(){
//
//    }
//}
//