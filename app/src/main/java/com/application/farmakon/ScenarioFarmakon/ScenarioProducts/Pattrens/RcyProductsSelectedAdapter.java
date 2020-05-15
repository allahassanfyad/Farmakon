package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllSelectedItem;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class RcyProductsSelectedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<ModelAllSelectedItem> mMainGridList;
    Context mContext;


    public RcyProductsSelectedAdapter(List<ModelAllSelectedItem> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item,parent,false);
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
        final ModelAllSelectedItem catrgory  = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;

        mainHolder.texttitle.setText(catrgory.getTitle());
        mainHolder.textdescription.setText(catrgory.getDescription());
        mainHolder.textprice.setText(catrgory.getPrice());
        if ( catrgory.getPriceAfterDiscount() == null||catrgory.getPriceAfterDiscount().equals("0")){

            mainHolder.lineapricediscount.setVisibility(View.GONE);

        }else {

            mainHolder.lineapricediscount.setVisibility(View.VISIBLE);
            mainHolder.textpricediscount.setText(catrgory.getPriceAfterDiscount());
        }




        if ( catrgory.getPriceAfterDiscount() == null || catrgory.getPriceAfterDiscount().equals("0")){

            mainHolder.linearpricepercentage.setVisibility(View.GONE);

        }else {

            double price_after = Double.parseDouble(catrgory.getPriceAfterDiscount());
            double price_before = Double.parseDouble(catrgory.getPrice());

            double calculate_discount = price_after*100/price_before;

            int discount_percentage = (int) (100-calculate_discount);

            mainHolder.linearpricepercentage.setVisibility(View.VISIBLE);
            mainHolder.textdiscountpercentage.setText(""+discount_percentage);
        }

        Glide.with(mContext)
                .load(catrgory.getImage())
                .placeholder(R.drawable.img)
                .into(mainHolder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tinyDB.putString("product_description",catrgory.getDescription());
                tinyDB.putString("product_image",catrgory.getImage());
                tinyDB.putString("product_price",catrgory.getPrice());
                tinyDB.putString("product_title",catrgory.getTitle());
                tinyDB.putString("product_id", String.valueOf(catrgory.getId()));


                mContext.startActivity(new Intent(mContext, Product_Details.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView texttitle,textdescription,textprice,textpricediscount,textdiscountpercentage;
        ImageView imageView;
        LinearLayout lineapricediscount,linearpricepercentage;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            texttitle = itemView.findViewById(R.id.txtProductTitle);
            textdescription = itemView.findViewById(R.id.txtProductDescription);
            textdiscountpercentage = itemView.findViewById(R.id.txtProductPriceDiscountPercentage);
            textprice = itemView.findViewById(R.id.txtProductPrice);
            textpricediscount = itemView.findViewById(R.id.txtProductPriceDiscount);
            lineapricediscount = itemView.findViewById(R.id.linearDiscount);
            linearpricepercentage = itemView.findViewById(R.id.linearDiscountPercentage);

            imageView = itemView.findViewById(R.id.imgProducts);

        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
