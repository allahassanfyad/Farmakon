package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.application.farmakon.NetworkLayer.Apicalls;
import com.application.farmakon.NetworkLayer.NetworkInterface;
import com.application.farmakon.NetworkLayer.ResponseModel;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.ModelNotificationAll;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.ModelNotificationDatum;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Pattrens.IFOnBackPressed;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Notification extends Fragment implements IFOnBackPressed, NetworkInterface {

    private View view;
    private List<ModelNotificationDatum> notificationList = new ArrayList<>();
    RecyclerView recyclerView;
    ModelNotificationDatum[] notificationData;
    LinearLayout loading, linearnotification;
    TextView txtNoItem;
    private ShimmerFrameLayout shimmerFrameLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.notification_fragment, container, false);

        recyclerView = view.findViewById(R.id.rcyNotification);
        MainActivity.lineartoolbar.setVisibility(View.VISIBLE);
        txtNoItem = view.findViewById(R.id.txtNoItem);
        linearnotification = view.findViewById(R.id.linearNotification);
        shimmerFrameLayout = view.findViewById(R.id.loading_Shimmer);

        linearnotification.setVisibility(View.VISIBLE);
        txtNoItem.setVisibility(View.GONE);
//
//        int[] imgNotification = {R.drawable.images, R.drawable.images, R.drawable.images,
//                R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images, R.drawable.images,
//                R.drawable.images, R.drawable.images, R.drawable.images};
//
//        String[] txtTitle = {"Notification Name", "Notification Name", "Notification Name", "Notification Name", "Notification Name", "Notification Name",
//                "Notification Name", "Notification Name", "Notification Name", "Notification Name", "Notification Name", "Notification Name"};
//
//        String[] txtDescription = {"Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc",
//                "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc"};
//
//        for (int i = 0; i < imgNotification.length; i++) {
//            Notification_Model model = new Notification_Model(imgNotification[i], txtTitle[i], txtDescription[i]);
//            notificationList.add(model);
//        }



        new Apicalls(getContext(), Fragment_Notification.this).get_notification();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
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
    @Override
    public void onResume() {
        super.onResume();
        shimmerFrameLayout.startShimmer();

    }

    @Override
    public void onStop() {
        super.onStop();
        shimmerFrameLayout.stopShimmer();

    }


    @Override
    public void OnStart() {

    }

    @Override
    public void OnResponse(ResponseModel model) {

        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);


        Gson gson = new Gson();
        ModelNotificationAll notificationAll = gson.fromJson(String.valueOf(model.getJsonObject()), ModelNotificationAll.class);
        notificationData = notificationAll.getData();



        for (int i = 0; i < notificationData.length; i++) {

            ModelNotificationDatum datum = new ModelNotificationDatum();

            datum.setBody(notificationData[i].getBody());
            datum.setTitle(notificationData[i].getTitle());
            datum.setId(notificationData[i].getId());

            notificationList.add(datum);
        }
        if (notificationList.size() == 0) {

            linearnotification.setVisibility(View.GONE);
            txtNoItem.setVisibility(View.VISIBLE);

        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            RcyNotificationAdapter adabter = new RcyNotificationAdapter(notificationList, getContext());
            recyclerView.setAdapter(adabter);
        }


    }

    @Override
    public void OnError(VolleyError error) {
        loading.setVisibility(View.GONE);

        Log.e("Notification_error", error.toString());


    }
}
