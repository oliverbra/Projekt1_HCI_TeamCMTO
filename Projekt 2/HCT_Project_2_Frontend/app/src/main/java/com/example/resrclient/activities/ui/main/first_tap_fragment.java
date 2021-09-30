package com.example.resrclient.activities.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.resrclient.R;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskUser;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

public class first_tap_fragment extends Fragment {

    private GrowSpace growSpace;

    public first_tap_fragment() {
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
        View v = inflater.inflate(R.layout.fragemnt_first_tap_fragment, container, false);

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

        //Information
        TextView gsname = v.findViewById(R.id.growSpace_name_textView);
        gsname.setText(growSpace.getName());

        RatingBar gsrating = v.findViewById(R.id.rating);
        gsrating.setRating((float)growSpace.getAverageRating());

        TextView username = v.findViewById(R.id.usernameGS);
        username.setText(currentUser.getUserName());

        TextView level = v.findViewById(R.id.level);
        level.setText(currentUser.getLevel().getLevelName());

        TextView goal = v.findViewById(R.id.growSpace_Ziel_textView);
        goal.setText(growSpace.getGoal());

        TextView category = v.findViewById(R.id.growSpace_Kategorie_textView);
        category.setText(growSpace.getCategory());

        TextView size = v.findViewById(R.id.gssize);
        if(growSpace.getSize() == 0.0){
            size.setVisibility(View.INVISIBLE);
            v.findViewById(R.id.textView7).setVisibility(View.INVISIBLE);
            v.findViewById(R.id.textView8).setVisibility(View.INVISIBLE);
        }
        size.setText(String.valueOf(growSpace.getSize()));

        TextView location = v.findViewById(R.id.gslocation);
        if(growSpace.getLocation().equals("")){
            location.setVisibility(View.INVISIBLE);
            v.findViewById(R.id.textView9).setVisibility(View.INVISIBLE);
        }
        location.setText(growSpace.getLocation());

        return v;

    }
}