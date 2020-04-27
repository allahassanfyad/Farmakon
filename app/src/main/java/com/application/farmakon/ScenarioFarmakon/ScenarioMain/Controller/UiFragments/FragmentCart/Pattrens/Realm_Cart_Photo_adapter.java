package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens;

import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Photo_Model;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmResults;
public class Realm_Cart_Photo_adapter {
    Realm realm;


    public Realm_Cart_Photo_adapter(Realm realm) {
        this.realm = realm;
    }

    public void save(final Realm_Cart_Photo_Model cartModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


//                Rcy_Cart_Model c = realm.copyToRealm(cartModel);

/*
                //int x = (int) UUID.randomUUID().getMostSignificantBits();
                //c.setId(x);
                // increment index
                Number currentIdNum = realm.where(Cart_Model.class).max("id");
                int nextId;
                if(currentIdNum == null) {
                    nextId = currentIdNum.intValue() + 1;
                } else {
                    nextId = currentIdNum.intValue() + 1;
                }

                Cart_Model z = new Cart_Model();
                z.setId(nextId);

 */

                //...
                //realm.insertOrUpdate(user); // using insert API


                Number currentIdNum = realm.where(Realm_Cart_Photo_Model.class).max("id");
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



//        public void updaterecivernots ( final int id, final String reciverdetails){
//            realm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(@NotNull Realm realm) {
//
//
//                    Realm_Cart_Photo_Model cartModel = realm.where(Realm_Cart_Photo_Model.class).equalTo("id", id).findFirst();
//                    if (cartModel != null) {
//
//
//                        cartModel.setNotes(reciverdetails);
//
//                        realm.copyToRealmOrUpdate(cartModel);
//
//
//                    }
//
//                }
//            });
//
//
//        }


//

        public void delete ( final int i){

            realm = Realm.getDefaultInstance();

            final RealmResults<Realm_Cart_Photo_Model> results = realm.where(Realm_Cart_Photo_Model.class).findAll();
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


        public ArrayList<Realm_Cart_Photo_Model> retrieve () {
            ArrayList<Realm_Cart_Photo_Model> cart_data = new ArrayList<>();

            realm = Realm.getDefaultInstance();
            RealmResults<Realm_Cart_Photo_Model> cart_models = realm.where(Realm_Cart_Photo_Model.class).findAll();

            for (Realm_Cart_Photo_Model s : cart_models) {

                cart_data.add(s);


            }
            return cart_data;

        }

        public void delete_all () {

            realm = Realm.getDefaultInstance();

            final RealmResults<Realm_Cart_Photo_Model> results = realm.where(Realm_Cart_Photo_Model.class).findAll();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    realm.deleteAll();

                }
            });
        }
    }
