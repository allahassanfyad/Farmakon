package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller.All_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.SliderItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyCategoryGridAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Category extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<Category_Model> categoryModelList = new ArrayList<>();
    List<SliderItem> sliderItemList = new ArrayList<>();
    SliderView sliderView;
    private SliderAdapter adapter;
    TextView txtseeallcategory,txtseeallselection;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.category_fragment, container, false);

        MainActivity.lineartoolbar.setVisibility(View.VISIBLE);
        sliderView = view.findViewById(R.id.imageSlider);
        txtseeallcategory = view.findViewById(R.id.txtSeeAllCategory);
        txtseeallselection = view.findViewById(R.id.txtSeeAllSelection);

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


        recyclerView= view.findViewById(R.id.rcyCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false));
        RcyCategoryGridAdapter adabter = new RcyCategoryGridAdapter(categoryModelList,getContext());
        recyclerView.setAdapter(adabter);

        recyclerView= view.findViewById(R.id.rcySelection);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false));
        RcyCategoryGridAdapter adabter1 = new RcyCategoryGridAdapter(categoryModelList,getContext());
        recyclerView.setAdapter(adabter1);


        int[] imageItemMain ={R.drawable.ads_photo,R.drawable.ads_photo, R.drawable.ads_photo,
                R.drawable.ads_photo,R.drawable.ads_photo};

        for (int i = 0; i<imageItemMain.length; i++)
        {
            SliderItem sliderItem = new SliderItem(imageItemMain[i]);
            sliderItemList.add(sliderItem);
        }
        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.parseColor("#03afc7"));
        sliderView.setIndicatorUnselectedColor(Color.parseColor("#9ac2c2"));
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(false);

        adapter = new SliderAdapter(getContext(), sliderItemList);
        sliderView.setSliderAdapter(adapter);

        txtseeallcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(),All_Category.class));

            }
        });

        txtseeallselection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(),All_Category.class));


            }
        });


        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}
