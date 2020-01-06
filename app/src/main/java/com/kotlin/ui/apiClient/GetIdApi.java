package com.kotlin.ui.apiClient;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.kotlin.ui.model.IdResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetIdApi {

    private JsonObject mPostParams = new JsonObject();


    public GetIdApi() {
        //gson.toJsonTree(baseRequest)

        mPostParams.addProperty("subKuaRefNo", "ABCDEF1234");
        mPostParams.addProperty("licensekey", "ABCD1234");
        mPostParams.addProperty("subKuaCode", "ABCDEF1234");
        mPostParams.addProperty("authenticationType", "otp");
        mPostParams.addProperty("kuaApiVersion", "2.5");
        mPostParams.addProperty("reqResType", "json");
        mPostParams.addProperty("pan", "ABCDE1234D");
        mPostParams.addProperty("successUrl", "http://172.19.10.44:8084/showEkycData");
        mPostParams.addProperty("failUrl", "http://172.19.10.44:8084/showEkycData");
        mPostParams.addProperty("checkSum", "1715655377");
    }

    public void call(RetrofitClient.Listener<IdResponse, ApiError> listener) {
        RetrofitClient.getInstance().getClientJson().id(mPostParams).enqueue(new Callback<IdResponse>() {
            @Override
            public void onResponse(@NonNull Call<IdResponse> call, @NonNull Response<IdResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println(response);
                    listener.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<IdResponse> call, @NonNull Throwable t) {
                listener.onError(new ApiError("", t.getMessage()));
            }
        });
    }

}
