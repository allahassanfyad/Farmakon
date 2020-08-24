package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller.Fragment_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelPartnerDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller.Product_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller.Products;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllSelectedItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelSubDatum;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RcySubcategoryGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements NetworkInterface
{

    TinyDB tinyDB;
    List<ModelSubDatum> mMainGridList;
    Context mContext;
    private int selected_position = 0;

    private List<ModelCategoryDatum> productsModelList = new ArrayList<>();
    ModelCategoryDatum[] productdata;


    public RcySubcategoryGridAdapter(List<ModelSubDatum> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_category_item,parent,false);
        MainItemHolder mainHolder = new MainItemHolder(ads) ;
        return mainHolder;
    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        productsModelList.clear();

        Gson gson = new Gson();
        Fragment_Category.x = 0;

        ModelCategoryProduct categoryProduct = gson.fromJson(String.valueOf(model.getJsonObject()), ModelCategoryProduct.class);
        productdata = categoryProduct.getData();

        for (int i = 0; i < productdata.length; i++) {

            ModelCategoryDatum datum = new ModelCategoryDatum();

            datum.setDescription(productdata[i].getDescription());
            datum.setId(productdata[i].getId());
            datum.setImage(productdata[i].getImage());
            datum.setPrice(productdata[i].getPrice());
            datum.setQtyStock(productdata[i].getQtyStock());
            datum.setTitle(productdata[i].getTitle());
            datum.setPriceAfterDiscount(productdata[i].getPriceAfterDiscount());

            productsModelList.add(datum);

        }
        if (productsModelList.size() == 0) {

            Product_Category.txtNoItem.setVisibility(View.VISIBLE);
            Product_Category.rcyProductCategory.setVisibility(View.GONE);

        } else {
            Product_Category.txtNoItem.setVisibility(View.GONE);
            Product_Category.rcyProductCategory.setVisibility(View.VISIBLE);
            Product_Category.rcyProductCategory.setHasFixedSize(true);
            Product_Category.rcyProductCategory.setLayoutManager(new LinearLayoutManager(mContext));
            RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList, mContext);
            Product_Category.rcyProductCategory.setAdapter(adabter);
        }

    }

    @Override
    public void OnError(VolleyError error) {

        Log.e("error",error.toString());

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
        final ModelSubDatum catrgory  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.txttitle.setText(catrgory.getTitle());

//        Glide.with(mContext)
//                .load(catrgory.getImage())
//                .placeholder(R.drawable.img)
//                .into(mainHolder.imageView);

        if (selected_position == position) {
            // do your stuff here like
            //Change selected item background color and Show sub item views

            final int sdk = android.os.Build.VERSION.SDK_INT;

            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                mainHolder.txttitle.setTextColor(Color.parseColor("#FFFFFF"));
                mainHolder.linearSubcategory.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.raduis_all_selected));
            } else {
                mainHolder.txttitle.setTextColor(Color.parseColor("#FFFFFF"));
                mainHolder.linearSubcategory.setBackground(ContextCompat.getDrawable(mContext, R.drawable.raduis_all_selected));
            }

        } else {
            // do your stuff here like
            //Change  unselected item background color and Hide sub item views

            final int sdk = android.os.Build.VERSION.SDK_INT;

            if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                mainHolder.txttitle.setTextColor(Color.parseColor("#000000"));
                mainHolder.linearSubcategory.setBackgroundDrawable(ContextCompat.getDrawable(mContext, R.drawable.raduis_all_unselected));
            } else {
                mainHolder.txttitle.setTextColor(Color.parseColor("#000000"));
                mainHolder.linearSubcategory.setBackground(ContextCompat.getDrawable(mContext, R.drawable.raduis_all_unselected));
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinyDB = new TinyDB(mContext);


                if (selected_position == position) {
                    selected_position = -1;
                    notifyDataSetChanged();
                    return;
                }
                selected_position = position;
                notifyDataSetChanged();

                new Apicalls(mContext,RcySubcategoryGridAdapter.this).category_product(String.valueOf(catrgory.getId()));

//
//                tinyDB.putString("categoryID", String.valueOf(mMainGridList.get(position).getId()));
//
//                mContext.startActivity(new Intent(mContext, Products.class));

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
        TextView txttitle;
        LinearLayout linearSubcategory;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgCategory);
            txttitle = itemView.findViewById(R.id.txtSubcategory);
            linearSubcategory = itemView.findViewById(R.id.linearSubcategory);
        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
