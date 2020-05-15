package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller.Fragment_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllSelectedItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsSelectedAdapter;
import com.application.farmakon.Utils.TinyDB;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Products extends AppCompatActivity implements NetworkInterface {

    private RecyclerView recyclerView;
    private List<ModelCategoryDatum> productsModelList = new ArrayList<>();
    ModelCategoryDatum[] productdata;
    TinyDB tinyDB;
    TextView txtNoItem;
    ModelAllSelectedItem[] selectedItems;
    private List<ModelAllSelectedItem> selectedItemList = new ArrayList<>();
    private ShimmerFrameLayout shimmerFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        tinyDB = new TinyDB(getApplicationContext());


        txtNoItem = findViewById(R.id.txtNoItem);
        recyclerView = findViewById(R.id.rcyAllCategory);
        shimmerFrameLayout = findViewById(R.id.loading_Shimmer);

        txtNoItem.setVisibility(View.GONE);

        if (Fragment_Category.x == 2) {

            String search_word = tinyDB.getString("search_word");
            new Apicalls(Products.this, Products.this).search_product(search_word);

        } else if (Fragment_Category.x == 1) {


            new Apicalls(Products.this, Products.this).get_all_products();

        } else {

            String category_id = tinyDB.getString("categoryID");
            new Apicalls(Products.this, Products.this).category_product(category_id);

        }


//        int[] imgCategory ={R.drawable.img1,R.drawable.img2, R.drawable.img1,
//                R.drawable.img2,R.drawable.img1,R.drawable.img2,R.drawable.img1,R.drawable.img2,R.drawable.img1,
//                R.drawable.img2,R.drawable.img1,R.drawable.img2};
//
//        String[] txttitle ={"Fresh Skin", "Crest", "Fresh Skin", "Crest", "Fresh Skin","Crest",
//                "Fresh Skin","Crest","Fresh Skin", "Crest", "Fresh Skin", "Crest"};
//
//        String[] txtdiscription ={"Description", "Description", "Description", "Description", "Description","Description",
//                "Description","Description","Description", "Description", "Description", "Description"};
//
//        String[] txtprice ={"55", "60", "40", "70", "80","100",
//                "50","85","58", "60", "33", "190"};
//
//        String[] txtpricediscount ={"45", "0", "0", "40", "0","50",
//                "0","0","0", "30", "0", "100"};
//
//        String[] txtpricepercentage ={"10", "0", "0", "25", "0","50",
//                "0","0","0", "50", "0", "40"};
//
//        for (int i = 0; i<imgCategory.length; i++)
//        {
//            Products_model model = new Products_model(imgCategory[i],txttitle[i],txtdiscription[i],txtprice[i],txtpricediscount[i],txtpricepercentage[i]);
//            productsModelList.add(model);
//        }


//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList,this);
//        recyclerView.setAdapter(adabter);


    }


    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();

    }

    @Override
    public void onStop() {
        super.onStop();
        shimmerFrameLayout.stopShimmer();

    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        if (Fragment_Category.x == 1) {
            Fragment_Category.x = 0;

            Gson gson = new Gson();

            ModelAllProduct allProducts = gson.fromJson(String.valueOf(model.getJsonObject()), ModelAllProduct.class);
            selectedItems = allProducts.getSelectedItems();

            for (int i = 0; i < selectedItems.length; i++) {

                ModelAllSelectedItem selectedItem = new ModelAllSelectedItem();

                selectedItem.setDescription(selectedItems[i].getDescription());
                selectedItem.setId(selectedItems[i].getId());
                selectedItem.setImage(selectedItems[i].getImage());
                selectedItem.setPrice(selectedItems[i].getPrice());
                selectedItem.setQtyStock(selectedItems[i].getQtyStock());
                selectedItem.setTitle(selectedItems[i].getTitle());
                selectedItem.setPriceAfterDiscount(selectedItems[i].getPriceAfterDiscount());

                selectedItemList.add(selectedItem);

            }
            if (selectedItemList.size() == 0) {

                txtNoItem.setVisibility(View.VISIBLE);

            } else {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                RcyProductsSelectedAdapter adabter = new RcyProductsSelectedAdapter(selectedItemList, this);
                recyclerView.setAdapter(adabter);
            }


        } else {
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

                txtNoItem.setVisibility(View.VISIBLE);

            } else {
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList, this);
                recyclerView.setAdapter(adabter);
            }
        }


    }

    @Override
    public void OnError(VolleyError error) {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
