package com.bridgelabz.petstorerestassuredtesting;

import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreRestAssuredTesting {
    long id;

    @Test(priority = 0)
    public void aPlaceAnOrderOfPet() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "        \"id\": 0,\n" +
                        "        \"petId\":9,\n" +
                        "        \"quantity\": 5,\n" +
                        "        \"shipDate\": \"2022-08-23T07:55:34.195Z\",\n" +
                        "        \"status\": \"placed\",\n" +
                        "        \"complete\": true\n" +
                        "        }")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        id = response.path("id");
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 1)
    public void bFindPurchagedOrderById() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/"+id);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void cReturnPetInventriesByStatus() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void deleteOrder() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/"+id);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
