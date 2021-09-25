package com.example.resrclient.fileUplaod_Download;

import android.renderscript.Sampler;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface WebAPIService {
    @Multipart
    @POST("uploadFile")
    Call<ResponseBody> postFile(@Part MultipartBody.Part file, @Part("description")RequestBody description);

    @GET("getFile/{id}")
    Call<ResponseBody> getFile(@Path(value = "id") Integer pictureId);
}
