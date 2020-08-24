package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAllCategory.Controller.All_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelCategory;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelHome;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelPartnerCategory;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelPartnerDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelSelectedItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.ModelSlide;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.SliderItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyBestSellingItemsAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyCategoryGridAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcyPartnerGridAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.RcySelectedItemsAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Pattrens.SliderAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Pattrens.IFOnBackPressed;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller.Products;
import com.application.farmakon.Utils.TinyDB;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Category extends Fragment implements NetworkInterface, IFOnBackPressed {

    private View view;
    private ShimmerRecyclerView recyclerView1, recyclerView2, rcyBrands, rcyBestSelling;


    SliderView sliderView;
    private SliderAdapter adapter;
    TextView txtseeallcategory, txtseeallselection;
    LinearLayout loading;
    ModelCategory category[];
    ModelSelectedItem selectedItem[];
    ModelSlide slide[];
    ModelPartnerDatum[] partnerData;
    private List<ModelCategory> categoryList = new ArrayList<>();
    private List<ModelSelectedItem> selectedItemList = new ArrayList<>();
    private List<ModelSlide> sliderItemList = new ArrayList<>();
    private List<ModelPartnerDatum> partnerList = new ArrayList<>();
    TinyDB tinyDB;
    public static int x = 0;
    int z = 0;
    private ShimmerFrameLayout shimmerFrameLayout1, shimmerFrameLayout2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_fragment, container, false);

        tinyDB = new TinyDB(getContext());

        MainActivity.lineartoolbar.setVisibility(View.VISIBLE);
        sliderView = view.findViewById(R.id.imageSlider);
        txtseeallcategory = view.findViewById(R.id.txtSeeAllCategory);
        txtseeallselection = view.findViewById(R.id.txtSeeAllSelection);
//        loading = view.findViewById(R.id.loading);
        recyclerView1 = view.findViewById(R.id.rcyCategory);
        recyclerView2 = view.findViewById(R.id.rcySelection);
        rcyBrands = view.findViewById(R.id.rcyBrands);
        rcyBestSelling = view.findViewById(R.id.rcyBestSelling);
//        shimmerFrameLayout1 = view.findViewById(R.id.loading_Shimmer1);
//        shimmerFrameLayout2 = view.findViewById(R.id.loading_Shimmer2);


        txtseeallcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), All_Category.class));

            }
        });

        txtseeallselection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = 1;
                startActivity(new Intent(getContext(), Products.class));


            }
        });


        z = 1;
        new Apicalls(getActivity(), Fragment_Category.this).get_home();


        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

        if (z == 1) {


            recyclerView2.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.VISIBLE);

            if (model.getJsonObject().toString() != null) {
                Gson gson = new Gson();
                ModelHome home = gson.fromJson(String.valueOf(model.getJsonObject()), ModelHome.class);

                category = home.getCategories();
                selectedItem = home.getSelectedItems();
                slide = home.getSlides();

                if (home.getCategories() != null || category.length == 0) {

                    for (int i = 0; i < category.length; i++) {

                        ModelCategory categories = new ModelCategory();

                        categories.setId(category[i].getId());
                        categories.setImage(category[i].getImage());
                        categories.setTitle(category[i].getTitle());

                        categoryList.add(categories);
                    }


                    recyclerView1.setHasFixedSize(true);
                    recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
                    RcyCategoryGridAdapter adabter = new RcyCategoryGridAdapter(categoryList, getContext());
                    recyclerView1.setAdapter(adabter);

                }

                if (home.getSelectedItems() != null || selectedItem.length == 0) {

                    for (int s = 0; s < selectedItem.length; s++) {

                        ModelSelectedItem selected = new ModelSelectedItem();

                        selected.setDescription(selectedItem[s].getDescription());
                        selected.setId(selectedItem[s].getId());
                        selected.setImage(selectedItem[s].getImage());
                        selected.setQtyStock(selectedItem[s].getQtyStock());
                        selected.setPrice(selectedItem[s].getPrice());
                        selected.setTitle(selectedItem[s].getTitle());

                        selectedItemList.add(selected);

                    }

                    recyclerView2.setHasFixedSize(true);
                    recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
                    RcySelectedItemsAdapter adabter1 = new RcySelectedItemsAdapter(selectedItemList, getContext());
                    recyclerView2.setAdapter(adabter1);

                    rcyBestSelling.setHasFixedSize(true);
                    rcyBestSelling.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
                    RcyBestSellingItemsAdapter adabter2 = new RcyBestSellingItemsAdapter(selectedItemList, getContext());
                    rcyBestSelling.setAdapter(adabter2);

                }

                if (home.getSlides() != null || slide.length == 0) {

                    for (int i = 0; i < slide.length; i++) {

                        ModelSlide slides = new ModelSlide();

                        slides.setId(slide[i].getId());
                        slides.setImageUrl(slide[i].getImageUrl());

                        sliderItemList.add(slides);
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
                }

            }

            z = 2;
            new Apicalls(getContext(), Fragment_Category.this).get_partner();

        } else if (z == 2) {

            if (model.getJsonObject().toString() != null) {
                Gson gson = new Gson();
                ModelPartnerCategory partnerCategory = gson.fromJson(String.valueOf(model.getJsonObject()), ModelPartnerCategory.class);
                partnerData = partnerCategory.getData();


                if (partnerCategory.getData() != null || partnerData.length == 0) {

                    for (int i = 0; i < partnerData.length; i++) {

                        ModelPartnerDatum partnerDatum = new ModelPartnerDatum();

                        partnerDatum.setId(partnerData[i].getId());
                        partnerDatum.setImage(partnerData[i].getImage());
                        partnerDatum.setTitle(partnerData[i].getTitle());

                        partnerList.add(partnerDatum);

                    }

                    rcyBrands.setHasFixedSize(true);
                    rcyBrands.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
                    RcyPartnerGridAdapter adabter1 = new RcyPartnerGridAdapter(partnerList, getContext());
                    rcyBrands.setAdapter(adabter1);

                }

            }


        }

    }

    @Override
    public void OnError(VolleyError error) {
//        shimmerFrameLayout1.stopShimmer();
//        shimmerFrameLayout1.setVisibility(View.GONE);
        recyclerView1.setVisibility(View.VISIBLE);

//        shimmerFrameLayout2.stopShimmer();
//        shimmerFrameLayout2.setVisibility(View.GONE);
        recyclerView2.setVisibility(View.VISIBLE);

        Log.e("error_home_category", "" + error.getMessage().toString());

    }

    @Override
    public boolean onBackPressed() {

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(a);
        getActivity().finish();
        return true;

    }
}
