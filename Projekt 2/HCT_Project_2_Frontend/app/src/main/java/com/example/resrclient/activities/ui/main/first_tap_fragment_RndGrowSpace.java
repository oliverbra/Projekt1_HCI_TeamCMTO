package com.example.resrclient.activities.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.resrclient.R;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.restClasses.RestTaskGrowSpace;

import java.util.concurrent.ExecutionException;

public class first_tap_fragment_RndGrowSpace extends Fragment {

    private GrowSpace growSpace;

    public first_tap_fragment_RndGrowSpace() {
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
        View v = inflater.inflate(R.layout.rnd_gs_first_tap_fragment, container, false);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        int gsId = preferences.getInt("rndGS", 0);
        String url = "http://10.0.2.2:8080/growspaces/" + gsId;
        GrowSpace growSpace = null;
        try {
            growSpace = new RestTaskGrowSpace().execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Information
        TextView gsname = v.findViewById(R.id.rnd_gs_growSpace_name_textView);
        gsname.setText(growSpace.getName());

        RatingBar gsrating = v.findViewById(R.id.rnd_gs_rating);
        gsrating.setRating((float)growSpace.getAverageRating());

        TextView goal = v.findViewById(R.id.rnd_gs_growSpace_Ziel_textView);
        goal.setText(growSpace.getGoal());

        TextView category = v.findViewById(R.id.rnd_gs_growSpace_Kategorie_textView);
        category.setText(growSpace.getCategory());

        TextView size = v.findViewById(R.id.rnd_gs_gssize);
        if(growSpace.getSize() == 0.0){
            size.setVisibility(View.INVISIBLE);
            v.findViewById(R.id.rnd_gs_textView7).setVisibility(View.INVISIBLE);
            v.findViewById(R.id.rnd_gs_textView8).setVisibility(View.INVISIBLE);
        }
        size.setText(String.valueOf(growSpace.getSize()));

        TextView location = v.findViewById(R.id.rnd_gs_gslocation);
        if(growSpace.getLocation().equals("")){
            location.setVisibility(View.INVISIBLE);
            v.findViewById(R.id.rnd_gs_textView9).setVisibility(View.INVISIBLE);
        }
        location.setText(growSpace.getLocation());

        return v;

    }
}
