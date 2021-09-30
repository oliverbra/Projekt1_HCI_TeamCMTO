package com.example.resrclient.activities.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.resrclient.R;
import com.example.resrclient.carousel.CarouselAdapter;
import com.example.resrclient.carousel.CarouselItem;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.User;
import com.example.resrclient.restClasses.RestTaskGrowSpace;
import com.example.resrclient.restClasses.RestTaskUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class third_tap_fragment_RndGrowSpace extends Fragment {

    private GrowSpace growSpace;
    private ViewPager2 carousel;
    private LinearLayout dotsLayout;
    private ImageView[] dots;


    public third_tap_fragment_RndGrowSpace() {
        // Required empty public constructor
    }

    public void addDotsIndicator(List<CarouselItem> carouselItems) {
        dots = new ImageView[carouselItems.size()];
        dotsLayout.removeAllViews();

        for(int i = 0; i < carouselItems.size(); i++) {

            dots[i] = new ImageView(getContext());
            dots[i].setImageResource(R.drawable.dot_inactive);
            dots[i].setPadding(3,0,3,0);

            dotsLayout.addView(dots[i]);
            Log.v("dots", "Dot " + i + " added");
        }
    }

    ViewPager2.OnPageChangeCallback carouselListener = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            for(int i = 0; i < dots.length; i++) {
                if(i == position) {
                    dots[i].setImageResource(R.drawable.dot_active);
                } else dots[i].setImageResource(R.drawable.dot_inactive);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.rnd_gs_third_tap_fragment, container, false);

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

        carousel = (ViewPager2) v.findViewById(R.id.carousel); // Carousel
        dotsLayout = (LinearLayout) v.findViewById(R.id.dotsLayout); // Carousel
        TextView info = v.findViewById(R.id.rnd_gs_nopictures);

        // Carousel --> add GS Images here
        List<CarouselItem> carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem(R.drawable.rndgs_pic1));
        carouselItems.add(new CarouselItem(R.drawable.rndgs_pic2));
        carouselItems.add(new CarouselItem(R.drawable.rndgs_pic3));

        if(carouselItems.isEmpty()) {
            carousel.setVisibility(View.GONE);
            dotsLayout.setVisibility(View.GONE);
            info.setVisibility(View.VISIBLE);
        } else {
            info.setVisibility(View.GONE);
            carousel.setVisibility(View.VISIBLE);
            dotsLayout.setVisibility(View.VISIBLE);

            carousel.setAdapter(new CarouselAdapter(carouselItems, carousel));

            /*/ Extra: Nachbar-Images am Rand erkennbar
            carousel.setClipToPadding(false);
            carousel.setClipChildren(false);
            carousel.setOffscreenPageLimit(3);
            carousel.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(40));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });

            carousel.setPageTransformer(compositePageTransformer); */

            // Dots Indicator hinzufügen
            addDotsIndicator(carouselItems);
            carousel.registerOnPageChangeCallback(carouselListener);
        }

        return v;
    }
}
