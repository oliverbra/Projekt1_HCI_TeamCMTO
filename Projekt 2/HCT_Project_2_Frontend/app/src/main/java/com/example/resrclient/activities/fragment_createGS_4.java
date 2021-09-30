package com.example.resrclient.activities;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.resrclient.R;
import com.example.resrclient.fileUplaod_Download.Bilder_save_load;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class fragment_createGS_4 extends Fragment {
    private static final int RESULT_OK = -1;
    int PICK_IMAGE_MULTIPLE = 1;
    ArrayList<Uri> mArrayUri;
    int position = 0;
    List<String> imagesEncodedList;
    View v;
    public fragment_createGS_4() {
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
         v = inflater.inflate(R.layout.fragment_create_g_s_4, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        Bundle bundle = this.getArguments();

        //Hier der Button der zum 5. Fragment führt
        ImageButton toFrag3btn = view.findViewById(R.id.frag4tofrag5plant);
        toFrag3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_fragment_createGS_4_to_fragment_createGS_5plants, bundle);
            }
        });

        Button selctBilder = view.findViewById(R.id.onBoarding_bilderWahl_hButton);
        selctBilder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selctMultibleImages();
            }
        });
    }

    public void selctMultibleImages(){
        Intent intent = new Intent();

        // setting type to select to be image
        intent.setType("image/*");

        // allowing multiple image to be selected
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bilder_save_load bsl = new Bilder_save_load();
        // When an Image is picked
        if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
            // Get the Image from data
            if (data.getClipData() != null) {
                ClipData mClipData = data.getClipData();
                int count = data.getClipData().getItemCount();

                for (int i = 0; i < count; i++) {
                    // adding imageuri in array
                    Log.v("OnBoarding", "Get Uris From Intent" +  data.getClipData().getItemAt(i).getUri());
                    //mArrayUri.add(data.getClipData().getItemAt(i).getUri());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    // Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
                    Bitmap bitmap= null;
                    try {
                        bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(data.getClipData().getItemAt(i).getUri()));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    bsl.saveImage(getActivity().getApplicationContext(),bitmap,"growSpaceBild"+i);
                }
                // setting 1st selected image into image switcher
                
                position = 0;
            } else {

                position = 0;

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                // Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
                Bitmap bitmap= null;
                try {
                    bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(data.getData()));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bsl.saveImage(getActivity().getApplicationContext(),bitmap,"growSpaceBild");
            }
        } else {
            // show this if no image is selected
            Toast.makeText(getActivity().getApplicationContext(), "You haven't picked Image", Toast.LENGTH_LONG).show();
        }


        ImageView testView = v.findViewById(R.id.imageView4_test_Bilder);
        testView.setImageBitmap(bsl.loadImageBitmap(getActivity().getApplicationContext(),"growSpaceBild0"));

    }
}