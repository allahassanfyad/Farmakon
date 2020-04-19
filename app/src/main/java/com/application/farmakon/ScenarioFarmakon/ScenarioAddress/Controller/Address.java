package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.Address_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Pattrens.RcySavedPlacesAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller.Activation_Code;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller.Resend_Popup;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller.Fragment_Cart;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;

import java.util.ArrayList;
import java.util.List;

public class Address extends AppCompatActivity {

    Button btnaddaddress, btnaddnewplaces;
    ImageView imggotocart;
    LinearLayout linearnoaddress, linearaddress;
    RecyclerView recyclerView;

    private List<Address_Model> addressList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        btnaddaddress = findViewById(R.id.btnAddAddress);
        btnaddnewplaces = findViewById(R.id.btnAdddNewPlaces);
        imggotocart = findViewById(R.id.imgGoToCart);
        linearaddress = findViewById(R.id.linearAddress);
        linearnoaddress = findViewById(R.id.linearNoAddress);
        recyclerView = findViewById(R.id.rcyAddress);


        String[] txtaddress ={"Home", "Work", "Place1", "Place2", "Place3"};

        for (int i = 0; i<txtaddress.length; i++)
        {
            Address_Model model = new Address_Model(txtaddress[i]);
            addressList.add(model);
        }

        if (addressList.size() == 0|| addressList == null){

            linearnoaddress.setVisibility(View.VISIBLE);
            linearaddress.setVisibility(View.GONE);

        }else {

            linearnoaddress.setVisibility(View.GONE);
            linearaddress.setVisibility(View.VISIBLE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RcySavedPlacesAdapter adabter = new RcySavedPlacesAdapter(addressList,Address.this);
            recyclerView.setAdapter(adabter);

        }




        btnaddnewplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Add_Address_Popup add_address_popup = new Add_Address_Popup();
                add_address_popup.dialog(Address.this,R.layout.add_address_popup,.90);

            }
        });


        btnaddaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Address_Popup add_address_popup = new Add_Address_Popup();
                add_address_popup.dialog(Address.this,R.layout.add_address_popup,.90);

            }
        });


        imggotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Product_Details.opencart =1;
                startActivity(new Intent(Address.this,MainActivity.class));

            }
        });

    }
}
