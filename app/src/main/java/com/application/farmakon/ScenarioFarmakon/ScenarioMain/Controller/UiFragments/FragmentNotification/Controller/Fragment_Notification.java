package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens.RcyNotificationAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Notification extends Fragment {

    private View view;
    private List<Notification_Model> notificationList = new ArrayList<>();
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.notification_fragment, container, false);

        recyclerView = view.findViewById(R.id.rcyNotification);
        MainActivity.lineartoolbar.setVisibility(View.VISIBLE);

        int[] imgNotification ={R.drawable.images,R.drawable.images, R.drawable.images,
                R.drawable.images,R.drawable.images,R.drawable.images,R.drawable.images,R.drawable.images,R.drawable.images,
                R.drawable.images,R.drawable.images,R.drawable.images};

        String[] txtTitle ={"Notification Name", "Notification Name", "Notification Name", "Notification Name", "Notification Name","Notification Name",
                "Notification Name","Notification Name","Notification Name", "Notification Name", "Notification Name", "Notification Name"};

        String[] txtDescription ={"Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc","Notification Desc",
                "Notification Desc","Notification Desc","Notification Desc", "Notification Desc", "Notification Desc", "Notification Desc"};

        for (int i = 0; i<imgNotification.length; i++)
        {
            Notification_Model model = new Notification_Model(imgNotification[i],txtTitle[i],txtDescription[i]);
            notificationList.add(model);
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RcyNotificationAdapter adabter = new RcyNotificationAdapter(notificationList,getContext());
        recyclerView.setAdapter(adabter);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}
