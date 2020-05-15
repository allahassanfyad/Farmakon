package com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Model.FAQ_Group1_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Model.ModelFAQDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Model.ModelFAQQuestion;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Pattrens.FAQ_Group1_Adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelCategoryDatum;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FAQ extends AppCompatActivity implements NetworkInterface {


    RecyclerView recyclerView;
    List<ModelFAQDatum> faqGroup1ModelList = new ArrayList<>();
    LinearLayout loading;
    ModelFAQDatum[] faqdata;
    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        loading = findViewById(R.id.loading);
        recyclerView = findViewById(R.id.rcyFaqGroup);

//        String question[] ={"What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications"};
//        String answer[] ={"Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev"};
//
//
//        for (int i = 0; i<question.length; i++)
//        {
//            FAQ_Group1_Model faq_group1_model = new FAQ_Group1_Model(question[i],answer[i]);
//            faqGroup1ModelList.add(faq_group1_model);
//
//        }

        shimmerFrameLayout = findViewById(R.id.loading_Shimmer);


        new Apicalls(FAQ.this,FAQ.this).faq();





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

        Gson gson = new Gson();
        ModelFAQQuestion faqQuestion = gson.fromJson(String.valueOf(model.getJsonObject()),ModelFAQQuestion.class);
        faqdata = faqQuestion.getData();

        for (int i =0; i<faqdata.length; i++){

            ModelFAQDatum datum = new ModelFAQDatum();

            datum.setAnswer(faqdata[i].getAnswer());
            datum.setId(faqdata[i].getId());
            datum.setQuestion(faqdata[i].getQuestion());

            faqGroup1ModelList.add(datum);

        }

        //Group1
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FAQ_Group1_Adapter(recyclerView,faqGroup1ModelList));

    }

    @Override
    public void OnError(VolleyError error) {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        Log.e("FAQ_error",""+error.toString());

    }
}
