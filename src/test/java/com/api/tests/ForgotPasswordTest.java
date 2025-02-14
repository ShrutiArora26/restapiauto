package com.api;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {


    @Test
    public void forgotPwd() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("shrutiengg8@gmail.com");
        System.out.println(response.asPrettyString());
    }

}
