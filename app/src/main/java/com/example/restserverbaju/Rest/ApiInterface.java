package com.example.restserverbaju.Rest;

import com.example.restserverbaju.Model.GetBaju;
import com.example.restserverbaju.Model.PostPutDeleteBaju;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("baju_android")
    Call<GetBaju> getBaju();
    @FormUrlEncoded
    @POST("baju")
    Call<PostPutDeleteBaju> postBaju(@Field("nama") String nama, @Field("nomor") String nomor);
    @FormUrlEncoded
    @PUT("baju")
    Call<PostPutDeleteBaju> putBaju(@Field("id_kemeja") String id_kemeja,
                                     @Field("nama") String nama,
                                     @Field("nomor") String nomor);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Baju", hasBody = true)
    Call<PostPutDeleteBaju> deleteBaju(@Field("id") String id);
}
