package test113;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    @Test
    public void get01(){
        // 1 - Url hazirla

        String url="https://jsonplaceholder.typicode.com/posts/22";

        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println("expData ="+ expData);

        Response response=given().when().get(url);

        response.prettyPeek(); // prettyPrintten farklı olarak size response ile ilgili tum degerleri dondurur


        // 4 - Assertion
        JsonPath respJP=response.jsonPath();

        respJP.prettyPrint();

        assertEquals(expData.get("userId"), respJP.get("userId"));
        assertEquals(expData.get("id"),respJP.get("id"));
        assertEquals(expData.get("title"), respJP.get("title"));
        assertEquals(expData.get("id"), respJP.get("id"));

    }
}
