package com.example.resrclient.activities.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resrclient.R;
import com.example.resrclient.activities.plantView.PlantAdapter;
import com.example.resrclient.activities.plantView.PlantAdapter2;
import com.example.resrclient.asyncTasks.AllAddedPlantsTask;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskGrowSpace;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class second_tap_fragment_RndGrowSpace extends Fragment {

    private List<Plants> myPlants;

    public second_tap_fragment_RndGrowSpace() {
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
        View v = inflater.inflate(R.layout.rnd_gs_second_tap_fragment, container, false);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        int gsId = preferences.getInt("rndGS", 0);

        try {
            myPlants = new AllAddedPlantsTask().execute(String.valueOf(gsId)).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView info = v.findViewById(R.id.rnd_gs_plantInfo);
        ListView lv = v.findViewById(R.id.rnd_gs_plantsListView);

        if(myPlants.size() != 0) {
            lv.setVisibility(View.VISIBLE);
            info.setVisibility(View.GONE);
            PlantAdapter2 plantAdapter = new PlantAdapter2(this.getContext(), myPlants);
            lv.setAdapter(plantAdapter);
        } else {
            info.setVisibility(View.VISIBLE);
            lv.setVisibility(View.GONE);
        }

        return v;    }
}
