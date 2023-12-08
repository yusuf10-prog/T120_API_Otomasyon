package test113;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesiOlusturma {
    @Test
    public void jsonObjce01(){

        JSONObject ilkJsonObje=new JSONObject();

        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);

        System.out.println("İlk Json Objemiz :" + ilkJsonObje);
    }
    @Test
    public void jsonObjce2(){

        JSONObject bookingDates=new JSONObject();

        bookingDates.put("checkin","2023-11-01");
        bookingDates.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid","true");
        outerJson.put("lastname","Brown");
        outerJson.put("bookingdates",bookingDates);

        System.out.println("Booking Json Objemiz : "+ outerJson);

        /*
        Booking Json Objemiz :
        {
            "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates":
            {
            "checkin":"2023-11-01",
            "checkout":"2019-01-01"
            },
            "totalprice":111,
            "depositpaid":"true",
            "lastname":"Brown"

        }

         */

    }
}
