package test;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredTest {

    private String url = "https://httpbin.org/get";

    @Test
    public void getAttributeUrl(){
        given().param("").when().get(url).then().statusCode(200).body("url",equalTo(url));
    }


}
