package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Realm_Cart_Product_Model extends RealmObject {



    private String txttitle;
    private String txtprice;
    private String txtnumberchoose;
    private String imgproduct;
    private String product_id;
    private String address_id;
    private String notes;
    @PrimaryKey
    private int id;

    public Realm_Cart_Product_Model(String txttitle, String txtprice, String txtnumberchoose, String imgproduct, String product_id, String address_id, String notes, int id) {
        this.txttitle = txttitle;
        this.txtprice = txtprice;
        this.txtnumberchoose = txtnumberchoose;
        this.imgproduct = imgproduct;
        this.product_id = product_id;
        this.address_id = address_id;
        this.notes = notes;
        this.id = id;
    }

    public Realm_Cart_Product_Model() {
    }

    @Override
    public String toString() {
        return "Realm_Cart_Photo_Model{" +
                "txttitle='" + txttitle + '\'' +
                ", txtprice='" + txtprice + '\'' +
                ", txtnumberchoose='" + txtnumberchoose + '\'' +
                ", imgproduct=" + imgproduct +
                ", product_id='" + product_id + '\'' +
                ", address_id='" + address_id + '\'' +
                ", notes='" + notes + '\'' +
                ", id=" + id +
                '}';
    }


    public String getTxttitle() {
        return txttitle;
    }

    public void setTxttitle(String txttitle) {
        this.txttitle = txttitle;
    }

    public String getTxtprice() {
        return txtprice;
    }

    public void setTxtprice(String txtprice) {
        this.txtprice = txtprice;
    }

    public String getTxtnumberchoose() {
        return txtnumberchoose;
    }

    public void setTxtnumberchoose(String txtnumberchoose) {
        this.txtnumberchoose = txtnumberchoose;
    }

    public String getImgproduct() {
        return imgproduct;
    }

    public void setImgproduct(String imgproduct) {
        this.imgproduct = imgproduct;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
