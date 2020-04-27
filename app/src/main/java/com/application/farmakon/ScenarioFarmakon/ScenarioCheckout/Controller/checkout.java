package com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.application.farmakon.R;

public class checkout extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner;
    TextView txtdeliverytime,txtaddress,txtnumber,txtphotocount,txtitemcount,txtexpecteddeliverytime,txttotal,txtnototal;
    Button btnplaceorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        spinner1 = findViewById(R.id.spinPaymentMethod);
        spinner = new Spinner(this);

        txtdeliverytime = findViewById(R.id.txtDeliveryTime);
        txtaddress = findViewById(R.id.txtCheckoutAddress);
        txtnumber = findViewById(R.id.txtCheckoutPhone);
        txtphotocount = findViewById(R.id.txtCheckoutPhotoCount);
        txtitemcount = findViewById(R.id.txtCheckoutItemCount);
        txtexpecteddeliverytime = findViewById(R.id.txtExpectedDeliveryTime);
        txttotal = findViewById(R.id.txtCheckoutTotal);
        txtnototal = findViewById(R.id.txtCheckoutNoTotal);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.payment_method,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
