package com.example.resrclient.activities.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.resrclient.R;
import com.example.resrclient.activities.plantView.PlantAdapter;
import com.example.resrclient.carousel.CarouselAdapter;
import com.example.resrclient.carousel.CarouselItem;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class second_tap_fragment_MyGrowSpace extends Fragment {

    private GrowSpace growSpace;

    public second_tap_fragment_MyGrowSpace() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.my_gs_second_tap_fragment, container, false);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        int userId = preferences.getInt("userId", 0);
        String url = "http://10.0.2.2:8080/users/" + userId;
        User currentUser = null;
        try {
            currentUser = new RestTaskUser().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        growSpace = currentUser.getGrowSpace();

        TextView info = v.findViewById(R.id.my_gs_plantInfo);
        ListView lv = v.findViewById(R.id.my_gs_plantsListView);

        if(growSpace.getSize() != 0) {
            lv.setVisibility(View.VISIBLE);
            info.setVisibility(View.GONE);
            PlantAdapter plantAdapter = new PlantAdapter(this.getContext(), growSpace.getPlants());
            lv.setAdapter(plantAdapter);
        } else {
            info.setVisibility(View.VISIBLE);
            lv.setVisibility(View.GONE);
        }


        return v;    }
}