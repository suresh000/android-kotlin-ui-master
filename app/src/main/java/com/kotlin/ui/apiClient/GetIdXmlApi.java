package com.kotlin.ui.apiClient;

import android.support.annotation.NonNull;

import com.kotlin.ui.model.IdXmlRequest;
import com.kotlin.ui.model.IdXmlResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetIdXmlApi {

    private IdXmlRequest request = new IdXmlRequest();


    public GetIdXmlApi() {
        //gson.toJsonTree(baseRequest)

        request.setSubKuaRefNo("ABCDEF1234");
        request.setLicensekey("ABCD1234");
        request.setSubKuaCode("ABCDEF1234");
        request.setAuthenticationType("otp");
        request.setKuaApiVersion("2.5");
        request.setReqResType("xml");
        request.setPan("ABCDE1234D");
        request.setSuccessUrl("http://172.19.10.44:8084/showEkycData");
        request.setFailUrl("http://172.19.10.44:8084/showEkycData");
        request.setCheckSum("1021519515");
    }

    public void call(RetrofitClient.Listener<IdXmlResponse, ApiError> listener) {
        RetrofitClient.getInstance().getClientXml().idXml(request).enqueue(new Callback<IdXmlResponse>() {
            @Override
            public void onResponse(@NonNull Call<IdXmlResponse> call, @NonNull Response<IdXmlResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println(response);
                    listener.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<IdXmlResponse> call, @NonNull Throwable t) {
                listener.onError(new ApiError("", t.getMessage()));
            }
        });
    }
}
