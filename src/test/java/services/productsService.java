package services;

import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class productsService extends baseService {
    public productsService() throws IOException {
        super();
    }

    public Response getAllProducts() {
        return given()
                .baseUri(base_url)
                .when()
                .get(productsListEndPoint);
    }

    public Response postToAllProducts() {
        return given()
                .baseUri(base_url)
                .when()
                .post(productsListEndPoint);
    }

    public Response searchProduct(String name) {
        return given()
                .baseUri(base_url)
                .multiPart("search_product", name)
                .when()
                .post(searchPageEndPoint);
    }

    public Response searchProductWithoutParameter() {
        return given()
                .baseUri(base_url)
                .when()
                .post(searchPageEndPoint);
    }

}
