package com.bridgelabz.petstorerestassuredtesting;

import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreRestAssuredTesting {

    @Test(priority = 0)
    public void createUser() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Ashwini\",\n" +
                        "  \"firstName\": \"Ashwini\",\n" +
                        "  \"lastName\": \"Shirsath\",\n" +
                        "  \"email\": \"ash9495@gmail.com\",\n" +
                        "  \"password\": \"ash123\",\n" +
                        "  \"phone\": \"7020998822\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 1)
    public void createUserWithArray() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"Ashwini\",\n" +
                        "    \"firstName\": \"Ash\",\n" +
                        "    \"lastName\": \"Shirsath\",\n" +
                        "    \"email\": \"ash@gmail.com\",\n" +
                        "    \"password\": \"ash9495\",\n" +
                        "    \"phone\": \"976773664\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void createUserWithList() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"Ashwini\",\n" +
                        "    \"firstName\": \"Ash\",\n" +
                        "    \"lastName\": \"Shirsath\",\n" +
                        "    \"email\": \"ash@gmail.com\",\n" +
                        "    \"password\": \"ash9495\",\n" +
                        "    \"phone\": \"976773664\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 3)
    public void deleteUser() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/Ashwini");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 4)
    public void getUserByUsername() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/Ashwini");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 5)
    public void loginWithArray() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=Ashwini&password=ash123");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 6)
    public void logoutUser() {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test(priority = 7)
    public void putUpdateUser(){
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"Ash\",\n" +
                        "  \"firstName\": \"Ash\",\n" +
                        "  \"lastName\": \"Nikum\",\n" +
                        "  \"email\": \"ash9495@gmail.com\",\n" +
                        "  \"password\": \"ash123\",\n" +
                        "  \"phone\": \"945656854\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Ashwini");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    

}






