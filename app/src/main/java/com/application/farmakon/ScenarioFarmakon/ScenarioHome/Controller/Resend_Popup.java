package com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.application.farmakon.R;
import com.application.farmakon.Utils.TinyDB;

public class Resend_Popup {

    Context context;
    TinyDB tinyDB;
    public static Dialog dialog ;


    public void dialog(final Context context, int resource, double widthh) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(resource);
        tinyDB = new TinyDB(context);




        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        int width = (int) (context.getResources().getDisplayMetrics().widthPixels * widthh);
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width, height);


        WindowManager.LayoutParams wlp = dialog.getWindow().getAttributes();

        wlp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(wlp);






        dialog.show();



    }

}
