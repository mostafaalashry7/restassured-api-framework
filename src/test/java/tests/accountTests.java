package tests;

import base.baseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseClasses.UserDetails.UserResponse;
import utils.helperClass;
import utils.testDataReader;

import java.util.Map;

public class accountTests extends baseTest {

    @Test
    public void createAccountTest() {

        Response res = accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);
    }

    @Test
    public void validLogin() {

        Response res = accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        Response res2 = accountService.login(userData);

        Assert.assertEquals(getResponseCode(res2), 200);
        Assert.assertEquals(getResponseMsg(res2), msg.loginMsg);
    }

    @Test
    public void loginWithoutEmail() {

        Response res = accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        Response res2 = accountService.loginWithoutEmail(user.getPassword());

        Assert.assertEquals(getResponseCode(res2), 400);
        Assert.assertEquals(getResponseMsg(res2), msg.loginWithMissingParameter);
    }

    @Test
    public void shouldNotAllowDeleteOnLogin(){
        Response res = accountService.deleteOnLogin();

        Assert.assertEquals(getResponseCode(res), 405);
        Assert.assertEquals(getResponseMsg(res), msg.invalidRequestMethod);
    }

    @Test
    public void invalidLogin() {

        Response res = accountService.login(userData);

        Assert.assertEquals(getResponseCode(res), 404);
        Assert.assertEquals(getResponseMsg(res), msg.loginWithInvalidDataMsg);
    }

    @Test
    public void deleteAccount() {

        Response res = accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        Response res2 =  accountService.deleteAccount(userData);

        Assert.assertEquals(getResponseCode(res2), 200);
        Assert.assertEquals(getResponseMsg(res2), msg.accountDeletedMsg);

        Response res3 = accountService.login(userData);

        Assert.assertEquals(getResponseCode(res3), 404);
        Assert.assertEquals(getResponseMsg(res3), msg.loginWithInvalidDataMsg);

    }
    @Test
    public void updateAccount() {
        Response res =  accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        user.setName("Mostafa new");
        Map<String, Object> updatedUser = testDataReader.convertObjectToMap(user);

        Response res2 =  accountService.updateAccount(updatedUser);

        Assert.assertEquals(getResponseCode(res2), 200);
        Assert.assertEquals(getResponseMsg(res2), msg.accountUpdatedMsg);

        Response res3 = accountService.getUserDetailsByEmail(user.getEmail());

        UserResponse userDetails = helperClass.convertResponse(res3,UserResponse.class);

        Assert.assertEquals(userDetails.getUser().getName(), user.getName() );

    }



    @Test
    public void showAccountDetails() {
        Response res =  accountService.createAccount(userData);

        Assert.assertEquals(getResponseCode(res), 201);
        Assert.assertEquals(getResponseMsg(res), msg.accountCreatedMsg);

        Response res2 =   accountService.getUserDetailsByEmail(user.getEmail());

        UserResponse userDetails = helperClass.convertResponse(res2,UserResponse.class);

        Assert.assertEquals(getResponseCode(res2), 200);
        Assert.assertEquals(userDetails.getUser().getName(), "Mostafa");
    }

}
