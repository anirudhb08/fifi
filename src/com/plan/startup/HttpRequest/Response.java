package com.plan.startup.HttpRequest;

/**
 * Created by abhisheksin on 5/7/16.
 */
public class Response {
    private String rawResponse;
    private boolean timeout;

    public Response() {
    }

    public Response(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRawResponse() {
        return rawResponse;
    }

    public void setRawResponse(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public boolean isTimeout() {
        return timeout;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }
}
