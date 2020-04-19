package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model;

public class Products_model {

    private int img;
    private String title;
    private String discription;
    private String price;
    private String priceDiscount;
    private String percentageDiscount;


    public Products_model(int img, String title, String discription, String price, String priceDiscount, String percentageDiscount) {
        this.img = img;
        this.title = title;
        this.discription = discription;
        this.price = price;
        this.priceDiscount = priceDiscount;
        this.percentageDiscount = percentageDiscount;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(String priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
}
