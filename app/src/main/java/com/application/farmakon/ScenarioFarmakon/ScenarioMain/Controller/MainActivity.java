package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.farmakon.R;
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
import com.application.farmakon.ScenarioFarmakon.ScenarioVouchers.Controller.Vouchers;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity {

    public static BottomNavigationView navigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    public static LinearLayout lineartoolbar;
    DrawerLayout drawerLayout;
    TextView txtdissmiss;
    FirebaseStorage storage;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        navigation = findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();


        if (Product_Details.opencart == 1){

            Fragment_Cart cart = new Fragment_Cart();
            loadFragment(cart);
            navigation.setSelectedItemId(R.id.icon_cart);

            Product_Details.opencart = 0;


        }else {

            FragmentTransaction fr = MainActivity.this.getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container, new Fragment_Home(), "Home_Fragment");
            fr.addToBackStack(null);
            fr.commit();
            navigation.setSelectedItemId(R.id.icon_home);

        }


        drawerLayout = findViewById(R.id.drawer);
        lineartoolbar = findViewById(R.id.linearToolbar);
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

//                AlertDialog.Builder alertDialogBulder = new AlertDialog.Builder(MainActivity.this);
//
//                alertDialogBulder.setTitle("تسجيل الخروج");
//
//                alertDialogBulder
//                        .setMessage("هل تريد تسجيل الخروج من تمرات ")
//                        .setCancelable(false)
//                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                loading.setVisibility(View.VISIBLE);
//                                logout = 1;
//                                new Apicalls(MainActivity.this, MainActivity.this).Logout();
//                                disconnectFromFacebook();
//                                signOut();
//
////                                Register.logedin = 0;
////                                SignIn.logedin = 0;
//
//                            }
//                        }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        dialog.cancel();
//                    }
//                });
//
//                //create it
//                AlertDialog alertDialog = alertDialogBulder.create();
//                // show it
//                alertDialog.show();

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

}