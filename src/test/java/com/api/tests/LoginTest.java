package com.api;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void login() {

        Response response = given().baseUri("http://64.227.160.186:8080/api/auth/login")
            .header("Content-type", "application/json")
            .body("{\"username\": \"shruti\", \"password\": \"Changeme1234$\"}")
            .post();

        System.out.println(response.asPrettyString());

        System.out.println("#################");

        Response response1 = given().baseUri("http://64.227.160.186:8080/api/")
            .header("Content-type", "application/json")
            .body("{\"username\": \"shruti\", \"password\": \"Changeme1234$\"}")
            .post("auth/login");

        System.out.println(response1.asPrettyString());


    }

}
