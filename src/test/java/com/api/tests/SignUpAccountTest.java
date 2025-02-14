package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpAccountTest {

    @Test
    public void signupAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
            .username("alia1234")
            .firstName("Alia")
            .lastName("Bhatt")
            .password("alia123456$")
            .mobileNumber("9999955555")
            .email("test@test11.com")
            .build();

        Response response = new AuthService().signup(signUpRequest);
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.asPrettyString(), "Error: Username is already taken!");

    }


}
