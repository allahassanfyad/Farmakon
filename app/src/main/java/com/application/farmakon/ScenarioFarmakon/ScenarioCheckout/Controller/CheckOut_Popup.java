package com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Controller.Add_Address;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.Utils.TinyDB;

public class CheckOut_Popup {

    Context context;
    TinyDB tinyDB;
    public static Dialog dialog ;
    Button btnok;


    public void dialog(final Context context, int resource, double widthh) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(resource);
        dialog.setCanceledOnTouchOutside(false);
        tinyDB = new TinyDB(context);

        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * widthh);
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.getWindow().setLayout(width, height);
        WindowManager.LayoutParams wlp = dialog.getWindow().getAttributes();
        wlp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(wlp);

        btnok = dialog.findViewById(R.id.btnCheckoutOk);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, MainActivity.class));
                dialog.dismiss();
                ((AppCompatActivity)context).finish();


            }
        });


        dialog.show();



    }

}
