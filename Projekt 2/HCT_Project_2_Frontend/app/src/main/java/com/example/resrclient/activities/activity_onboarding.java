package com.example.resrclient.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.resrclient.R;
import com.example.resrclient.asyncTasks.AllPlantsTask;
import com.example.resrclient.asyncTasks.CreateGSTask;
import com.example.resrclient.objectClasses.Plants;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.restClasses.RestTaskPlant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//public class activity_createGS extends AppCompatActivity implements AdapterView.OnItemSelectedListener
public class activity_onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_gs);
    }

}
