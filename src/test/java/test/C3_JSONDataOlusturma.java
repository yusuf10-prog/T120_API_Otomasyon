package test;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class C3_JSONDataOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
    }
 */

    @Test
    public void JSONData(){

        JSONObject jsonData=new JSONObject();

        jsonData.put("title","Ahmet");
        jsonData.put("body","Merhaba");
        jsonData.put("userID",1);
        System.out.println("İlk olusturdugum jsonData: " +jsonData);
    }


    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
    "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates":{
                    "checkin":"2018-01-01",
                    "checkout":"2019-01-01"
                    },
    "totalprice":111,
    "depositpaid":true,
     "lastname":"Brown"
    }
     */

    @Test
    public void innerJson(){
        JSONObject innerJSONobj=new JSONObject();
        innerJSONobj.put("checkin","2018-01-01");
        innerJSONobj.put("heckout","2019-01-01");

        JSONObject jsonData=new JSONObject();
        jsonData.put("firstname","Jim");
        jsonData.put("additionalneeds","Breakfast");
        jsonData.put("totalprice",111);
        jsonData.put("depositpaid","true");
        jsonData.put("lastname","Brown");

        System.out.println("JSONData="+ jsonData);
    }
}
