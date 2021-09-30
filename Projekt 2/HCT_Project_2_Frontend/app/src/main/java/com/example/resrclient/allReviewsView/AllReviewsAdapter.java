package com.example.resrclient.allReviewsView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.resrclient.R;
import com.example.resrclient.activities.activity_openReview;
import com.example.resrclient.objectClasses.Review;

import java.util.List;

public class AllReviewsAdapter extends ArrayAdapter<Review> {

    Context ctx;
    List<Review> myReviews;

    public AllReviewsAdapter(Context ctx, List<Review> myReviews) {
        super(ctx, R.layout.single_review_layout, R.id.singleReview_TextView_Rating, myReviews);
        this.ctx = ctx;
        this.myReviews = myReviews;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View singleItem = convertView;
        ReviewViewHolder holder = null;

        if(singleItem == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_review_layout, parent, false);
            holder = new ReviewViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else {
            holder = (ReviewViewHolder) singleItem.getTag();
        }

        //Enter data to display here
        holder.rating.setText(String.valueOf(myReviews.get(position).getRating()));



        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, activity_openReview.class);
                int reviewId = myReviews.get(position).getId();
                intent.putExtra("reviewID", reviewId);
                ctx.startActivity(intent);
            }
        });

        return singleItem;
    }
}