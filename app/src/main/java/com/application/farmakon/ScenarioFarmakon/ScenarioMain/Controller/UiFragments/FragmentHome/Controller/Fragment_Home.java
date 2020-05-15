package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentHome.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Pattrens.IFOnBackPressed;
import com.application.farmakon.Utils.firebase_storage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Fragment_Home extends Fragment implements IFOnBackPressed {

    private View view;
    Uri selectedImage;
    static Bitmap bitmaps;
    ImageView imgphoto;

    FirebaseStorage storage;
    StorageReference storageReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        MainActivity.lineartoolbar.setVisibility(View.GONE);
        FirebaseApp.initializeApp(getActivity());

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        imgphoto = view.findViewById(R.id.imgHomePhoto);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // In fragment class callback


        if (requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){

            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK){
                Log.e("fafafafaffaffaf","aaaaaaaa");
                selectedImage = result.getUri();
                InputStream imageStream = null;
                try {
                    FileOutputStream fos = null;
                    imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.e("errror",e.toString());
                }
                Bitmap SelectedPhoto = BitmapFactory.decodeStream(imageStream);
                bitmaps = Bitmap.createScaledBitmap(SelectedPhoto, 300, 300, true);

                firebase_storage firebase_storage=new firebase_storage();
                //firebase_storage.uploadImage(selectedImage,getContext(),true);

                firebase_storage.uploadImage(selectedImage,getContext(),true);

                imgphoto.setImageBitmap(bitmaps);


//                //SET IMAGE
//                Add_Photo_Popup addPhotoPopup=new Add_Photo_Popup();
//                addPhotoPopup.set_image(bitmaps,firebase_storage.uploadImage(selectedImage,getContext(),true));

            }
            else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){

                Exception e = result.getError();
                Toast.makeText(getContext(), ""+e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(a);
        getActivity().finish();
        return true;
    }
}
