package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.local_data.saved_data;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                if (saved_data.get_user_check(Splash.this) == true) {

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                }else {

                    startActivity(new Intent(getApplicationContext(), Home.class));
                    finish();

                }


            }
        };
        new Timer().schedule(timerTask, 3000);
    }
}

