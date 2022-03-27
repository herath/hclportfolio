package com.portfolio.api.Portfolio.models;

import com.portfolio.api.Portfolio.enumerations.StatusMessages;

import java.io.Serializable;

public class ResponseModel implements Serializable {

    private boolean status;

    private String statusMessage;

    private Object data;

    public ResponseModel(boolean status, String statusMessage, Object data) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public ResponseModel(boolean status) {
        this.status = status;
        if (status) {
            this.statusMessage = StatusMessages.SUCCESS.getStatusMessage();
        } else {
            this.statusMessage = StatusMessages.ERROR_OCCURRED.getStatusMessage();
        }
        this.data = null;
    }

    public ResponseModel(boolean status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.data = null;
    }

    public ResponseModel(Object data) {
        this.status = false;
        this.statusMessage = StatusMessages.SUCCESS.getStatusMessage();
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}