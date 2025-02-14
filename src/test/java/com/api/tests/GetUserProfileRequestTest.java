package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test
    public void getProfileInfoTest(){

        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("alia1234","alia123456$");
        Response loginRequestResponse = authService.login(loginRequest);
        String token = loginRequestResponse.as(LoginResponse.class).getToken();
        System.out.println(token);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response response = userProfileManagementService.getProfile(token);
        System.out.println(response.getStatusCode());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());

    }

}
