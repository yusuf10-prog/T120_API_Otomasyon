package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {

        /*
    C1_Get_ApiSorgulama
    https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
    gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8,
    ve Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK
    ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
     */

    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/83 ";
        Response response=given().when().get(url);

       // response.prettyPeek();

        System.out.println("status code : " + response.getStatusCode()); //200
        System.out.println("Content Type : " + response.getContentType());  // application/json; charset=utf-8,
        System.out.println("Server Header Degeri :" + response.getHeader("Server")); //Cowboy
        System.out.println("status Line : " +response.getStatusLine());  //HTTP/1.1 200 OK
        System.out.println("Get Time : " + response.getTime());  // least than

        //.out.println("Headers Degeri : " + response.getHeaders()); //
    }
}
