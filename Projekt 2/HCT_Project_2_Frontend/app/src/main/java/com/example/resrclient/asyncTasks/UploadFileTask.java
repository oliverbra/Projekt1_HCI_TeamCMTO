package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.service.carrier.CarrierMessagingService;
import android.util.Log;

import com.example.resrclient.fileUplaod_Download.WebAPIService;
import com.example.resrclient.objectClasses.GrowSpace;
import com.example.resrclient.objectClasses.Review;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;



import java.io.FileOutputStream;
import java.nio.file.Path;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UploadFileTask extends AsyncTask<String, Void, File> {


    private final String API_URL_BASE = "http://10.0.2.2:8080/";
    private final String LOG_TAG = "BNK";


    Context ctx;
    public UploadFileTask (Context ctx) {
        this.ctx = ctx;
    }


    protected File doInBackground(String... params) {

        final String url = params[0];
      final  String filePath = params[1];
        Log.v("SuCC", "filePath" + params[1]);
        File sendFile = new File(filePath);
        Log.v("SuCC", "File" );
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        Log.v("SuCC", "create RestTampalte New");
        try {

            if (!filePath.isEmpty()) {
                File file = new File(filePath);
                Log.v("SuCC", "Create File" + filePath);
               // if (file.exists()) {
                    Log.v("SuCC", "File Exists");
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL_BASE).build();
                    Log.v("SuCC", "Retrofit Builder");
                    WebAPIService service = retrofit.create(WebAPIService.class);
                    Log.v("SuCC", "Call API");
                    // creates RequestBody instance from file
                    RequestBody requestFile = RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), sendFile);
                Log.v("SuCC", "Create Request Body Request File");
                    // MultipartBody.Part is used to send also the actual filename
                    MultipartBody.Part body = MultipartBody.Part.createFormData("file", sendFile.getName(), requestFile);
                Log.v("SuCC", "Create Request Body body");
                    // adds another part within the multipart request
                    String descriptionString = "file";
                    RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
                Log.v("SuCC", "Create Request Body description");
                    // executes the request
                    Call<ResponseBody> call = service.postFile(body, description);
                    Log.v("SuCC", "Call POST");
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call,
                                               Response<ResponseBody> response) {
                            Log.v(LOG_TAG, "success");
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.v(LOG_TAG, t.getMessage());
                            Log.v(LOG_TAG, "Failed Image");
                        }
                    });
               // }
            }
            return null;
        } catch (Exception e){
            System.out.println(e.toString());
            System.out.println("Failed. " + e);
            return null;

        }


    }
    @Override
    protected void onPostExecute(File sendFile) {
        super.onPostExecute(sendFile);
    }
}
