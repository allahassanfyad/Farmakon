package com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller.All_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Pattrens.RcyAllCategoryAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.Products_model;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Pattrens.RcyProductsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Products extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Products_model> productsModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


        int[] imgCategory ={R.drawable.img1,R.drawable.img2, R.drawable.img1,
                R.drawable.img2,R.drawable.img1,R.drawable.img2,R.drawable.img1,R.drawable.img2,R.drawable.img1,
                R.drawable.img2,R.drawable.img1,R.drawable.img2};

        String[] txttitle ={"Fresh Skin", "Crest", "Fresh Skin", "Crest", "Fresh Skin","Crest",
                "Fresh Skin","Crest","Fresh Skin", "Crest", "Fresh Skin", "Crest"};

        String[] txtdiscription ={"Description", "Description", "Description", "Description", "Description","Description",
                "Description","Description","Description", "Description", "Description", "Description"};

        String[] txtprice ={"55", "60", "40", "70", "80","100",
                "50","85","58", "60", "33", "190"};

        String[] txtpricediscount ={"45", "0", "0", "40", "0","50",
                "0","0","0", "30", "0", "100"};

        String[] txtpricepercentage ={"10", "0", "0", "25", "0","50",
                "0","0","0", "50", "0", "40"};

        for (int i = 0; i<imgCategory.length; i++)
        {
            Products_model model = new Products_model(imgCategory[i],txttitle[i],txtdiscription[i],txtprice[i],txtpricediscount[i],txtpricepercentage[i]);
            productsModelList.add(model);
        }



        recyclerView = findViewById(R.id.rcyAllCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RcyProductsAdapter adabter = new RcyProductsAdapter(productsModelList,this);
        recyclerView.setAdapter(adabter);


    }
}
