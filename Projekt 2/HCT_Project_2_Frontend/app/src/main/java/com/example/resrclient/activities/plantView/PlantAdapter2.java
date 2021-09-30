package com.example.resrclient.activities.plantView;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.resrclient.R;
import com.example.resrclient.objectClasses.Plants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlantAdapter2 extends ArrayAdapter<Plants> {

    Context ctx;
    List<Plants> myPlants;

    public PlantAdapter2(Context ctx, List<Plants> myPlants) {
        super(ctx, R.layout.single_plant_layout2, R.id.singlePlant_TextView_Name2, myPlants);
        this.ctx = ctx;
        this.myPlants = myPlants;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        PlantViewHolder2 holder = null;

        if(singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_plant_layout2, parent, false);
            holder = new PlantViewHolder2(singleItem);
            singleItem.setTag(holder);
        }
        else {
            holder = (PlantViewHolder2) singleItem.getTag();
        }

        //Enter data to display here
        //holder.file.setFile(allPlants.get(position));
        holder.plantName.setText(myPlants.get(position).getCommonName());

        return singleItem;
    }
}
