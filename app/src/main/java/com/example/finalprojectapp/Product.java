package com.example.finalprojectapp;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private  String prodid;
    private  String pname;
    private  String pcat;
    private  String pic;
    private int price;


    public Product(String pname, String pcat, String photoname, int price) {
        this.pname = pname;
        this.pcat = pcat;
        this.pic = pic;
        this.price = price;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object>
                result = new HashMap<>();
        result.put("pname", pname);
        result.put("price", price);
        result.put("pic", pic);
        result.put("prodid", prodid);
        result.put("pcat", pcat);
        return result;
    }

    public Product (){

    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getPcat() {
        return pcat;
    }

    public void setPcat(String pcat) {
        this.pcat = pcat;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  getPname();
    }
}
