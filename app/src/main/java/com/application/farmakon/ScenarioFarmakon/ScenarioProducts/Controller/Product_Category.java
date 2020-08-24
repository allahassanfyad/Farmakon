package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller.Fragment_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllSelectedItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelSubCategory;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelSubDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsSelectedAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcySubcategoryGridAdapter;
import com.application.farmakon.Utils.TinyDB;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Product_Category extends AppCompatActivity implements NetworkInterface {

    public static ShimmerRecyclerView rcyProductCategory, rcySubCategory;
    TinyDB tinyDB;
    ModelSubDatum[] subData;
    int x = 0;
    public static TextView txtNoItem;
    LinearLayout linearSubcategory;
    private List<ModelCategoryDatum> productsModelList = new ArrayList<>();
    ModelCategoryDatum[] productdata;

    TextView txtCategoryName;
    private List<ModelSubDatum> subCategoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);

        tinyDB = new TinyDB(getApplicationContext());

        rcyProductCategory = findViewById(R.id.rcyAllCategory);
        rcySubCategory = findViewById(R.id.rcySubCategory);
        linearSubcategory = findViewById(R.id.linearSubcategory);
        txtNoItem = findViewById(R.id.txtNoItem);
        txtCategoryName = findViewById(R.id.txtCategoryName);

        txtNoItem.setVisibility(View.GONE);



        txtCategoryName.setText(tinyDB.getString("categoryName"));

        String category_id = tinyDB.getString("categoryID");
        x = 1;
        new Apicalls(Product_Category.this, Product_Category.this).get_Sub_Category(category_id);


    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

        if (x == 1) {

            Gson gson = new Gson();
            ModelSubCategory subCategory = gson.fromJson(String.valueOf(model.getJsonObject()), ModelSubCategory.class);
            subData = subCategory.getData();

            for (int i = 0; i < subData.length; i++) {

                ModelSubDatum subDatum = new ModelSubDatum();

                subDatum.setId(subData[i].getId());
                subDatum.setImage(subData[i].getImage());
                subDatum.setTitle(subData[i].getTitle());

                subCategoryList.add(subDatum);

            }

            if (subCategoryList.size() == 0) {

                linearSubcategory.setVisibility(View.GONE);

            } else {

                linearSubcategory.setVisibility(View.VISIBLE);
                rcySubCategory.setHasFixedSize(true);
                rcySubCategory.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
                RcySubcategoryGridAdapter adabter = new RcySubcategoryGridAdapter(subCategoryList, this);
                rcySubCategory.setAdapter(adabter);

                x = 2;
                new Apicalls(Product_Category.this,Product_Category.this).category_product(String.valueOf(subData[0].getId()));
            }


        } else if (x == 2) {

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
                rcyProductCategory.setHasFixedSize(true);
                rcyProductCategory.setLayoutManager(new LinearLayoutManager(this));
                RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList, this);
                rcyProductCategory.setAdapter(adabter);
            }

        }

    }

    @Override
    public void OnError(VolleyError error) {

        Log.e("error", error.toString());
    }

//    public static void subcategoryCall(Context context,String sub_category_id) {
//        new Apicalls(Product_Category.this, Product_Category.this).category_product(sub_category_id);
//
//
//    }


}
