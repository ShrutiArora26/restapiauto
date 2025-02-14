package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {


    @Test
    public void testPut() {


        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("alia1234","alia123456$"));
        String token = response.as(LoginResponse.class).getToken();
        System.out.println(token);
        System.out.println(response.asPrettyString());

        System.out.println("------------ Get Profile Details -----------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response uspmSResponse = userProfileManagementService.getProfile(token);
        System.out.println(uspmSResponse.asPrettyString());
        UserProfileResponse uspResponse = uspmSResponse.as(UserProfileResponse.class);
        Assert.assertEquals(uspResponse.getUsername(),"alia1234");


        System.out.println("------------ Update profile below -----------");
        UserProfileRequest userProfileRequest = new UserProfileRequest.Builder()
            .firstName("Alia")
            .lastName("Bhatt")
            .email("alia@test1144.com")
            .mobileNumber("9999955555")
            .build();

        Response userProfileRequestResponse = userProfileManagementService.updateProfile(token,userProfileRequest);
        System.out.println(userProfileRequestResponse.asPrettyString());












    }
}
