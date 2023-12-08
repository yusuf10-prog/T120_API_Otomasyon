package test113;

import TestDataKlasoru.TestDataHerokuapp;
import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {

    @Test
    public void post01(){

        // 1 - Url ve Request Body hazirla

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuapp testDataHerokuapp = new TestDataHerokuapp();

        JSONObject reqBody = testDataHerokuapp.bookingOlusturJSON();

        // 2 - Expected Data hazirla

        JSONObject expData = testDataHerokuapp.expectedBodyOlusturJSON();

        // 3 - Response'i kaydet

        Response response = given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();


        assertEquals(testDataHerokuapp.basariliStatusCode, response.getStatusCode());
        assertEquals(expData.getJSONObject("booking").get("firstname"), respJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"), respJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"), respJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), respJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), respJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                respJP.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                respJP.get("booking.bookingdates.checkout"));

    }

}

//
//port TestDataKlasoru.TestDataHerokuapp;
//port baseUrl.HerokuAppBaseUrl;
//port io.restassured.http.ContentType;
//port io.restassured.path.json.JsonPath;
//port io.restassured.response.Response;
//port org.json.JSONObject;
//port org.junit.Assert;
//port org.junit.Test;

//port java.awt.desktop.AboutEvent;

//port static io.restassured.RestAssured.given;
//port static org.junit.Assert.assertEquals;

//blic class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {

//  @Test
//  public void post01(){
//      // 1 - Url ve Request body hazirla

//      specHerokuApp.pathParam("pp1","booking");

//      TestDataHerokuapp testDataHerokuapp=new TestDataHerokuapp();

//      JSONObject reqBody=testDataHerokuapp.bookingOlusturJSON();

//      // 2 - Expected data olustur.


//      JSONObject expData=testDataHerokuapp.expectedBodyOlusturJSON();
//      Response response=given()
//              .spec(specHerokuApp)
//              .contentType(ContentType.JSON)
//              .when()
//              .body(reqBody.toString())
//              .post("/{pp1}");
//      response.prettyPrint();


//      // 4 - Assertion

//      JsonPath respJP=response.jsonPath();


//      assertEquals(testDataHerokuapp.basariliStatusCode, response.getStatusCode());

//      assertEquals(expData.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
//      assertEquals(expData.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
//      assertEquals(expData.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
//      assertEquals(expData.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
//      assertEquals(expData.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));

//      assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
//              respJP.get("booking.bookingdates.checkin"));

//      assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
//              respJP.get("booking.bookingdates.checkout"));

//  }
//

//      hocam pom da eksiklikler olabilir  hemen 2 dk geri donecegim taamm hocam olur  baska jdk deniyorum yani cozum yollarina bakiyorum tamam hocam olur sorun yok
// siz takılın sorun değil :)hocam bilgisayar yancak :) ne aptınız ki

 // jdk surumu indirdim sadece intellijde