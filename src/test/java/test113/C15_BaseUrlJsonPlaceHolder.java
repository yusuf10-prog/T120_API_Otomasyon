package test113;

//port org.testng.annotations.Test;

//port java.awt.geom.RectangularShape;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseURL {


    @Test
    public void get01(){


        // 1 - Url hazirla

        specJsonPlace.pathParam("pp1","posts");

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}");
        // response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", hasSize(100));

    }
    @Test
    public void get02(){


        // 1 - Url hazirla

        specJsonPlace.pathParams("pp1","posts","pp2",44);

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("optio dolor molestias sit") );


    }
    @Test
    public void delete01(){




        specJsonPlace.pathParams("pp1","posts", "pp2",50);

        // 2 - Expected Data hazirla

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();

        // Assertion

        response.then().assertThat().statusCode(200).body("title",nullValue());

    }
}






//import baseUrl.JsonPlaceHolderBaseURL;
//port io.restassured.response.Response;
//port org.hamcrest.Matchers;
//port org.testng.annotations.Test;

//port java.awt.geom.RectangularShape;

//port static io.restassured.RestAssured.given;

//blic class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseURL {

//  @Test
//  public void get01(){

//      // 1 - Url hazirla

//      specJsonPlace.pathParam("pp1","posts");

//      // 2 - Expected Data hazirla

//      // 3 - Response kaydet

//      Response response=given()
//              .spec(specJsonPlace)
//              .when()
//              .get("/{pp1}");
//      response.prettyPrint();

//      // 4 - Assertion

//      response
//              .then()
//              .assertThat()
//              .statusCode(200)
//              .body("title", Matchers.hasSize(100));
//  }
//  @Test
//  public void get02(){

//      // 1 - Url hazirla



//      specJsonPlace.pathParams("pp1","posts","pp2",44);

//      // 2 - Expected Data hazirla

//      // 3 - Response'i kaydet

//      Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

//      // 4 - Assertion

//      response
//              .then()
//              .assertThat()
//              .statusCode(200)
//              .body("title",Matchers.equalTo("optio dolor molestias sit"));


//  }
//  @Test
//  public void get03(){

//      // 1 - Url hazirla

//      specJsonPlace.pathParams("pp1","posts","pp2",50);

//      // 2 - Expected Data hazirla

//      // 3 - Response'i kaydet

//      Response response=given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");
//      response.prettyPrint();

//      // 4 - Assertion

//      response
//              .then()
//              .assertThat()
//              .statusCode(200)
//              .body("title",Matchers.nullValue());
//  }
//


