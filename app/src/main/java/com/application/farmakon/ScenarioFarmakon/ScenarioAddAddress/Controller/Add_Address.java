package com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.application.farmakon.R;

public class Add_Address extends AppCompatActivity {

    EditText editaddress,editaddressname,editbuldingno,editfloorno,editapartmentno,editaddressnotes;
    Button btnsaveplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);


        editaddress = findViewById(R.id.editAddress);
        editaddressname = findViewById(R.id.editAddressName);
        editbuldingno = findViewById(R.id.editBuldingNo);
        editfloorno = findViewById(R.id.editFloorNo);
        editapartmentno = findViewById(R.id.editApartmentNo);
        editaddressnotes = findViewById(R.id.editAddressNotes);

        btnsaveplace = findViewById(R.id.btnSaveAddress);




    }
}
