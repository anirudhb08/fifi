package com.plan.startup.HttpRequest;

import java.net.Proxy;
import java.util.Map;

/**
 * Created by abhisheksin on 5/7/16.
 */
public class InBoundRequest {
    private String brokerURL;
    private String method;
    private String postData;
    private Proxy proxy;
    private Map<String, String> headers;
    private boolean https;

    public InBoundRequest(String brokerURL, String method, Proxy proxy, Map<String, String> headers) {
        this.brokerURL = brokerURL;
        this.method = method;
        this.proxy = proxy;
        this.headers = headers;
    }

    public boolean isHttps() {
        return https;
    }

    public void setHttps(boolean https) {
        this.https = https;
    }

    public String getBrokerURL() {
        return brokerURL;
    }

    public void setBrokerURL(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String toString(){
        StringBuilder request = new StringBuilder();
        String endl = "\n";
        request.append("Broker URL: ").append(brokerURL).append(endl);
        request.append("Headers: ").append(endl).append(headers.toString()).append(endl);
        request.append("Post Data: ").append(endl).append(postData).append(endl);
        return request.toString();
    }
}
