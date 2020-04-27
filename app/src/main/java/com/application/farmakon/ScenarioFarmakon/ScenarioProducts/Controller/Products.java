package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller.All_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Pattrens.RcyAllCategoryAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.Products_model;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsAdapter;
import com.application.farmakon.Utils.TinyDB;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Products extends AppCompatActivity implements NetworkInterface {

    private RecyclerView recyclerView;
    private List<ModelCategoryDatum> productsModelList = new ArrayList<>();
    ModelCategoryDatum[] productdata;
    LinearLayout loading;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        tinyDB = new TinyDB(getApplicationContext());

        loading = findViewById(R.id.loading);

        recyclerView = findViewById(R.id.rcyAllCategory);

        loading.setVisibility(View.VISIBLE);
        String category_id = tinyDB.getString("categoryID");

        new Apicalls(Products.this,Products.this).category_product(category_id);

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




        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList,this);
        recyclerView.setAdapter(adabter);


    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        loading.setVisibility(View.GONE);

        Gson gson = new Gson();

        ModelCategoryProduct categoryProduct = gson.fromJson(String.valueOf(model.getJsonObject()),ModelCategoryProduct.class);
        productdata = categoryProduct.getData();

        for (int i = 0; i< productdata.length; i++){

            ModelCategoryDatum datum = new ModelCategoryDatum();

            datum.setDescription(productdata[i].getDescription());
            datum.setId(productdata[i].getId());
            datum.setImage(productdata[i].getImage());
            datum.setPrice(productdata[i].getPrice());
            datum.setQtyStock(productdata[i].getQtyStock());
            datum.setTitle(productdata[i].getTitle());

            productsModelList.add(datum);

        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList,this);
        recyclerView.setAdapter(adabter);



    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

    }
}
