package com.application.farmakon.Utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class Utiles {

    Context context;

   /* public utils(Context context) {
        this.context = context;
    }*/

    /**
     * SPLASH SCREEN
     */
      public void splash_screen(final Context context, final Class second_class)
       {
           new Thread(new Runnable() {
               public void run() {
                   try {
                       // sleep during 800ms
                       Thread.sleep(3000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   // start HomeActivity
                   Intent intent=new Intent(context, second_class);
                   context.startActivity(intent);
                   ((AppCompatActivity)context).finish();
               }
           }).start();
       }

    /**
     * Upload Image
     */
     public void upload_image(Context context,int requestCode)
     {
         Intent i = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
         ((AppCompatActivity)context).startActivityForResult(Intent.createChooser(i, "Select Your Photo"),requestCode);
     }

    /**
     * REPLACE FRAGMENT
     */
    public void Replace_Fragment(Fragment fragment, int id, Context context)
    {
        //ADD FRAGMENT TO ACTIVITY
        Fragment home=fragment;
        ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction()
          .replace(id, home ).commit();
    }

    /**
     * convert to byte array
     */
    public Bitmap convertToBitmap(byte[] b){
        return BitmapFactory.decodeByteArray(b, 0, b.length);
    }

}
