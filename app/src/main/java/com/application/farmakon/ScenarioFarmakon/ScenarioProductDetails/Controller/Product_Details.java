package com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;

public class Product_Details extends AppCompatActivity {
    Button btnAddtocart;
    public static int opencart = 0;
    TextView txtincreace,txtdecrease,txtnumber,txttitle,txtdescription;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        txtincreace = findViewById(R.id.txtProductDetailsIncrease);
        txtdecrease = findViewById(R.id.txtProductDetailsDecrease);
        txtnumber= findViewById(R.id.txtProductDetailsNumber);
        txttitle = findViewById(R.id.txtProductDetailTitle);
        txtdescription = findViewById(R.id.txtProductDetailDescription);
        btnAddtocart = findViewById(R.id.btnAddToCart);

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Product_Details.this, MainActivity.class));
                opencart = 1;

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
                if (num < 30) {
                    txtnumber.setText("" + num);
//                    itemeCartHolder.txtprice.setText("" + num * totalPrice1);

                } else if (num > 30) {
                    num = 30;
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
