package services;

import bodyClasses.userAccountBody;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class accountService extends baseService {
    private userAccountBody user;


    public accountService() throws IOException {
        super();
    }

    public Response createAccount(Map<String, Object> userData) {
        return given()
                .baseUri(base_url)
                .formParams(userData)
                .when()
                .post(createPageEndPoint)
                .then()
                .extract()
                .response();
    }

    public Response login(Map<String, Object> userData) {
        return given()
                .baseUri(base_url)
                .formParams(userData)
                .when()
                .post(loginPageEndPoint);
    }

    public Response updateAccount(Map<String, Object> userData) {
        return given()
                .baseUri(base_url)
                .formParams(userData)
                .when()
                .put(updatePageEndPoint);
    }

    public Response deleteAccount(Map<String, Object> userData) {
        return given()
                .baseUri(base_url)
                .formParams(userData)
                .when()
                .delete(deletePageEndPoint);
    }

    public Response getUserDetailsByEmail(String email) {
        return given()
                .baseUri(base_url)
                .queryParam("email", email)
                .when()
                .get(userDetailByEmailEndPoint)
                .then()
                .extract()
                .response();
    }

    public Response loginWithoutEmail(String password) {

        return  given()
                .baseUri(base_url)
                .formParams("password", password)
                .when()
                .post(loginPageEndPoint);
    }
     public Response deleteOnLogin(){
        return given()
                 .baseUri(base_url)
                 .when()
                 .delete(loginPageEndPoint);
     }

}

