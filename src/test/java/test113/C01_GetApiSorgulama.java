package test113;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class C01_GetApiSorgulama {
    @Test
    public void get1(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.prettyPrint();

        System.out.println("Statüsü :" + response.getStatusCode());
        System.out.println("Content type : " + response.getContentType());
        System.out.println("Server header değeri : " + response.getHeader("Server"));
        System.out.println("Statüs Line : " + response.getStatusLine());
        System.out.println("Response Süresi :" + response.getTime());
    }
}
