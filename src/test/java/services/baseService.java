package services;

import utils.helperClass;

import java.io.IOException;

public class baseService  {
    protected String base_url;
    protected String productsListEndPoint;
    protected String brandsListEndPoint;
    protected String searchPageEndPoint;
    protected String loginPageEndPoint;
    protected String createPageEndPoint;
    protected String deletePageEndPoint;
    protected String updatePageEndPoint;
    protected String userDetailByEmailEndPoint;

    public  baseService() throws IOException {

        this.base_url = helperClass.getProperty("environment", "base_url");
        this.productsListEndPoint = helperClass.getProperty("environment", "productsListEndPoint");
        this.brandsListEndPoint = helperClass.getProperty("environment", "brandsListEndPoint");
        this.searchPageEndPoint = helperClass.getProperty("environment", "searchPageEndPoint");
        this.loginPageEndPoint = helperClass.getProperty("environment", "loginPageEndPoint");
        this.createPageEndPoint = helperClass.getProperty("environment", "createPageEndPoint");
        this.deletePageEndPoint = helperClass.getProperty("environment", "deletePageEndPoint");
        this.updatePageEndPoint = helperClass.getProperty("environment", "updatePageEndPoint");
        this.userDetailByEmailEndPoint = helperClass.getProperty("environment", "userDetailByEmailEndPoint");

    }
}


