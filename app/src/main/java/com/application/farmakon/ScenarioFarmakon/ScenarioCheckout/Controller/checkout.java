package com.application.farmakon.ScenarioFarmakon.ScenarioCheckout.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller.Add_Address_Popup;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller.Address;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Photo_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Model.Realm_Cart_Product_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Photo_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Pattrens.Realm_Cart_Product_adapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.application.farmakon.Utils.TinyDB;
import com.application.farmakon.local_data.saved_data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;

public class checkout extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner;
    TextView txtdeliverytime, txtaddress, txtnumber, txtphotocount, txtitemcount, txtexpecteddeliverytime, txttotal, txtnototal;
    Button btnplaceorder;
    Realm realm;
    Realm_Cart_Photo_adapter adapter_Photo;
    Realm_Cart_Product_adapter adapter_product;
    LinearLayout loading;
    ArrayList<Realm_Cart_Photo_Model> cart_photo_list = new ArrayList<>();
    ArrayList<Realm_Cart_Product_Model> cart_product_list = new ArrayList<>();
    JSONArray jsonArrayproduct;
    JSONArray jsonArrayphoto;
    TinyDB tinyDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Realm.init(this);
        realm = Realm.getDefaultInstance();
        tinyDB = new TinyDB(checkout.this);

        adapter_Photo = new Realm_Cart_Photo_adapter(realm);
        adapter_product = new Realm_Cart_Product_adapter(realm);

        cart_photo_list = adapter_Photo.retrieve();
        cart_product_list = adapter_product.retrieve();

        if (adapter_product.retrieve().size() != 0 || adapter_product.retrieve() != null) {


            try {

                jsonArrayproduct = new JSONArray();
                for (int i = 0; i < adapter_product.retrieve().size(); i++) {

                    JSONObject object = new JSONObject();

                    object.put("id", cart_product_list.get(i).getProduct_id());
                    object.put("quantity", cart_product_list.get(i).getTxtnumberchoose());

                    jsonArrayproduct.put(object);
                }
                Log.e("arraylists", jsonArrayproduct.toString());


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        jsonArrayphoto = new JSONArray();

        if (adapter_Photo.retrieve().size() != 0 || adapter_Photo.retrieve() != null) {


            for (int i = 0; i < adapter_Photo.retrieve().size(); i++) {


                jsonArrayphoto.put(cart_photo_list.get(i).getImghome());

            }
            Log.e("array_image", jsonArrayphoto.toString());
        }


        spinner1 = findViewById(R.id.spinPaymentMethod);
        spinner = new Spinner(this);

        txtdeliverytime = findViewById(R.id.txtDeliveryTime);
        txtaddress = findViewById(R.id.txtCheckoutAddress);
        txtnumber = findViewById(R.id.txtCheckoutPhone);
        txtphotocount = findViewById(R.id.txtCheckoutPhotoCount);
        txtitemcount = findViewById(R.id.txtCheckoutItemCount);
        txtexpecteddeliverytime = findViewById(R.id.txtExpectedDeliveryTime);
        txttotal = findViewById(R.id.txtCheckoutTotal);
        txtnototal = findViewById(R.id.txtCheckoutNoTotal);
        btnplaceorder = findViewById(R.id.btnPlaceOrder);
        loading = findViewById(R.id.loading);




        txttotal.setVisibility(View.GONE);
        txtnototal.setVisibility(View.GONE);


        txtnumber.setText("" + saved_data.get_phone_number(checkout.this));
        txtaddress.setText(tinyDB.getString("AddressName"));


        txtphotocount.setText(tinyDB.getString("Photo_Count"));
        txtitemcount.setText(tinyDB.getString("item_Count"));

        if (txtphotocount.getText().toString().equals("0")) {

            int toatalprice = 0;
            for (int x = 0; x < adapter_product.retrieve().size(); x++) {

                double price = Double.parseDouble(cart_product_list.get(x).getTxtprice());
                int number = Integer.parseInt(cart_product_list.get(x).getTxtnumberchoose());

                int totalpricebefortax = (int) (price * number);

                toatalprice += totalpricebefortax;

            }

            txttotal.setVisibility(View.VISIBLE);
            txtnototal.setVisibility(View.GONE);

            txttotal.setText("" + toatalprice);


        } else {

            txtnototal.setVisibility(View.VISIBLE);
            txttotal.setVisibility(View.GONE);


        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.payment_method, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loading.setVisibility(View.VISIBLE);
                place_order(jsonArrayproduct,jsonArrayphoto,tinyDB.getString("Notes"),tinyDB.getString("AddressId"));

            }
        });

    }

    @Override
    public void onBackPressed() {

        Product_Details.opencart = 1;
        startActivity(new Intent(checkout.this, MainActivity.class));
        finish();

    }


    void place_order(JSONArray products, JSONArray image_urls, String notes, String address_id) {

        try {
            String URL = "https://www.pharmakon.be4maps.com/api/order-items";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("products", products);
            jsonBody.put("image_urls", image_urls);
            jsonBody.put("notes", notes);
            jsonBody.put("address_id", address_id);

            Log.e("json-body",jsonBody.toString());


            JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    loading.setVisibility(View.GONE);
                    try {

                        JSONObject jsonObject = response.getJSONObject("data");

                        jsonObject.getString("order_id");
                        Log.e("order_id", jsonObject.getString("order_id"));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    CheckOut_Popup add_address_popup = new CheckOut_Popup();
                    add_address_popup.dialog(checkout.this, R.layout.checkout_popup, 1);
                    adapter_Photo.delete_all();
                    adapter_product.delete_all();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
//                    Toasty.error(checkout.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    Log.e("checkout_error", error.toString());

                }
            }) {
                @Override
                public Map<String, String> getHeaders() {
                    final Map<String, String> headers = new HashMap<>();
                    headers.put("Accept", "application/json");
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + saved_data.get_token(checkout.this));
                    return headers;
                }
            };

            jsonOblect.setShouldCache(false);
            jsonOblect.setRetryPolicy(new DefaultRetryPolicy(
                    DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 7,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Volley.newRequestQueue(checkout.this).add(jsonOblect);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
