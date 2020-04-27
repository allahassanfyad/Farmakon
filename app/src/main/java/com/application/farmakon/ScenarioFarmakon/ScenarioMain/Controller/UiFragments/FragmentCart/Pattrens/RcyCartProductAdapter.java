package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller.Fragment_Cart;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

import io.realm.Realm;

public class RcyCartProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<Realm_Cart_Product_Model> mMainGridList;
    Context mContext;
    Realm realm;
    Realm_Cart_Product_adapter adapter_product;
    int num = 1;


    public RcyCartProductAdapter(List<Realm_Cart_Product_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        MainItemHolder mainHolder = new MainItemHolder(ads) ;
        return mainHolder;
    }

    public class MainHolder extends RecyclerView.ViewHolder{
        public MainHolder(View itemview) {
            super(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        tinyDB = new TinyDB(mContext);
        int viewType = getItemViewType(position);
        final Realm_Cart_Product_Model cart_product_model = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.texttitle.setText(cart_product_model.getTxttitle());
        mainHolder.textprice.setText(cart_product_model.getTxtprice());
        mainHolder.txtnumber.setText(cart_product_model.getTxtnumberchoose());
        Glide.with(mContext)
                .load(cart_product_model.getImgproduct())
                .placeholder(R.drawable.img)
                .into(mainHolder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                tinyDB.putString("id_home",mMainGridList.get(position).getId());
//                //mContext.startActivity(new Intent(mContext, Product.class).putExtra("id_home",mMainGridList.get(position).getId()));
//                FragmentTransaction fr = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
//                fr.replace(R.id.fragment_container,new Product());
//                fr.addToBackStack(null);
//                fr.commit();
            }
        });

        mainHolder.txtdeleteitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBulder = new AlertDialog.Builder(mContext);

                alertDialogBulder.setTitle("Delete Product");

                alertDialogBulder
                        .setMessage("Are You Sure You Want To Delete This Product")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

//                                String price = "";
//
//                                Intent in = new Intent("delete_action");
//                                in.putExtra("category", price);
//                                mContext.sendBroadcast(in);


                                realm = Realm.getDefaultInstance();
                                adapter_product = new Realm_Cart_Product_adapter(realm);
                                adapter_product.delete(position);
                                adapter_product.retrieve();
                                mMainGridList.remove(position);
                                notifyItemRemoved(position);
                                FragmentTransaction fr = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
                                fr.replace(R.id.fragment_container,new Fragment_Cart());
                                fr.commit();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                //create it
                AlertDialog alertDialog = alertDialogBulder.create();
                // show it
                alertDialog.show();


            }
        });




        mainHolder.txtincreace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int price = Integer.parseInt(songs.getTxtprice());
//                int selectrd = num * price;
//
//                itemeCartHolder.txtprice.setText(""+selectrd);
//                totalPrice1 = Integer.parseInt(price_details[position].getPrice());

                num = Integer.parseInt(mainHolder.txtnumber.getText().toString());
                num++;
                if (num < 100) {

                    mainHolder.txtnumber.setText("" + num);
//                    itemeCartHolder.txtprice.setText("" + num * totalPrice1);

                    realm = Realm.getDefaultInstance();
                    adapter_product = new Realm_Cart_Product_adapter(realm);
                    adapter_product.updaatenumberofboxes(cart_product_model.getId(),mainHolder.txtnumber.getText().toString());

                } else if (num > 100) {
                    num = 100;
                    mainHolder.txtnumber.setText("" + num);
//                    itemeCartHolder.txtprice.setText("" + num * totalPrice1);
                    realm = Realm.getDefaultInstance();
                    adapter_product = new Realm_Cart_Product_adapter(realm);
                    adapter_product.updaatenumberofboxes(cart_product_model.getId(),mainHolder.txtnumber.getText().toString());

                }

            }
        });

        mainHolder.txtdecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = Integer.parseInt(mainHolder.txtnumber.getText().toString());
                num--;
                if (num >= 1) {
                    mainHolder.txtnumber.setText("" + num);
//                    txtprice.setText("" + num * totalPrice1);
                    realm = Realm.getDefaultInstance();
                    adapter_product = new Realm_Cart_Product_adapter(realm);
                    adapter_product.updaatenumberofboxes(cart_product_model.getId(),mainHolder.txtnumber.getText().toString());

                } else if (num <= 0) {
                    num = 1;
                    mainHolder.txtnumber.setText("" + num);
//                    txtprice.setText("" + num * totalPrice1);
                    realm = Realm.getDefaultInstance();
                    adapter_product = new Realm_Cart_Product_adapter(realm);
                    adapter_product.updaatenumberofboxes(cart_product_model.getId(),mainHolder.txtnumber.getText().toString());
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView texttitle,textprice,txtincreace,txtdecrease,txtnumber,txtdeleteitem;
        ImageView imageView;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            texttitle = itemView.findViewById(R.id.txtCartProductTitle);
            textprice = itemView.findViewById(R.id.txtCartProductPrice);
            imageView = itemView.findViewById(R.id.imgCartProductPhoto);
            txtdecrease = itemView.findViewById(R.id.txtCartProductDecrease);
            txtincreace = itemView.findViewById(R.id.txtCartProductIncrease);
            txtnumber = itemView.findViewById(R.id.txtCartProductNumber);
            txtdeleteitem = itemView.findViewById(R.id.txtDeleteItem);






        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
