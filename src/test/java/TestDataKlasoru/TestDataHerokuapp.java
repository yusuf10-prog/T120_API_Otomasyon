package TestDataKlasoru;

import org.json.JSONObject;
import java.util.HashMap;

public class TestDataHerokuapp {

    public int basariliStatusCode = 200;
    // 1 - Url ve Request body hazirla


    public JSONObject getBookingdatesOlusturJSON() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        return bookingdates;

    }

    public JSONObject bookingOlusturJSON() {

        JSONObject booking = new JSONObject();

        booking.put("firstname", "Ali");
        booking.put("lastname", "Bak");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("additionalneeds", "wi-fi");
        booking.put("bookingdates", getBookingdatesOlusturJSON());

        return booking;
    }

    public JSONObject expectedBodyOlusturJSON() {
        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking", bookingOlusturJSON());

        return expData;
    }

    public HashMap bookingdatesMap() {

        HashMap<String, Object> bookingdates = new HashMap<>();

        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        return bookingdates;
    }


    public HashMap reqBodyMap() {

        HashMap<String, Object> booking = new HashMap<>();

        booking.put("firstname", "Ali");
        booking.put("lastname", "Bak");
        booking.put("totalprice", 500.0);
        booking.put("depositpaid", false);
        booking.put("additionalneeds", "wi-fi");
        booking.put("bookingdates", bookingdatesMap());

        return booking;
    }

    public HashMap exBodyMap() {

        HashMap<String, Object> expBody = new HashMap<>();

        expBody.put("bookingid", 24);
        expBody.put("booking", reqBodyMap());

        return expBody;
    }
}



