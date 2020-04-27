package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens;

import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Realm_Cart_Product_adapter {
    Realm realm;


    public Realm_Cart_Product_adapter(Realm realm) {
        this.realm = realm;
    }

    public void save(final Realm_Cart_Product_Model cartModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {



                Number currentIdNum = realm.where(Realm_Cart_Product_Model.class).max("id");
                int nextId;
                if (currentIdNum == null) {
                    nextId = 100;
                } else {
                    nextId = currentIdNum.intValue() + 1;
                }
//                Rcy_Cart_Model cart = new Rcy_Cart_Model(); // unmanaged
                cartModel.setId(nextId);
                //...
                realm.insertOrUpdate(cartModel); // using insert API
//                realm.copyToRealm(cartModel);


            }
        });

    }

    public void updaatenumberofboxes ( final int id, final String numberChoosen){
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(@NotNull Realm realm) {


                    Realm_Cart_Product_Model cartModel = realm.where(Realm_Cart_Product_Model.class).equalTo("id", id).findFirst();
                    if (cartModel != null) {

                        cartModel.setTxtnumberchoose(numberChoosen);

                        realm.copyToRealmOrUpdate(cartModel);


                    }

                }
            });

        }

        public void delete ( final int i){

            realm = Realm.getDefaultInstance();

            final RealmResults<Realm_Cart_Product_Model> results = realm.where(Realm_Cart_Product_Model.class).findAll();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    // remove single match
                    //results.deleteFirstFromRealm();
                    //results.deleteLastFromRealm();

                    // remove a single object


                    results.deleteFromRealm(i);

                    // Delete all matches
                    // results.deleteAllFromRealm();
                }
            });
        }


        public ArrayList<Realm_Cart_Product_Model> retrieve () {
            ArrayList<Realm_Cart_Product_Model> cart_data = new ArrayList<>();

            realm = Realm.getDefaultInstance();
            RealmResults<Realm_Cart_Product_Model> cart_models = realm.where(Realm_Cart_Product_Model.class).findAll();

            for (Realm_Cart_Product_Model s : cart_models) {

                cart_data.add(s);


            }
            return cart_data;

        }

        public void delete_all () {

            realm = Realm.getDefaultInstance();

            final RealmResults<Realm_Cart_Product_Model> results = realm.where(Realm_Cart_Product_Model.class).findAll();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    realm.deleteAll();

                }
            });
        }
    }
