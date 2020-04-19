package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Pattrens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.Address_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model.Previous_Order_Model;
import com.application.farmakon.Utils.TinyDB;

import java.util.List;

public class RcyPreviousOrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<Previous_Order_Model> mMainGridList;
    Context mContext;


    public RcyPreviousOrdersAdapter(List<Previous_Order_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_order_item,parent,false);
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
        final Previous_Order_Model previous_order_model = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;

        mainHolder.textprice.setText(previous_order_model.getPrice());
        mainHolder.textdate.setText(previous_order_model.getDate());

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
        TextView textprice,textdate;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            textprice = itemView.findViewById(R.id.txtPreviousPrice);
            textdate = itemView.findViewById(R.id.txtPreviousDate);


        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
