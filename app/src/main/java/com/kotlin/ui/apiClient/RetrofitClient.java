package com.kotlin.ui.apiClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kotlin.ui.BuildConfig;
import com.kotlin.ui.utils.JsonKeys;
import com.kotlin.ui.utils.helpers.LogHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public final class RetrofitClient {

    private static final String BASE_URL = BuildConfig.BASE_URL;
    private static final String REQUEST_HEADER_TAG = "<<<< RequestHeader >>>>";

    private static final String KEY_ACCEPT = "Accept";
    private static final String KEY_CONTENT_TYPE = "Content-Type";

    private static final RetrofitClient ourInstance = new RetrofitClient();
    private Retrofit retrofit;

    public static RetrofitClient getInstance() {
        return ourInstance;
    }

    private RetrofitClient() {
    }

    private Retrofit getRetrofitJson() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .serializeNulls()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClientJson().build())
                    .build();
        }

        return retrofit;
    }

    private Retrofit getRetrofitXml() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .client(httpClientXml().build())
                    .build();
        }

        return retrofit;
    }

    ApiInterface getClientJson() {
        return getRetrofitJson().create(ApiInterface.class);
    }

    ApiInterface getClientXml() {
        return getRetrofitXml().create(ApiInterface.class);
    }

    private OkHttpClient.Builder httpClientJson() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        if (BuildConfig.IS_PROD) {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        // add logging as last interceptor
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(20, TimeUnit.SECONDS);
        httpClient.writeTimeout(20, TimeUnit.SECONDS);


        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            // BaseRequest customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader(KEY_ACCEPT, JsonKeys.KEY_APPLICATION_JSON)
                    .addHeader(KEY_CONTENT_TYPE, JsonKeys.KEY_APPLICATION_JSON);

            Request request = requestBuilder.build();
            LogHelper.v(REQUEST_HEADER_TAG, request.body() + "");
            return chain.proceed(request);
        });
        return httpClient;
    }

    private OkHttpClient.Builder httpClientXml() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        if (BuildConfig.IS_PROD) {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        // add logging as last interceptor
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(20, TimeUnit.SECONDS);
        httpClient.writeTimeout(20, TimeUnit.SECONDS);


        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            // BaseRequest customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader(KEY_ACCEPT, JsonKeys.KEY_APPLICATION_XML)
                    .addHeader(KEY_CONTENT_TYPE, JsonKeys.KEY_APPLICATION_XML);

            Request request = requestBuilder.build();
            LogHelper.v(REQUEST_HEADER_TAG, request.body() + "");
            return chain.proceed(request);
        });
        return httpClient;
    }

    /**
     * Callback interface for delivering parsed responses.
     */
    public interface Listener<T, U> {

        void onResponse(T response);
        void onError(U error);
    }
}
