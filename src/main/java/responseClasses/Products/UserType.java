package responseClasses.Products;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserType {

    private String usertype;

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
