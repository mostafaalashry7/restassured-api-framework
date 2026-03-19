package tests;

import base.baseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import responseClasses.Brands.BrandsList;
import utils.helperClass;

public class brandsTests extends baseTest {

    @Test
    public void putToAllBrands() {
        Response res = brandsService.putToAllBrands();
        Assert.assertEquals(getResponseCode(res), 405);
        Assert.assertEquals(getResponseMsg(res), msg.invalidRequestMethod);
    }


    @Test
    public void getAllBrands() {
        Response res = brandsService.getAllBrands();

        BrandsList brandsList = helperClass.convertResponse(res, BrandsList.class);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(brandsList.getBrands().get(0).getBrand(), "Polo");
    }

}
