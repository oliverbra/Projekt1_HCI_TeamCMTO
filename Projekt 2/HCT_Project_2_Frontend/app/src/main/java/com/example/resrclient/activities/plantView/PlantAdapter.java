package com.example.resrclient.activities.plantView;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.resrclient.R;
import com.example.resrclient.activities.fragment_createGS_5plants;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlantAdapter extends ArrayAdapter<Plants> {

    Context ctx;
    List<Plants> allPlants;

    public PlantAdapter(Context ctx, List<Plants> allPlants) {
        super(ctx, R.layout.single_plant_layout, R.id.singlePlant_TextView_Name, allPlants);
        this.ctx = ctx;
        this.allPlants = allPlants;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        PlantViewHolder holder = null;

        if(singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_plant_layout, parent, false);
            holder = new PlantViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else {
            holder = (PlantViewHolder) singleItem.getTag();
        }

        //Enter data to display here
        //holder.file.setFile(allPlants.get(position));
        holder.plantName.setText(allPlants.get(position).getCommonName());

        PlantViewHolder finalHolder = holder;
        finalHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalHolder.button.getText().equals("Add")) {
                    finalHolder.button.setText("Remove");

                    Set<String>  set = new HashSet<String>();
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
                    set = pref.getStringSet("selectedPlants", null);

                    SharedPreferences.Editor edit = pref.edit();
                    set.add(allPlants.get(position).getId().toString());
                    edit.putStringSet("selectedPlants", set);
                    edit.commit();

                } else {
                    finalHolder.button.setText("Add");
                    Set<String>  set = new HashSet<String>();
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
                    set = pref.getStringSet("selectedPlants", null);

                    SharedPreferences.Editor edit = pref.edit();

                    for (String entry : set)
                    {
                        if(entry.equals(allPlants.get(position).getId().toString())) {
                            set.remove(entry);
                        }
                    }

                    edit.putStringSet("selectedPlants", set);
                    edit.commit();
                }
            }
        });


        return singleItem;
    }
}
