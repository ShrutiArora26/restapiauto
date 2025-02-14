package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest1 {


    @Test
    public void loginTest(){

        AuthService authService = new AuthService();
     //   Response response = authService.login("{\"username\": \"shruti\", \"password\": \"Changeme1234$\"}");
      //  System.out.println(response.getStatusCode());
     //   System.out.println(response.asPrettyString());
    }

}
