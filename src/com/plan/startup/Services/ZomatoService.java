package com.plan.startup.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plan.startup.HttpRequest.InBoundRequest;
import com.plan.startup.HttpRequest.Response;
import com.plan.startup.Utils.UtilityMethods;
import com.plan.startup.ZomatoEntities.Location;
import com.plan.startup.ZomatoEntities.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anirudh.b on 05/02/17.
 */
@Service
public class ZomatoService {
    @Autowired
    ObjectMapper objectMapper;

    public String getRestaurantsByLocation(double latitude,double longitude) throws Exception{
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        headers.put("user-key","7a8269fc6b31253c0d8ba3ae96e98e5a");
        InBoundRequest inBoundRequest = new InBoundRequest("developers.zomato.com/api/v2.1/geocode?lat="+latitude+"&lon="+longitude,"GET",null,headers);
        Response response = UtilityMethods.getResponseOKClient(inBoundRequest,5000,5000);
        LocationResponse locationResponse = objectMapper.readValue(response.getRawResponse(),LocationResponse.class);
        String restaurants = objectMapper.writeValueAsString(locationResponse);
        return restaurants;
    }
}
