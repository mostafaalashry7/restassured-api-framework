package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import responseClasses.Brands.BrandsList;
import responseClasses.Products.ProductsList;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class helperClass {
    private static final ObjectMapper mapper = new ObjectMapper();

        public static String getProperty(String Filename, String Key) throws IOException {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src\\test\\resources\\properties\\" + Filename + ".properties"));
            return prop.getProperty(Key);
        }

    public static String extractJson(Response res){

        return res.asString()
                .replace("<html>", "")
                .replace("</html>", "")
                .replace("<body>", "")
                .replace("</body>", "")
                .trim();
    }


//    public static ProductsList getProductsListObject(Response res) {
//        try {
//            String json = extractJson(res);
//           // System.out.println("JSON AFTER CLEANING: " + json);
//            return mapper.readValue(json, ProductsList.class);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to convert response to ProductsList", e);
//        }
//    }
//
//    public static BrandsList getBrandsListObject(Response res) {
//        try {
//          String json = extractJson(res);
//            //System.out.println("JSON AFTER CLEANING: " + json);
//            return mapper.readValue(json, BrandsList.class);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to convert response to ProductsList", e);
//        }
//    }
    public static <T> T convertResponse(Response res, Class<T> clazz) {
        try {
            String json = extractJson(res);
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert response", e);
        }
    }

}



