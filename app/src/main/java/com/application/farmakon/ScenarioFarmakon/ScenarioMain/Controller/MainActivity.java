package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioHome.Controller.SignIn;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Model.ModelLogout;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Pattrens.IFOnBackPressed;
import com.application.farmakon.ScenarioFarmakon.ScenarioPersonalInfo.Controller.Personal_Info;
import com.application.farmakon.ScenarioFarmakon.ScenarioPrevouisOrders.Controller.Previous_Orders;
import com.application.farmakon.ScenarioFarmakon.ScenarioAboutUs.Controller.About_Us;
import com.application.farmakon.ScenarioFarmakon.ScenarioAddress.Controller.Address;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Controller.FAQ;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCart.Controller.Fragment_Cart;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Controller.Fragment_Category;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentHome.Controller.Fragment_Home;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Controller.Fragment_Notification;
import com.application.farmakon.ScenarioFarmakon.ScenarioProductDetails.Controller.Product_Details;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Controller.Products;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllProduct;
import com.application.farmakon.ScenarioFarmakon.ScenarioProducts.Model.ModelAllSelectedItem;
import com.application.farmakon.ScenarioFarmakon.ScenarioVouchers.Controller.Vouchers;
import com.application.farmakon.Utils.TinyDB;
import com.application.farmakon.local_data.send_data;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements NetworkInterface {

    public static BottomNavigationView navigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public static LinearLayout lineartoolbar;
    DrawerLayout drawerLayout;
    TextView txtdissmiss;
    FirebaseStorage storage;
    StorageReference storageReference;
    public static LinearLayout loading;
    TinyDB tinyDB;
    AutoCompleteTextView edittoolsearch;
    int x = 0;
    ModelAllSelectedItem[] selectedItems;
    private List<String> selectedItemList = new ArrayList<String>();

    private static String[] searchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        lineartoolbar = findViewById(R.id.linearToolbar);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        edittoolsearch = findViewById(R.id.editToolSearch);
        navigation = findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();
        loading = findViewById(R.id.loading);


//        loading.setVisibility(View.VISIBLE);
        x = 1;
        new Apicalls(MainActivity.this, MainActivity.this).get_all_products();

        if (Product_Details.opencart == 1) {

            Fragment_Cart cart = new Fragment_Cart();
            loadFragment(cart);
            navigation.setSelectedItemId(R.id.icon_cart);

            Product_Details.opencart = 0;


        } else {

            lineartoolbar.setVisibility(View.VISIBLE);
            FragmentTransaction fr = MainActivity.this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container, new Fragment_Category());
            fr.addToBackStack(null);
            fr.commit();
            navigation.setSelectedItemId(R.id.icon_category);

        }


        drawerLayout = findViewById(R.id.drawer);


        txtdissmiss = findViewById(R.id.txtDismiss);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.icon_home:

                        FragmentTransaction fr = MainActivity.this.getSupportFragmentManager().beginTransaction();
                        fr.replace(R.id.fragment_container, new Fragment_Home(), "Home_Fragment");
                        fr.addToBackStack(null);
                        fr.commit();
                        lineartoolbar.setVisibility(View.GONE);
                        return true;


                    case R.id.icon_category:
                        Fragment_Category category = new Fragment_Category();
                        loadFragment(category);
                        lineartoolbar.setVisibility(View.VISIBLE);
                        return true;

                    case R.id.icon_notification:

                        Fragment_Notification notification = new Fragment_Notification();
                        loadFragment(notification);
                        lineartoolbar.setVisibility(View.VISIBLE);
                        return true;


                    case R.id.icon_cart:

                        Fragment_Cart cart = new Fragment_Cart();
                        loadFragment(cart);
                        lineartoolbar.setVisibility(View.VISIBLE);


                    default:
                        return true;

                }


            }
        });

        // OPEN AND CLOSE DRAWER
        menu();

        //ON CLICK NAVIGATION
        onClick_navigation();

        txtdissmiss.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.START);
            }
        });


        edittoolsearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_SEARCH)) {

                    if (edittoolsearch.getText().toString().equals("")) {

                        edittoolsearch.setError("Please Enter Your Search Word");
                        YoYo.with(Techniques.Shake)
                                .duration(700)
                                .repeat(1)
                                .playOn(findViewById(R.id.editToolSearch));

                    } else {

                        tinyDB = new TinyDB(MainActivity.this);
                        tinyDB.putString("search_word", edittoolsearch.getText().toString());
                        Fragment_Category.x = 2;
                        startActivity(new Intent(MainActivity.this, Products.class));

                    }
                }
                return false;
            }
        });

        
        edittoolsearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tinyDB = new TinyDB(MainActivity.this);
                tinyDB.putString("search_word", selectedItemList.get(position));
                Fragment_Category.x = 2;
                startActivity(new Intent(MainActivity.this, Products.class));
                
            }
        });


    }


    private void loadFragment(Fragment fragment) {

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


    public void menu() {
        ImageView menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });


    }


    void onClick_navigation() {

        //FAQ
        LinearLayout linearFAq = findViewById(R.id.linearFAQ);
        linearFAq.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }
                startActivity(new Intent(MainActivity.this, FAQ.class));

            }
        });


        //GO TO LOGOUT
        LinearLayout linearlogout = findViewById(R.id.linearLogOut);
        linearlogout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }

                AlertDialog.Builder alertDialogBulder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBulder.setTitle("Logout");

                alertDialogBulder
                        .setMessage("Are you Sure You Want To Logout")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                loading.setVisibility(View.VISIBLE);
                                new Apicalls(MainActivity.this, MainActivity.this).Logout();

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

                //create it
                AlertDialog alertDialog = alertDialogBulder.create();
                // show it
                alertDialog.show();

            }
        });

        //GO TO Share
        LinearLayout lineaaboutus = findViewById(R.id.linearAboutUS);
        lineaaboutus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }

                startActivity(new Intent(MainActivity.this, About_Us.class));

            }
        });


        //GO TO PERSONAL INFO
        LinearLayout linearpersonal = findViewById(R.id.linearPersonalInfo);
        linearpersonal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }


                startActivity(new Intent(MainActivity.this, Personal_Info.class));
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"http://www.tamraat.com" );
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });


        //GO TO SAVED PLACES
        LinearLayout linearsavedplaces = findViewById(R.id.linearSavedPlaces);
        linearsavedplaces.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }

                startActivity(new Intent(MainActivity.this, Address.class));

//                ParserTask parserTask = new ParserTask();
//                parserTask.cancel(true);
//                PlacesTask placesTask = new PlacesTask();
//                placesTask.cancel(true);
//                startActivity(new Intent(MainActivity.this, Cart.class));
//                finish();

            }
        });

        //Go To Information PREVIOUS ORDERS

        LinearLayout linearpreviousorder = findViewById(R.id.linearPreviousOrder);
        linearpreviousorder.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }

                startActivity(new Intent(MainActivity.this, Previous_Orders.class));

//                ParserTask parserTask = new ParserTask();
//                parserTask.cancel(true);
//                PlacesTask placesTask = new PlacesTask();
//                placesTask.cancel(true);
//                startActivity(new Intent(MainActivity.this, Previous_Orders.class));
//                finish();

            }
        });


        //GO TO VOUCHERS
        LinearLayout linearvouchers = findViewById(R.id.linearVouchers);
        linearvouchers.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(Gravity.START)) {
                    drawerLayout.closeDrawer(Gravity.START);

                } else {
                    drawerLayout.openDrawer(Gravity.START);
                }

                startActivity(new Intent(MainActivity.this, Vouchers.class));

//                ParserTask parserTask = new ParserTask();
//                parserTask.cancel(true);
//                PlacesTask placesTask = new PlacesTask();
//                placesTask.cancel(true);
//                startActivity(new Intent(MainActivity.this, Previous_Orders.class));
//                finish();

            }
        });


    }


    public void onChooseFile(View v) {

        CropImage.activity()
                .setMaxCropResultSize(10000, 10000)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .start(this);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("Home_Fragment");
        fragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (!(fragment instanceof IFOnBackPressed) || !((IFOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {
        loading.setVisibility(View.GONE);

        if (x == 1) {
            x = 0;

            Gson gson = new Gson();

            ModelAllProduct allProducts = gson.fromJson(String.valueOf(model.getJsonObject()), ModelAllProduct.class);
            selectedItems = allProducts.getSelectedItems();

            for (int i = 0; i < selectedItems.length; i++) {

                selectedItemList.add(selectedItems[i].getTitle());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedItemList);
            edittoolsearch.setAdapter(adapter);

        } else {

            tinyDB = new TinyDB(MainActivity.this);
            Gson gson2 = new Gson();
            ModelLogout logouta = gson2.fromJson(model.getJsonObject().toString(), ModelLogout.class);
            send_data.userId_check(MainActivity.this, false);
            send_data.token(MainActivity.this, "0");
            send_data.user_id(this, "0");
            startActivity(new Intent(MainActivity.this, SignIn.class));
            finish();

        }

    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

        Log.e("Logout_Error", error.toString());

    }
}