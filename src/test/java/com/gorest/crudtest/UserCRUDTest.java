package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;


    @Test
    public void verifyUserCreatedSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("nik");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization", "Bearer dd77f143acd8931458c5c40b3a660498bef432ddb490759253aaebffbccd8984")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public void verifyUsergetSuccessfully() {


        Response response = given()
                .header("Authorization", "Bearer dd77f143acd8931458c5c40b3a660498bef432ddb490759253aaebffbccd8984")
                .header("Connection", "keep-alive")
                .when()

                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();

        userPojo.setName("nik");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("Inactive");
        Response response = given()
                .header("Authorization", "Bearer dd77f143acd8931458c5c40b3a660498bef432ddb490759253aaebffbccd8984")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .put("/users/11735");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void VerifyUserDeleteSuccessfully() {
        Response response = given()
                .header("Authorization", "Bearer dd77f143acd8931458c5c40b3a660498bef432ddb490759253aaebffbccd8984")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/11735");
        response.prettyPrint();
        response.then().statusCode(204);


    }
}


