package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;

public class Activation_Code extends AppCompatActivity {
    Button btnavtivition;
    TextView txtresend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation_code);
        btnavtivition = findViewById(R.id.btnActivationContinue);
        txtresend = findViewById(R.id.txtResendIt);
        txtresend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resend_Popup resend_popup = new Resend_Popup();
                resend_popup.dialog(Activation_Code.this,R.layout.resend_popup,.90);

            }
        });

        btnavtivition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Activation_Code.this, MainActivity.class));
                finish();

            }
        });
    }
}
