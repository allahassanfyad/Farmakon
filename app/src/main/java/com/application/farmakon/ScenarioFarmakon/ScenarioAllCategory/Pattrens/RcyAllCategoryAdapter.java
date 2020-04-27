package com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Pattrens;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Model.ModelDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller.Products;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class RcyAllCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<ModelDatum> mMainGridList;
    Context mContext;


    public RcyAllCategoryAdapter(List<ModelDatum> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_category_item,parent,false);
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
        final ModelDatum catrgory  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.textname.setText(catrgory.getTitle());

        Glide.with(mContext)
                .load(catrgory.getImage())
                .placeholder(R.drawable.img)
                .into(mainHolder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB = new TinyDB(mContext);

                tinyDB.putString("categoryID", String.valueOf(mMainGridList.get(position).getId()));

                mContext.startActivity(new Intent(mContext, Products.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView textname;
        ImageView imageView;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            textname = itemView.findViewById(R.id.txtCategoryName);
            imageView = itemView.findViewById(R.id.imgCategory);

        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
