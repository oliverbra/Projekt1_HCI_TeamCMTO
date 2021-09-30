package com.example.resrclient.allReviewsView;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.resrclient.R;

public class ReviewViewHolder {

    ImageView img;
    TextView rating, date;
    RatingBar ratingBar;

    public ReviewViewHolder(View v) {
        this.img = v.findViewById(R.id.singleReview_ImageView);
        this.rating = v.findViewById(R.id.singleReview_TextView_Rating);
        this.date = v.findViewById(R.id.singleReview_TextView_Date);
        this.ratingBar = v.findViewById(R.id.singleReview_ratingbar);
    }

}
