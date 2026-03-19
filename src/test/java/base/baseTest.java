package base;

import bodyClasses.userAccountBody;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import responseClasses.messagesResponse.messages;
import services.accountService;
import services.brandsService;
import services.productsService;
import utils.testDataReader;
import java.io.IOException;
import java.util.Map;

public class baseTest {

    protected accountService accountService;
    protected productsService productsService;
    protected brandsService brandsService;

    private final String userDataPath = "src/main/resources/userData.json";

    public messages msg = new messages();
    public userAccountBody user;
    public Map<String, Object> userData;

    public String getResponseMsg(Response res) {
        String message = res.jsonPath().getString("message");
        return message;
    }

    public int getResponseCode(Response res) {
        int code = res.jsonPath().getInt("responseCode");
        return code;
    }

    @BeforeClass
    public void beforeClass() throws IOException {

        accountService = new accountService();
        productsService = new productsService();
        brandsService = new brandsService();

    }

    @BeforeMethod
    public void beforeTest() throws IOException
    {
        user = testDataReader.readJson(userDataPath, userAccountBody.class);
        user.makeEmailChange();
        userData = testDataReader.convertObjectToMap(user);
    }


}
