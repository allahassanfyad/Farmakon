package com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Product_adapter;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;

public class Product_Details extends AppCompatActivity {
    Button btnAddtocart;
    Realm realm;
    public static int opencart = 0;
    TextView txtincreace, txtdecrease, txtnumber, txttitle, txtdescription, txtprice;
    int num = 1;
    ImageView imgcart, imgproductdetails;
    TinyDB tinyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Realm.init(this);

        tinyDB = new TinyDB(getApplicationContext());

        imgproductdetails = findViewById(R.id.imgProductDetails);
        txtincreace = findViewById(R.id.txtProductDetailsIncrease);
        txtdecrease = findViewById(R.id.txtProductDetailsDecrease);
        txtnumber = findViewById(R.id.txtProductDetailsNumber);
        txttitle = findViewById(R.id.txtProductDetailTitle);
        txtdescription = findViewById(R.id.txtProductDetailDescription);
        btnAddtocart = findViewById(R.id.btnAddToCart);
        txtprice = findViewById(R.id.txtProductDetailPrice);
        imgcart = findViewById(R.id.imgCart);
        realm = Realm.getDefaultInstance();

        String price = tinyDB.getString("product_price");
        String image = tinyDB.getString("product_image");
        String description = tinyDB.getString("product_description");
        String title = tinyDB.getString("product_title");


        txtprice.setText(price);
        txtdescription.setText(description);
        txttitle.setText(title);
        Glide.with(Product_Details.this)
                .load(image)
                .placeholder(R.drawable.img)
                .into(imgproductdetails);



        imgcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Product_Details.this, MainActivity.class));
                opencart = 1;


            }
        });

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Realm_Cart_Product_Model c = new Realm_Cart_Product_Model();

                c.setTxttitle(txttitle.getText().toString());
                c.setTxtprice(txtprice.getText().toString());
                c.setTxtnumberchoose(txtnumber.getText().toString());
                c.setProduct_id(tinyDB.getString("product_id"));


                Realm_Cart_Product_adapter adapter = new Realm_Cart_Product_adapter(realm);


                adapter.save(c);

                Toasty.success(Product_Details.this, "Your Product Added Successfully", Toast.LENGTH_LONG).show();


//                FragmentManager manager = getFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transaction.replace(R.id.container,YOUR_FRAGMENT_NAME,YOUR_FRAGMENT_STRING_TAG);
//                transaction.addToBackStack(null);
//                transaction.commit();
//                MainActivity.navigation.setSelectedItemId(R.id.icon_cart);

            }
        });

        txtincreace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int price = Integer.parseInt(songs.getTxtprice());
//                int selectrd = num * price;
//
//                itemeCartHolder.txtprice.setText(""+selectrd);
//                totalPrice1 = Integer.parseInt(price_details[position].getPrice());

                num = Integer.parseInt(txtnumber.getText().toString());
                num++;
                if (num < 100) {
                    txtnumber.setText("" + num);
//                    itemeCartHolder.txtprice.setText("" + num * totalPrice1);

                } else if (num > 100) {
                    num = 100;
                    txtnumber.setText("" + num);
//                    itemeCartHolder.txtprice.setText("" + num * totalPrice1);

                }

            }
        });

        txtdecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = Integer.parseInt(txtnumber.getText().toString());
                num--;
                if (num >= 1) {
                    txtnumber.setText("" + num);
//                    txtprice.setText("" + num * totalPrice1);

                } else if (num <= 0) {
                    num = 1;
                    txtnumber.setText("" + num);
//                    txtprice.setText("" + num * totalPrice1);
                }

            }
        });


    }
}
