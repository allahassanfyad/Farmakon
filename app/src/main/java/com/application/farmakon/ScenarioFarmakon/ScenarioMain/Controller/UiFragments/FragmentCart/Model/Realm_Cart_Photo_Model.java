package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Realm_Cart_Photo_Model extends RealmObject {


    private String imghome;
    @PrimaryKey
    private int id;

    public Realm_Cart_Photo_Model(String imghome, int id) {
        this.imghome = imghome;
        this.id = id;
    }

    public Realm_Cart_Photo_Model() {
    }

    public String getImghome() {
        return imghome;
    }

    public void setImghome(String imghome) {
        this.imghome = imghome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
