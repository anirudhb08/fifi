package com.plan.startup.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plan.startup.GoogleMapsEntities.LocationApiResponse;
import com.plan.startup.HttpRequest.InBoundRequest;
import com.plan.startup.HttpRequest.Response;
import com.plan.startup.Utils.UtilityMethods;
import com.plan.startup.ZomatoEntities.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anirudh.b on 05/02/17.
 */
@Service
public class GoogleMapsService {
    @Autowired ObjectMapper objectMapper;

    public LocationApiResponse getLocationCoordinates(String name) throws Exception{
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-type", "application/json");
        InBoundRequest inBoundRequest = new InBoundRequest("maps.googleapis.com/maps/api/geocode/json?address="+name+"&key=AIzaSyDO2WJM-zqukMkchXsyV42EQ6gvB2Xgv4k","GET",null,headers);
        inBoundRequest.setHttps(true);
        Response response = UtilityMethods.getResponseOKClient(inBoundRequest,5000,5000);
        LocationApiResponse locationApiResponse = objectMapper.readValue(response.getRawResponse(),LocationApiResponse.class);
        return locationApiResponse;
    }

}
