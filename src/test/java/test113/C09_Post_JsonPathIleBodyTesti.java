package test113;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.urlEncodingEnabled;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {
    @Test
    public void post01(){

        // 1 - url ve Reguest body hazirla
        String url ="https://restful-booker.herokuapp.com/booking";


        JSONObject bookingdates=new JSONObject();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();

        reqBody.put("firstname" , "Ali");
        reqBody.put("lastname" , "Bak");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("additionalneeds","wi-fi");
        reqBody.put("bookingdates", bookingdates);

        // 2 - Expected Data hazirla

        // 3 -  Response 'i kaydet

        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);

      response.prettyPrint();

      /*
      {
    "bookingid": 45,
    "booking": {
        "firstname": "Ali",
        "lastname": "Bak",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
}
       */



      // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ali"),
                        "booking.lastname",equalTo("Bak"),
                        "booking.totalprice", equalTo(500),
                        "booking.depositpaid", equalTo(false),
                        "booking.additionalneeds",equalTo("wi-fi"),
                        "booking.bookingdates.checkin", equalTo("2021-06-01"),
                        "booking.bookingdates.checkout",equalTo("2021-06-10"));

    }
}
