package com.example.resrclient.asyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.resrclient.fileUplaod_Download.WebAPIService;
import com.example.resrclient.objectClasses.User;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class DownloadFileTask extends AsyncTask<String, Void, File> {

    private final String LOG_TAG = "BNK";


    Context ctx;
    public DownloadFileTask (Context ctx) {
        this.ctx = ctx;
    }


    protected File doInBackground(String... params) {
        final String url = params[0];

        try {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
            WebAPIService service = retrofit.create(WebAPIService.class);
            Call<ResponseBody> call = service.getFile(1);

              ResponseBody  response =  call.execute().body();
              InputStream fileStream = response.byteStream();

              File testFile = null;

          //  Files.copy(fileStream,testFile,StandardCopyOption.COPY_ATTRIBUTES);
            Log.v("SuCC", "File" +  response.contentType());
            return null;

            /*
                RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.IMAGE_PNG));
                restTemplate.getMessageConverters().add(converter);
                File result = restTemplate.getForObject(url, File.class);
                Log.v("Result","Gefunden: " + result.getAbsoluteFile());
                return result.getAbsoluteFile();

             */
        } catch (HttpServerErrorException | IOException e) {
            System.out.println("User not found");
            return null;
        }

    }
    @Override
    protected void onPostExecute(File sendFile) {
        super.onPostExecute(sendFile);
    }



}
