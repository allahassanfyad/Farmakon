package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model;

public class Previous_Order_Model {
    private String price;
    private String date;

    public Previous_Order_Model(String price, String date) {
        this.price = price;
        this.date = date;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
