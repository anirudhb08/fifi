package com.plan.startup.Utils;

import com.plan.startup.HttpRequest.InBoundRequest;
import com.plan.startup.HttpRequest.Response;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by anirudh.b on 05/02/17.
 */
public class UtilityMethods {
    public static Response getResponseOKClient(InBoundRequest inBoundRequest, int connectTimeOut, int responseTimeOut) throws Exception {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(connectTimeOut, TimeUnit.MILLISECONDS);
        client.setReadTimeout(responseTimeOut, TimeUnit.MILLISECONDS);
        String protocol = "http://";
        if(inBoundRequest.isHttps()){
            protocol = "https://";
        }
        String url = protocol + inBoundRequest.getBrokerURL();
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        if(inBoundRequest.getMethod().equals("POST")) {
            String mediaTypeStr = "application/json";
            if(inBoundRequest.getHeaders().get("Content-type") != null){
                mediaTypeStr = inBoundRequest.getHeaders().get("Content-type");
            }
            MediaType mediaType = MediaType.parse(mediaTypeStr);
            RequestBody body = RequestBody.create(mediaType, inBoundRequest.getPostData());
            requestBuilder.method(inBoundRequest.getMethod(), body);
        }
        for (String headers: inBoundRequest.getHeaders().keySet()) {
            requestBuilder.header(headers, inBoundRequest.getHeaders().get(headers));
        }
        com.squareup.okhttp.Response response = client.newCall(requestBuilder.build()).execute();
        if(response.code() == 200) {
            return new Response(response.body().string());
        }else{
            throw new Exception("API response error code: " + response.code());
        }
    }
}
