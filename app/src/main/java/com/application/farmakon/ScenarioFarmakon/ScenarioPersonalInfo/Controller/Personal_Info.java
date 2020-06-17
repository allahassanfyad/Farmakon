package com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model.ModelPersonalDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model.ModelPersonalInfo;
import com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model.ModelUpdatePersonalInfo;
import com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Model.ModelUpdatePersonalUserInfo;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllProduct;
import com.google.gson.Gson;

import es.dmoral.toasty.Toasty;

public class Personal_Info extends AppCompatActivity implements NetworkInterface {

    EditText editname, editemail, edityear, editmonth, editday;
    CheckBox checkBoxmale, checkBoxfemale;
    Button btncontinue;
    int personalcall = 0;
    int x = 0;

    String gender, language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        editday = findViewById(R.id.editPersonalDay);
        editemail = findViewById(R.id.editPersonalEmail);
        editmonth = findViewById(R.id.editPersonalMonth);
        editname = findViewById(R.id.editPersonalName);
        edityear = findViewById(R.id.editPersonalYear);
        btncontinue = findViewById(R.id.btnContinue);

        checkBoxfemale = findViewById(R.id.checkPersonalFemale);
        checkBoxmale = findViewById(R.id.checkPersonalMale);

        checkBoxmale.setChecked(false);
        checkBoxfemale.setChecked(false);

        MainActivity.loading.setVisibility(View.VISIBLE);
        personalcall = 1;
        new Apicalls(Personal_Info.this, Personal_Info.this).get_personal_info();

        OnclickMethod();

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editname.getText().toString() == null || editname.getText().toString().equals("") || editemail.getText().toString() == null || editemail.getText().toString().equals("") || editday.getText().toString() == null || editday.getText().toString().equals("") || edityear.getText().toString() == null || edityear.getText().toString().equals("") || editmonth.getText().toString() == null || editmonth.getText().toString().equals("") || x == 0) {

                    Toasty.error(Personal_Info.this, "Please Complete Your Personal Information", Toast.LENGTH_LONG).show();


                } else {

                    String dof = edityear.getText().toString() + "-" + editmonth.getText().toString() + "-" + editday.getText().toString();

                    if (x == 1) {

                        gender = "1";

                    } else if (x == 2) {

                        gender = "2";
                    }

                    MainActivity.loading.setVisibility(View.VISIBLE);
                    personalcall = 2;

                    Log.e("personal_update",""+editemail.getText().toString()+" "+ editname.getText().toString()+" "+  gender+" "+  dof+" "+  language);
                    new Apicalls(Personal_Info.this, Personal_Info.this).update_personal_info(editemail.getText().toString(), editname.getText().toString(), gender, dof, language);


                }


            }
        });


    }


    public void OnclickMethod() {

        checkBoxmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = 1;
                checkBoxmale.setChecked(true);
                checkBoxfemale.setChecked(false);
            }
        });
        checkBoxfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = 2;
                checkBoxmale.setChecked(false);
                checkBoxfemale.setChecked(true);

            }
        });

    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        MainActivity.loading.setVisibility(View.GONE);

        if (personalcall == 1) {

            Gson gson = new Gson();
            ModelPersonalInfo personalInfo = gson.fromJson(String.valueOf(model.getJsonObject()), ModelPersonalInfo.class);
            ModelPersonalDatum datum = personalInfo.getData();

            if (datum.getEmail() == null || datum.getDob() == null || datum.getName() == null || datum.getGender() == null) {

                Toasty.error(this, "there is no enough data please inter your Information", Toast.LENGTH_LONG).show();
                language = datum.getLang();

            } else {

                editname.setText(datum.getName());
                editemail.setText(datum.getEmail());
                String insertDate = datum.getDob();
                String[] items1 = insertDate.split("-");
                String y1 = items1[0];
                String m1 = items1[1];
                String d1 = items1[2];
                int year = Integer.parseInt(y1);
                int month = Integer.parseInt(m1);
                String day = String.valueOf(d1);

                editday.setText("" + day);
                edityear.setText("" + year);
                editmonth.setText("" + month);

                if (datum.getGender().equals("1")) {

                    checkBoxmale.setChecked(true);
                    checkBoxfemale.setChecked(false);

                } else if (datum.getGender().equals("2")) {

                    checkBoxmale.setChecked(true);
                    checkBoxfemale.setChecked(false);

                }


            }


        } else if (personalcall == 2) {


            Gson gson = new Gson();
            ModelUpdatePersonalInfo updatePersonalInfo = gson.fromJson(String.valueOf(model.getJsonObject()), ModelUpdatePersonalInfo.class);
            ModelUpdatePersonalUserInfo updatePersonalUserInfo = updatePersonalInfo.getUserInfo();
            Toasty.success(this, "Your Profile Updated Successfully", Toast.LENGTH_LONG).show();

            Product_Details.opencart = 0;
            startActivity(new Intent(Personal_Info.this, MainActivity.class));
            finish();


        }

    }

    @Override
    public void OnError(VolleyError error) {
        MainActivity.loading.setVisibility(View.GONE);

    }

    @Override
    public void onBackPressed() {

        Product_Details.opencart = 0;
        startActivity(new Intent(Personal_Info.this, MainActivity.class));
        finish();
    }
}
