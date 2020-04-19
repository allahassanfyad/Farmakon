package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.application.farmakon.R;

public class Home extends AppCompatActivity {

    TextView txtsigninNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtsigninNumber = findViewById(R.id.txtSignInWithNumber);

        txtsigninNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this,SignIn.class));
                finish();
            }
        });
    }
}
