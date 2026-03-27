package tests.users;

import base.baseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseClasses.UserDetails.UserResponse;
import utils.helperClass;

public class UserDetailsTests extends baseTest {

    @Test
    public void showAccountDetails() {
        Response res = accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        Response res2 = accountService.getUserDetailsByEmail(user.getEmail());

        UserResponse userDetails = helperClass.convertResponse(res2, UserResponse.class);

        Assert.assertEquals(getResponseCode(res2), 200);
        Assert.assertEquals(userDetails.getUser().getName(), "Mostafa");
    }
}
