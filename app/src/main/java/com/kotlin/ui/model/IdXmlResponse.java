package com.kotlin.ui.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "SubKuaEkycData")
public class IdXmlResponse {

    @Element(name = "ndmltransactionID")
    private String transactionID;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
}
