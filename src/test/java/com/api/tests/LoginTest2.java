package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginTest2 {

    @Test
    public void loginTest(){

        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("shruti","Changeme1234$");
        Response response = authService.login(loginRequest);
        System.out.println(response.getStatusCode());
//        System.out.println(response.asPrettyString());

        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println("token : " + loginResponse.getToken());
        System.out.println("email : " + loginResponse.getEmail());
        System.out.println("id : " + loginResponse.getId());
        System.out.println("type : " + loginResponse.getType());
        System.out.println("username : " + loginResponse.getUsername());
        System.out.println("role : " + loginResponse.getRoles());

        Assert.assertTrue(loginResponse.getToken()!=null);
        Assert.assertEquals(loginResponse.getEmail(),"test@test.com");
        Assert.assertEquals(loginResponse.getType(),"Bearer");
        Assert.assertEquals(loginResponse.getId(),46);
        Assert.assertEquals(loginResponse.getUsername(),"shruti");
        Assert.assertEquals(loginResponse.getRoles().get(0),"ROLE_USER");

    }



}
