package com.bridgelabz.petstorerestassuredtesting;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreRestAssuredTesting {

    @Test(priority = 0)
    public void addPet() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "        \"id\": 0,\n" +
                        "        \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"Kutta\"\n" +
                        "        },\n" +
                        "        \"name\": \"doggie\",\n" +
                        "        \"photoUrls\": [\n" +
                        "        \"https://m.facebook.com/Billi-Meow-103296698627401/photos/?ref=page_internal\"\n" +
                        "        ],\n" +
                        "        \"tags\": [\n" +
                        "        {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"Billi\"\n" +
                        "        }\n" +
                        "        ],\n" +
                        "        \"status\": \"available\"\n" +
                        "        }\n")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void cUpdateExistingPet() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"pagal\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"billi\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void dFindPetsByStatus() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 4)
    public void eFindPetsById() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 5)
    public void fUpdatePetWithFormData() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 6)
    public void gDeletePet() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/3");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
