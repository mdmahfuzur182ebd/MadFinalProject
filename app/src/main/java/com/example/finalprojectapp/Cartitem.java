package com.example.finalprojectapp;

public class Cartitem<Product> {
    private Product product;
    private int qty;
    private  String userid;

    public  Cartitem(Product product, int qty, String userid){
        this.product =product;
        this.qty=qty;
        this.userid =userid;
    }


    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
