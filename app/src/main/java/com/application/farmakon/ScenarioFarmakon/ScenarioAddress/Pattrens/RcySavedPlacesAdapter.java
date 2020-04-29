package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Pattrens;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.Address_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.ModelGetAddressDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Controller.checkout;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller.Fragment_Cart;
import com.application.farmakon.Utils.TinyDB;

import java.util.List;

public class RcySavedPlacesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    TinyDB tinyDB;
    List<ModelGetAddressDatum> mMainGridList;
    Context mContext;


    public RcySavedPlacesAdapter(List<ModelGetAddressDatum> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.addres_item, parent, false);
        MainItemHolder mainHolder = new MainItemHolder(ads);
        return mainHolder;
    }

    public class MainHolder extends RecyclerView.ViewHolder {
        public MainHolder(View itemview) {
            super(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        tinyDB = new TinyDB(mContext);
        int viewType = getItemViewType(position);
        final ModelGetAddressDatum address_model = mMainGridList.get(position);


        MainItemHolder mainHolder = (MainItemHolder) holder;


        mainHolder.textaddress.setText(address_model.getAddressName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Fragment_Cart.address == 1) {

                    Fragment_Cart.address = 0;


                    tinyDB.putString("AddressName", address_model.getAddressName());
                    tinyDB.putString("AddressId", String.valueOf(address_model.getId()));

                    mContext.startActivity(new Intent(mContext, checkout.class));
                    ((AppCompatActivity)mContext).finish();

                }else {

                    Log.e("doNothing","Nothing");

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder {
        TextView textaddress;


        public MainItemHolder(@NonNull View itemView) {
            super(itemView);
            textaddress = itemView.findViewById(R.id.txtAddress);


        }

    }

    public interface OnItemListener {
        void onItemClick(int position);
    }


}
