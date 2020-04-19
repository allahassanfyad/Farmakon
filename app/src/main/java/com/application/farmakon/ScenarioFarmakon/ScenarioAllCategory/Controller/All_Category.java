package com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Pattrens.RcyAllCategoryAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyCategoryGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class All_Category extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Category_Model> categoryModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);



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


        recyclerView = findViewById(R.id.rcyAllCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(All_Category.this,3));
        RcyAllCategoryAdapter adabter = new RcyAllCategoryAdapter(categoryModelList,this);
        recyclerView.setAdapter(adabter);

    }
}
