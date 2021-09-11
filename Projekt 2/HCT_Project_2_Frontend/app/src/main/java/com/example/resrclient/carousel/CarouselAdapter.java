package com.example.resrclient.carousel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resrclient.R;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<CarouselItem> carouselItems;
    private ViewPager2 carousel;

    public CarouselAdapter(List<CarouselItem> carouselItems, ViewPager2 carousel) {
        this.carouselItems = carouselItems;
        this.carousel = carousel;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarouselViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_layout,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselAdapter.CarouselViewHolder holder, int position) {
        holder.setImage(carouselItems.get(position));
    }

    @Override
    public int getItemCount() {
        return carouselItems.size();
    }

    class CarouselViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slideImage);
        }

        void setImage(CarouselItem carouselItem) {
            imageView.setImageResource(carouselItem.getImage());
        }
    }
}