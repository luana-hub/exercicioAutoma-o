package test;

import io.restassured.http.ContentType;
import org.jfree.data.json.impl.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredDummy {

    private String url = "http://www.dummy.restapiexample.com/api/v1";

    @Test
    public void getDummy() {
        given().when().get(url + "/employees").then().body("message", equalTo("Successfully! All records has been fetched."));
    }

    @Test
    public void postDummy() {
        given().
                contentType(ContentType.JSON).
                body(jsonRequest()).
                when().
                post(url + "/create").then().body("message", equalTo("Successfully! Record has been added."));

    }

    @Test
    public void putDummy() {
        given().
                body(jsonRequest()).
                when().
                put(url + "/update/1").then().body("message", equalTo("Successfully! Record has been updated."));
    }

    @Test
    public void deleteDummy() {
        when().delete(url+"/delete/1").then().body("message", equalTo("Successfully! Record has been deleted."));
    }

    public JSONObject jsonRequest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Guilherme");
        requestParams.put("salary", "1000");
        requestParams.put("age", "22");
        return requestParams;
    }
}
