package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest extends TestBase {
    static ValidatableResponse response;

    public UserAssertionTest() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 20
    @Test
    public void test001() {
        response.body("size", equalTo(20));
    }

    // 2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
    @Test
    public void test002() {
        response.body("find{it.id==5230}.name", equalTo("Nirbhay Khan"));
    }

    //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void test003() {
        response.body("[1].name", equalTo("Aanjaneya Banerjee"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void test004() {
        response.body("findAll{it.name}", hasItems("Bhilangana Shah", "Ganak Jain", "Nirbhay Khan"));
    }

    //5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test005() {
        response.body("find{it.id==5233}.name", equalTo("Ganak Jain"));
    }

    //6.Verify the status is “Active” of user name is “Ganak Jain”
    @Test
    public void test006() {
        response.body("find{it.name=='Ganak Jain'}.status", equalTo("active"));
    }

    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007() {
        response.body("find{it.name=='Ganak Jain'}.gender", equalTo("female"));
    }
}
