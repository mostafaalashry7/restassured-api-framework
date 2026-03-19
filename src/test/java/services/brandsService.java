package services;

import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class brandsService extends baseService {
    public brandsService() throws IOException {
        super();
    }

    public Response getAllBrands() {
        return given()
                .baseUri(base_url)
                .when()
                .get(brandsListEndPoint);
    }

    public Response putToAllBrands() {
        return given()
                .baseUri(base_url)
                .when()
                .put(brandsListEndPoint);
    }


}
