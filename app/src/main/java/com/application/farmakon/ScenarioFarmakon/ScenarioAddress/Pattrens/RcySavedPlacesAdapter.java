package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Pattrens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.Address_Model;
import com.application.farmakon.Utils.TinyDB;

import java.util.List;

public class RcySavedPlacesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<Address_Model> mMainGridList;
    Context mContext;


    public RcySavedPlacesAdapter(List<Address_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.addres_item,parent,false);
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
        final Address_Model address_model = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textaddress.setText(address_model.getAddress());

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


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textaddress;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            textaddress = itemView.findViewById(R.id.txtAddress);


        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
