package com.example.dell.loginandsignup;

/**
 * Created by DELL on 6/4/2018.
 */

public class Product {
    String productName;
    String productDesc;
    String price;
    boolean selection;
    int productImage;

    public boolean getSelection() {
        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public Product(int productImage, String productName, String productDesc, String price, boolean selection) {

        this.productImage = productImage;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.selection=selection;

    }

    public Product(boolean selection) {
        this.selection = selection;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getProductImage() {

        return productImage;
    }

}
