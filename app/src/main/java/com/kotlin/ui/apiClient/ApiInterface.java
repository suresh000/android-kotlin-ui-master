package com.kotlin.ui.apiClient;

import com.google.gson.JsonObject;
import com.kotlin.ui.model.IdResponse;
import com.kotlin.ui.model.IdXmlRequest;
import com.kotlin.ui.model.IdXmlResponse;
import com.kotlin.ui.retrofitExample.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @POST("reqSubKuaForAndroid")
    Call<IdResponse> id(@Body JsonObject postParams);

    @POST("reqSubKuaForAndroid")
    Call<IdXmlResponse> idXml(@Body IdXmlRequest postParams);
}
