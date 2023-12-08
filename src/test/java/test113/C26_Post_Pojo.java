package test113;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingPOJO;
import pojos.BookingdatesPOJO;
import pojos.HerokuappExpBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class C26_Post_Pojo extends HerokuAppBaseUrl {

    @Test

    public void post(){


        specHerokuApp.pathParam("pp1","booking");

        BookingdatesPOJO bookingdates=new BookingdatesPOJO("2021-06-01","2021-06-10");

        BookingPOJO reqBody=new BookingPOJO("Ali","Bak",500,false,bookingdates,"wi-fi");

        HerokuappExpBodyPOJO expData=new HerokuappExpBodyPOJO(24,reqBody);

        Response response=given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post("/{pp1}");

        response.prettyPrint();

        HerokuappExpBodyPOJO respPojo=response.as(HerokuappExpBodyPOJO.class);


        assertEquals(expData.getBooking().getFirstname(), respPojo.getBooking().getFirstname());
        assertEquals(expData.getBooking().getLastname(), respPojo.getBooking().getLastname());
        assertEquals(expData.getBooking().getBookingdates().getCheckin(),
                respPojo.getBooking().getBookingdates().getCheckin());


        assertEquals(expData.getBooking().getTotalprice(), respPojo.getBooking().getTotalprice());
        assertEquals(expData.getBooking().getAdditionalneeds(),respPojo.getBooking().getAdditionalneeds());

        assertEquals(expData.getBooking().isDepositpaid(), respPojo.getBooking().isDepositpaid());

    }

}
