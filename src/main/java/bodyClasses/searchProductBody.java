package bodyClasses;

public class searchProductBody {

    private String productName;

    public searchProductBody() {
    }

    public searchProductBody(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
