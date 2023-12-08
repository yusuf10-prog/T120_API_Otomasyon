package test113;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssert {
    @Test
    public void put01(){

        //1 - Endponit ve Request Body hazirla

        String url="https://jsonplaceholder.typicode.com/posts/70";


        JSONObject reqBody=new JSONObject();

        reqBody.put("title", "Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // 2 - Expected Data hazirla

        // 3 - Response 'i kaydet

        // NOT : Eger sorgumuzda bir requesy body gönderiyorsak gönderdiğimiz datanin formaniti
        // belirtmek zorundayiz. Bunu da hemen given() methodundan sonra pre-contition olarak belirtebiliriz.


        Response response=given().contentType(ContentType.JSON)
                .when()
                .body(reqBody
                        .toString())
                .put(url);

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
