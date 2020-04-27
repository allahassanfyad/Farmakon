package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Photo_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

import io.realm.Realm;

public class RcyCartPhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<Realm_Cart_Photo_Model> mMainGridList;
    Context mContext;
    Realm realm;
    Realm_Cart_Photo_adapter adapter_Photo;


    public RcyCartPhotoAdapter(List<Realm_Cart_Photo_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_photo,parent,false);
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
        final Realm_Cart_Photo_Model notification = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;

        Glide.with(mContext)
                .load(notification.getImghome())
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
                                adapter_Photo = new Realm_Cart_Photo_adapter(realm);
                                adapter_Photo.delete(position);
                                adapter_Photo.retrieve();
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


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView txtdeleteitem;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgCartItemPhoto);
            txtdeleteitem = itemView.findViewById(R.id.txtDeleteItem);


        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
