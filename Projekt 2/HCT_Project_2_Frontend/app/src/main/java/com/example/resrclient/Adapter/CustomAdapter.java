package com.example.resrclient.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.resrclient.R;
import com.example.resrclient.objectClasses.Review;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends ArrayAdapter<Review> {
    private List<Review> lReview;

    public CustomAdapter(@NonNull @NotNull Context context, int resource, List<Review> lReview) {
        super(context, resource);
        this.lReview = lReview;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex = position;
        if (convertView  == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_style,parent,false);
        }
        TextView textRating = convertView.findViewById(R.id.rating);

        textRating.setText(String.valueOf(lReview.get(position).getRating()));
        return super.getView(position, convertView, parent);
    }
}