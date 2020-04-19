package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model;

public class Category_Model {
    private String category_name;
    private int img_category;


    public Category_Model(String category_name, int img_category) {
        this.category_name = category_name;
        this.img_category = img_category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getImg_category() {
        return img_category;
    }

    public void setImg_category(int img_category) {
        this.img_category = img_category;
    }
}
