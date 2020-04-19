package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentHome.Controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.MainActivity;

public class Fragment_Home extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        MainActivity.lineartoolbar.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}
