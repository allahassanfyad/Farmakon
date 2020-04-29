package com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model.ModelMyOrder;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model.ModelMyPreviousOrders;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Model.Previous_Order_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Pattrens.RcyPreviousOrdersAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Previous_Orders extends AppCompatActivity implements NetworkInterface {
    RecyclerView recyclerView;
    private List<ModelMyOrder> myOrderList = new ArrayList<>();
    ModelMyOrder[] modelMyOrders;
    LinearLayout loading;
    TextView txtnodata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_orders);

        recyclerView = findViewById(R.id.rcyPreviousOrders);
        loading = findViewById(R.id.loading);
        txtnodata = findViewById(R.id.txtNoItem);

//        String[] txtPrice = {"500", "300", "2000", "2503", "4486", "2262",
//                "400", "22", "450", "356", "4869", "225"};
//
//        String[] txtDate = {"30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020",
//                "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020", "30/3/2020"};
//
//        for (int i = 0; i < txtPrice.length; i++) {
//            Previous_Order_Model model = new Previous_Order_Model(txtPrice[i], txtDate[i]);
//            myOrderList.add(model);
//        }
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        RcyPreviousOrdersAdapter adabter = new RcyPreviousOrdersAdapter(myOrderList, this);
//        recyclerView.setAdapter(adabter);

        loading.setVisibility(View.VISIBLE);
        new Apicalls(Previous_Orders.this, Previous_Orders.this).get_my_Orders();


    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        loading.setVisibility(View.GONE);
        Gson gson = new Gson();

        if (model.getJsonObject() != null) {

            ModelMyPreviousOrders myPreviousOrders = gson.fromJson(String.valueOf(model.getJsonObject()), ModelMyPreviousOrders.class);
            modelMyOrders = myPreviousOrders.getOrders();

            for (int i = 0; i < modelMyOrders.length; i++) {

                ModelMyOrder myOrder = new ModelMyOrder();

                myOrder.setCode(modelMyOrders[i].getCode());
                myOrder.setDate(modelMyOrders[i].getDate());
                myOrder.setId(modelMyOrders[i].getId());

                if (modelMyOrders[i].getTotal() == null) {

                    myOrder.setTotal("0");

                } else {
                    myOrder.setCode(modelMyOrders[i].getCode());
                }

                myOrderList.add(myOrder);
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RcyPreviousOrdersAdapter adabter = new RcyPreviousOrdersAdapter(myOrderList, this);
            recyclerView.setAdapter(adabter);

        } else {

            txtnodata.setVisibility(View.GONE);

        }


    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

    }
}
