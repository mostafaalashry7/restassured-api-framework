package tests.products;

import base.baseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseClasses.Products.ProductsList;
import utils.helperClass;

public class ProductListingTests extends baseTest {

    @Test
    public void getAllProducts() {

        Response res = productsService.getAllProducts();

        ProductsList productsList = helperClass.convertResponse(res, ProductsList.class);

        Assert.assertEquals(getResponseCode(res), 200);
        Assert.assertEquals(productsList.getProducts().get(1).getCategory().getUsertype().getUsertype(), "Men");
    }

    @Test
    public void postToAllProducts() {
        Response res = productsService.postToAllProducts();

        Assert.assertEquals(getResponseCode(res), 405);
        Assert.assertEquals(getResponseMsg(res), msg.invalidRequestMethod);
    }
}
