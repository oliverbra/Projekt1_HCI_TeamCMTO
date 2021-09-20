package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;



import java.io.FileOutputStream;

public class UploadFileTask extends AsyncTask<String, Void, File> {

    Context ctx;
    public  UploadFileTask (Context ctx) {
        this.ctx = ctx;
    }

    protected File doInBackground(String... params) {
        final String url = params[0];
        final String filePath = params[1];
        File sendFile = new File(filePath);



        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body
                    = new LinkedMultiValueMap<>();
            body.add("file", sendFile);

            HttpEntity<MultiValueMap<String, Object>> requestEntity
                    = new HttpEntity<>(body, headers);


            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate
                    .postForEntity(url, requestEntity, String.class);
            return sendFile;
        } catch (Exception e){
            System.out.println(e.toString());
            System.out.println("Failed. " );
            return null;

        }


    }
    @Override
    protected void onPostExecute(File sendFile) {
        super.onPostExecute(sendFile);
    }
}
