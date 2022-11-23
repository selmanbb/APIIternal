package Test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/256884 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */
    @Test
    public void get01(){
        // 1- Request icin Url ve Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/256884";
        // 2 - Expected Datayi hazirla
        // 3 - Response'u kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Server Header'inin degeri : " + response.getHeader("Server"));
        System.out.println("Status line : " + response.getStatusLine());
        System.out.println("Response suresi : " + response.getTime());
        System.out.println("Response suresi : " + response.getStatusCode());

    }
}
