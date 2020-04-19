package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model.Previous_Order_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Pattrens.RcyPreviousOrdersAdapter;

import java.util.ArrayList;
import java.util.List;

public class Previous_Orders extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Previous_Order_Model> previousOrderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_orders);

        recyclerView = findViewById(R.id.rcyPreviousOrders);

        String[] txtPrice ={"500", "300", "2000", "2503", "4486","2262",
                "400","22","450", "356", "4869", "225"};

        String[] txtDate ={"30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020","30/3/2020",
                "30/3/2020","30/3/2020","30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020"};

        for (int i = 0; i<txtPrice.length; i++)
        {
            Previous_Order_Model model = new Previous_Order_Model(txtPrice[i],txtDate[i]);
            previousOrderList.add(model);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RcyPreviousOrdersAdapter adabter = new RcyPreviousOrdersAdapter(previousOrderList,this);
        recyclerView.setAdapter(adabter);

    }
}
