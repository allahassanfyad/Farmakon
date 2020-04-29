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

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.Address_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.ModelGetAddressDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Model.ModelGetAddressUser;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Pattrens.RcySavedPlacesAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller.Activation_Code;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller.Resend_Popup;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller.Fragment_Cart;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Address extends AppCompatActivity implements NetworkInterface {

    Button btnaddaddress, btnaddnewplaces;
    ImageView imggotocart;
    LinearLayout linearnoaddress, linearaddress;
    RecyclerView recyclerView;
    LinearLayout loading;
    ModelGetAddressDatum[] addressData;

    private List<ModelGetAddressDatum> addressList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        loading = findViewById(R.id.loading);
        btnaddaddress = findViewById(R.id.btnAddAddress);
        btnaddnewplaces = findViewById(R.id.btnAdddNewPlaces);
        imggotocart = findViewById(R.id.imgGoToCart);
        linearaddress = findViewById(R.id.linearAddress);
        linearnoaddress = findViewById(R.id.linearNoAddress);
        recyclerView = findViewById(R.id.rcyAddress);

        linearnoaddress.setVisibility(View.GONE);
        linearaddress.setVisibility(View.GONE);
//        String[] txtaddress ={"Home", "Work", "Place1", "Place2", "Place3"};
//
//        for (int i = 0; i<txtaddress.length; i++)
//        {
//            Address_Model model = new Address_Model(txtaddress[i]);
//            addressList.add(model);
//        }


        loading.setVisibility(View.VISIBLE);
        new Apicalls(Address.this, Address.this).get_user_address();


        btnaddnewplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Add_Address_Popup add_address_popup = new Add_Address_Popup();
                add_address_popup.dialog(Address.this, R.layout.add_address_popup, .90);

            }
        });


        btnaddaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Address_Popup add_address_popup = new Add_Address_Popup();
                add_address_popup.dialog(Address.this, R.layout.add_address_popup, .90);

            }
        });


        imggotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Product_Details.opencart = 1;
                startActivity(new Intent(Address.this, MainActivity.class));

            }
        });

    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        loading.setVisibility(View.GONE);

        Gson gson = new Gson();

        ModelGetAddressUser addressUser = gson.fromJson(String.valueOf(model.getJsonObject()), ModelGetAddressUser.class);
        addressData = addressUser.getData();

        for (int i = 0; i < addressData.length; i++) {

            ModelGetAddressDatum datum = new ModelGetAddressDatum();

            datum.setAddressName(addressData[i].getAddressName());
            datum.setFullAddress(addressData[i].getFullAddress());
            datum.setBuildNo(addressData[i].getBuildNo());
            datum.setFloorNo(addressData[i].getFloorNo());
            datum.setApartmentNo(addressData[i].getApartmentNo());
            datum.setLatitude(addressData[i].getLatitude());
            datum.setLongitude(addressData[i].getLongitude());
            datum.setNotes(addressData[i].getNotes());
            datum.setId(addressData[i].getId());

            addressList.add(datum);
        }

        if (addressList.size() == 0 || addressList == null) {

            linearnoaddress.setVisibility(View.VISIBLE);
            linearaddress.setVisibility(View.GONE);

        } else {

            linearnoaddress.setVisibility(View.GONE);
            linearaddress.setVisibility(View.VISIBLE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RcySavedPlacesAdapter adabter = new RcySavedPlacesAdapter(addressList, Address.this);
            recyclerView.setAdapter(adabter);

        }


    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed() {
        if (Fragment_Cart.address == 1) {

            Product_Details.opencart = 1;
            startActivity(new Intent(Address.this, MainActivity.class));


        } else {

            startActivity(new Intent(Address.this, MainActivity.class));

        }
    }

}
