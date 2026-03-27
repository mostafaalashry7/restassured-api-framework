package tests.authentication;

import base.baseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends baseTest {

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
    public void shouldNotAllowDeleteOnLogin() {
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
}
