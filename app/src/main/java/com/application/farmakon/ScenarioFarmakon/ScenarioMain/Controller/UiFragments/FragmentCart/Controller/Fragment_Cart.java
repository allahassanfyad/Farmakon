package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller.Address;
import com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Controller.checkout;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Photo_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.RcyCartPhotoAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.RcyCartProductAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Photo_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Product_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Pattrens.IFOnBackPressed;
import com.application.farmakon.Utils.TinyDB;

import java.util.ArrayList;
import java.util.Objects;

import io.realm.Realm;

public class Fragment_Cart extends Fragment  implements IFOnBackPressed {


    private View view;
    private Realm realm;
    private Realm_Cart_Product_adapter adapter_product;
    private Realm_Cart_Photo_adapter adapter_photo;

    private ArrayList<Realm_Cart_Photo_Model> cart_photo_models = new ArrayList<>();
    private ArrayList<Realm_Cart_Product_Model> cart_product_models = new ArrayList<>();


    TinyDB tinyDB;
    TextView txtCartPhotoCount,txtCartItemCount,txtNoItem;
    EditText editNotes;
    Button btnProceed;
    LinearLayout linearCart;
    RecyclerView recyclerView_product,recyclerView_photo;
    int cart_item_product_count = 0;
    int cart_item_photo_count = 0;
    int cart_item_count_total = 0;
    public static int address = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.cart_fragment, container, false);
        Realm.init(getActivity());
        MainActivity.lineartoolbar.setVisibility(View.VISIBLE);
        tinyDB = new TinyDB(getContext());


        adapter_product = new Realm_Cart_Product_adapter(realm);
        adapter_photo = new Realm_Cart_Photo_adapter(realm);

        cart_photo_models = adapter_photo.retrieve();
        cart_product_models = adapter_product.retrieve();

        txtCartItemCount = view.findViewById(R.id.txtCartItemCount);
        txtCartPhotoCount = view.findViewById(R.id.txtCartPhotoCount);
        editNotes = view.findViewById(R.id.editCartNotes);
        btnProceed = view.findViewById(R.id.btnProceed);
        linearCart = view.findViewById(R.id.linearCart);
        txtNoItem = view.findViewById(R.id.txtNoItem);
        recyclerView_photo = view.findViewById(R.id.rcyCartPhoto);
        recyclerView_product = view.findViewById(R.id.rcyCartProduct);


        linearCart.setVisibility(View.VISIBLE);
        txtNoItem.setVisibility(View.GONE);

        if (cart_photo_models.size() == 0){

            txtCartPhotoCount.setText("0");

        }else {

            txtCartPhotoCount.setText(""+cart_photo_models.size());

            cart_item_photo_count = cart_photo_models.size();

            recyclerView_photo.setHasFixedSize(true);
            recyclerView_photo.setLayoutManager(new LinearLayoutManager(getActivity()));
            RcyCartPhotoAdapter adabter = new RcyCartPhotoAdapter(cart_photo_models, getContext());
            recyclerView_photo.setAdapter(adabter);

        }

        if (cart_product_models.size() == 0){

            cart_item_product_count = cart_product_models.size();

        }else {

            cart_item_product_count = cart_product_models.size();

            recyclerView_product.setHasFixedSize(true);
            recyclerView_product.setLayoutManager(new LinearLayoutManager(getActivity()));
            RcyCartProductAdapter adabter = new RcyCartProductAdapter(cart_product_models, getContext());
            recyclerView_product.setAdapter(adabter);


        }

        cart_item_count_total = cart_item_photo_count + cart_item_product_count ;

//        Toast.makeText(getContext(), "cart count"+cart_item_count_total, Toast.LENGTH_SHORT).show();

        txtCartItemCount.setText(""+cart_item_count_total);

        if (cart_product_models.size() == 0 && cart_photo_models.size() == 0){

            linearCart.setVisibility(View.GONE);
            txtNoItem.setVisibility(View.VISIBLE);

        }


        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tinyDB.putString("Photo_Count", txtCartPhotoCount.getText().toString());
                tinyDB.putString("item_Count", txtCartItemCount.getText().toString());
                tinyDB.putString("Notes", editNotes.getText().toString());

                address = 1;
                startActivity(new Intent(getContext(), Address.class));
                Objects.requireNonNull(getActivity()).finish();



            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

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
