package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.jfree.data.json.impl.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class RestAssuredDummy {

    private String url = "http://www.dummy.restapiexample.com/api/v1";
    String bodyStringValue = "";
    int x = 0;
    int numeroRequisicao = 100;

    @Test
    public void getDummy() {
        RequestSpecification httpRequest = RestAssured.given();
        while (x < numeroRequisicao) {
            Response response = httpRequest.get(url + "/employees");
            if (response.getStatusCode() == 200) {
                converteBody(response);
                break;
            } else {
                x++;
            }
        }
        Assert.assertTrue(bodyStringValue.contains("Successfully! All records has been fetched."));
    }

    @Test
    public void postDummy() {
        RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON).body(jsonRequest());
        while (x < numeroRequisicao) {
            Response response = httpRequest.post(url + "/create");
            if (response.getStatusCode() == 200) {
                converteBody(response);
                break;
            } else {
                x++;
            }
        }
        Assert.assertTrue(bodyStringValue.contains("Successfully! Record has been added."));
    }

    @Test
    public void putDummy() {
        RequestSpecification httpRequest = RestAssured.given().body(jsonRequest());
        while (x < numeroRequisicao) {
            Response response = httpRequest.put(url + "/update/1");
            if (response.getStatusCode() == 200) {
                converteBody(response);
                break;
            } else {
                x++;
            }
        }
        Assert.assertTrue(bodyStringValue.contains("Successfully! Record has been updated."));
    }

    @Test
    public void deleteDummy() {
        RequestSpecification httpRequest = RestAssured.given();
        while (x < numeroRequisicao) {
            Response response = httpRequest.delete(url + "/delete/1");
            if (response.getStatusCode() == 200) {
                converteBody(response);
                break;
            } else {
                x++;
            }
        }
        Assert.assertTrue(bodyStringValue.contains("Successfully! Record has been deleted"));
    }

    private JSONObject jsonRequest() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Guilherme");
        requestParams.put("salary", "1000");
        requestParams.put("age", "22");
        return requestParams;
    }

    private void converteBody(Response bodyValue) {
        ResponseBody bodyV = bodyValue.getBody();
        bodyStringValue = bodyV.asString();
        //Print comprovando a mensagem de sucesso!
        System.out.println(bodyStringValue);
    }
}
