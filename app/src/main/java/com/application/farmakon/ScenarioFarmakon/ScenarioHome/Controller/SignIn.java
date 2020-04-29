package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Model.ModelLogin;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Model.ModelUserInfo;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.local_data.send_data;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.gson.Gson;

public class SignIn extends AppCompatActivity implements NetworkInterface {

    Button btnsignin;
    EditText editphone, editcountrycode;
    LinearLayout loading;
    String token;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                token = instanceIdResult.getToken();
                // send it to server
                Log.e("Tokent", token);
            }
        });


        btnsignin = findViewById(R.id.btnSignIn);
        editphone = findViewById(R.id.editPhoneNumber);
        loading = findViewById(R.id.loading);
        editcountrycode = findViewById(R.id.editCountryCode);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editphone.getText().toString().equals("")) {

                    editphone.setError("Please Enter Your Phone Number");

                    YoYo.with(Techniques.Shake)
                            .duration(700)
                            .repeat(1)
                            .playOn(findViewById(R.id.editPhoneNumber));


                } else {

                    phone = editcountrycode.getText().toString() + editphone.getText().toString();

                    Log.e("phone", "" + phone);

                    loading.setVisibility(View.VISIBLE);
                    new Apicalls(SignIn.this, SignIn.this).loginUser(phone, "1", token, "123456789");

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
        ModelLogin modelLogin = gson.fromJson(model.getResponse(), ModelLogin.class);

        send_data.token(SignIn.this, modelLogin.getToken());

        ModelUserInfo userInfo = modelLogin.getUserInfo();

        send_data.userId_check(this, true);
        send_data.user_id(SignIn.this, String.valueOf(userInfo.getId()));

        send_data.PHONE_NUMBER(this, userInfo.getPhone());

//        startActivity(new Intent(SignIn.this,Activation_Code.class));
//        finish();

        startActivity(new Intent(SignIn.this, MainActivity.class));
        finish();


    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

        Log.e("error_login", error.toString());

    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        finish();

    }
}
