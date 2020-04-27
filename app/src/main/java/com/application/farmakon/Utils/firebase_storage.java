package com.application.farmakon.Utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Photo_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Photo_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Product_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.application.farmakon.local_data.send_data;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;


public class firebase_storage {

    private String imageURL = "NoLink";
    Realm realm;
    Realm_Cart_Photo_adapter adapter_photo;


    public String uploadImage(Uri customfilepath, final Context context, Boolean isEnglish) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReference();

        final String uploading, done, failed;

        if (isEnglish) {
            uploading = "Uploading...";
            done = "Uploaded Successfully";
            failed = "Uploading Failed";
        } else {
            uploading = "???? ????????";
            done = "?? ????? ?????";
            failed = "???";
        }

        if (customfilepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setTitle(uploading);
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            ref.putFile(customfilepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {

                                @Override
                                public void onSuccess(Uri uri) {

                                    progressDialog.dismiss();

                                    Toast.makeText(context, done, Toast.LENGTH_SHORT).show();

                                    imageURL = uri.toString();

//                                    send_data.SAVE_IMAGE(context, imageURL);
                                    Realm.init(context);
                                    realm = Realm.getDefaultInstance();
                                    adapter_photo = new Realm_Cart_Photo_adapter(realm);


                                    Realm_Cart_Photo_Model c = new Realm_Cart_Photo_Model();

                                    c.setImghome(imageURL);

                                    Log.e("image",imageURL);


                                    adapter_photo.save(c);

                                    Toasty.success(context, "Your Photo Upload Successfully", Toast.LENGTH_LONG).show();


                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(context, failed, Toast.LENGTH_SHORT).show();
                            Log.e("fafafafaffaffaf",""+e);
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }

        return imageURL;
    }
}



