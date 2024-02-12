package org.example.exercise2;

import java.util.List;

public class Distributor {
    List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Distributor(List<Product> productList) {
        this.productList = productList;
    }
    public double totalSellAmount(int productIndex, int productQuantity) {
        return this.productList.get(productIndex).calculate(productQuantity);
    }
}
