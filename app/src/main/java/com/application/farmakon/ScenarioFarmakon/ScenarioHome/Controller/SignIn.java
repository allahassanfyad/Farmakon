package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;

public class SignIn extends AppCompatActivity {

    Button btnsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnsignin = findViewById(R.id.btnSignIn);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignIn.this,Activation_Code.class));
                finish();

            }
        });
    }
}
