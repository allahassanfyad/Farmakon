package com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddAddress.Controller.Add_Address;
import com.application.farmakon.Utils.TinyDB;

public class Add_Address_Popup {

    Context context;
    TinyDB tinyDB;
    public static Dialog dialog ;
    Button btnlocate,btnsetmanually;


    public void dialog(final Context context, int resource, double widthh) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(resource);
        tinyDB = new TinyDB(context);

        btnlocate = dialog.findViewById(R.id.btnLocate);
        btnsetmanually = dialog.findViewById(R.id.btnSetManually);

        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * widthh);
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width, height);
        WindowManager.LayoutParams wlp = dialog.getWindow().getAttributes();
        wlp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(wlp);


        btnsetmanually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(new Intent(context, Add_Address.class));

            }
        });



        dialog.show();



    }

}
