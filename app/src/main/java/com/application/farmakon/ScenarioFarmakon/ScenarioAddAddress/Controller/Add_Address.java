package com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Model.ModelAddressUser;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller.Address;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.Gson;

import es.dmoral.toasty.Toasty;

public class Add_Address extends AppCompatActivity implements NetworkInterface {

    EditText editaddress,editaddressname,editbuldingno,editfloorno,editapartmentno,editaddressnotes;
    Button btnsaveplace;
    LinearLayout loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);


        loading = findViewById(R.id.loading);
        editaddress = findViewById(R.id.editAddress);
        editaddressname = findViewById(R.id.editAddressName);
        editbuldingno = findViewById(R.id.editBuldingNo);
        editfloorno = findViewById(R.id.editFloorNo);
        editapartmentno = findViewById(R.id.editApartmentNo);
        editaddressnotes = findViewById(R.id.editAddressNotes);
        btnsaveplace = findViewById(R.id.btnSaveAddress);


        btnsaveplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editaddress.getText().toString().equals("")){

                    editaddress.setError("Please Enter Your Address");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editAddress));


                }else if (editaddressname.getText().toString().equals("")){


                    editaddressname.setError("Please Enter Your Address Name");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editAddressName));


                }else if (editbuldingno.getText().toString().equals("")){

                    editbuldingno.setError("Please Enter Your Address Building Number");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editBuldingNo));


                }else if (editfloorno.getText().toString().equals("")){

                    editfloorno.setError("Please Enter Your Address Floor Number");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editFloorNo));


                }else if (editapartmentno.getText().toString().equals("")){

                    editapartmentno.setError("Please Enter Your Address Apartment Number");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editApartmentNo));


                }else if (editaddressnotes.getText().toString().equals("")){


                    editapartmentno.setError("Please Enter Your Address Notes");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editAddressNotes));

                }else {

                    loading.setVisibility(View.VISIBLE);
                    new Apicalls(Add_Address.this,Add_Address.this).add_address(editaddressname.getText().toString(),editaddress.getText().toString(),editbuldingno.getText().toString(),editfloorno.getText().toString(),editapartmentno.getText().toString(),editaddressnotes.getText().toString());


                }


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

        ModelAddressUser addressUser = gson.fromJson(String.valueOf(model.getJsonObject()),ModelAddressUser.class);

        Toasty.success(Add_Address.this, ""+addressUser.getMessage(), Toast.LENGTH_LONG).show();

        startActivity(new Intent(Add_Address.this, Address.class));
        finish();

    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);
        Log.e("Add_address_error",""+error.toString());


    }
}
