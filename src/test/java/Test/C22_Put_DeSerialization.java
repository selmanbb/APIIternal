package Test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
   body’e sahip bir PUT request yolladigimizda donen response’in
   response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Request Body
       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
   Expected Data :
       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
    */
    @Test
    public void put01(){
        // 1 - Request icin URL ve Body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();
        HashMap<String,Object> reqBodyMap = testDataJsonPlaceHolder.requestBodyOlusturMap();
        System.out.println("reqBodyMap = " + reqBodyMap);
        // 2 - Expected Data olustur
        HashMap<String,Object> expBodyMap = testDataJsonPlaceHolder.requestBodyOlusturMap();
        System.out.println("expBodyMap = " + expBodyMap);
        // 3 - Response'u kaydet
        // Not : Request Body'i Map olarak hazirladigimiz icin ve Map de Javanin
        // kendisine ait bir format oldugu icin Response yollanirken toString
        // metoduna ihtiyac kalmaz!!!
        Response response = given().
                spec(specJsonPlace).
                contentType(ContentType.JSON).
                when().
                body(reqBodyMap).
                put("/{pp1}/{pp2}");
        response.prettyPrint();
        // Assertion
        HashMap <String,Object> respMap = response.as(HashMap.class);
        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.statusCode());
        assertEquals(expBodyMap.get("title"),respMap.get("title"));
        assertEquals(expBodyMap.get("body"),respMap.get("body"));
        assertEquals(expBodyMap.get("userId"),respMap.get("userId"));
        assertEquals(expBodyMap.get("id"),respMap.get("id"));
    }
}