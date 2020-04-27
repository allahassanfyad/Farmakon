package com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Model.ModelAllCategory;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Model.ModelDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Pattrens.RcyAllCategoryAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyCategoryGridAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class All_Category extends AppCompatActivity implements NetworkInterface {

    private RecyclerView recyclerView;
    private List<Category_Model> categoryModelList = new ArrayList<>();
    LinearLayout loading;
    ModelDatum[] modelData;

    ArrayList<ModelDatum> dataList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        recyclerView = findViewById(R.id.rcyAllCategory);
        loading = findViewById(R.id.loading);


        loading.setVisibility(View.VISIBLE);
        new Apicalls(All_Category.this,All_Category.this).get_all_category();





        int[] imgCategory ={R.drawable.img,R.drawable.img, R.drawable.img,
                R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,R.drawable.img,
                R.drawable.img,R.drawable.img,R.drawable.img};

        String[] txtCategory ={"medication", "medication", "medication", "medication", "medication","medication",
                "medication","medication","medication", "medication", "medication", "medication"};

        for (int i = 0; i<imgCategory.length; i++)
        {
            Category_Model model = new Category_Model(txtCategory[i],imgCategory[i]);
            categoryModelList.add(model);
        }





    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        loading.setVisibility(View.GONE);

        Gson gson = new Gson();
        ModelAllCategory allCategory = gson.fromJson(String.valueOf(model.getJsonObject()),ModelAllCategory.class);

        modelData = allCategory.getData();

        for (int i = 0; i<modelData.length; i++){

            ModelDatum datum = new ModelDatum();

            datum.setId(modelData[i].getId());
            datum.setImage(modelData[i].getImage());
            datum.setTitle(modelData[i].getTitle());

            dataList.add(datum);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(All_Category.this,3));
        RcyAllCategoryAdapter adabter = new RcyAllCategoryAdapter(dataList,this);
        recyclerView.setAdapter(adabter);

    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);
        Log.e("allCategory_erroro",""+error.getLocalizedMessage().toString());

    }
}
