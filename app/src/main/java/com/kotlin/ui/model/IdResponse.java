package com.kotlin.ui.model;

import com.google.gson.annotations.SerializedName;
import com.kotlin.ui.utils.JsonKeys;

public class IdResponse {

    @SerializedName(JsonKeys.KEY_TRANSACTION_ID)
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
