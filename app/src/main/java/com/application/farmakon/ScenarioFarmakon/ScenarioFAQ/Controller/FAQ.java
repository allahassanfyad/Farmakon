package com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Model.FAQ_Group1_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Pattrens.FAQ_Group1_Adapter;

import java.util.ArrayList;
import java.util.List;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);



        String question[] ={"What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications", "What 3rd-party-applications"};
        String answer[] ={"Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev", "Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev","Tiger Connect integrates with a range of cccv systems across a broad spectrum of vev"};

        List<FAQ_Group1_Model> faqGroup1ModelList = new ArrayList<>();
        for (int i = 0; i<question.length; i++)
        {
            FAQ_Group1_Model faq_group1_model = new FAQ_Group1_Model(question[i],answer[i]);
            faqGroup1ModelList.add(faq_group1_model);

        }
        //Group1
        RecyclerView recyclerView1 = findViewById(R.id.rcyFaqGroup);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(new FAQ_Group1_Adapter(recyclerView1,faqGroup1ModelList));
    }
}
