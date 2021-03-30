package com.realtrade.tradeengine.dto;

public class Response {

    private int statusCode;
    private String message;
    private Object payload;

    public Response(int statusCode, String message, Object payload) {
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "{" +
                "statusCode:" + statusCode +
                ", message:'" + message + '\'' +
                ", payload:" + payload +
                '}';
    }
}

