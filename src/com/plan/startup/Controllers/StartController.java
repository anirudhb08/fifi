package com.plan.startup.Controllers;

import com.plan.startup.GoogleMapsEntities.LocationApiResponse;
import com.plan.startup.Services.GoogleMapsService;
import com.plan.startup.Services.ZomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anirudh.b on 04/02/17.
 */
@RestController
public class StartController {
    @Autowired ZomatoService zomatoService;
    @Autowired GoogleMapsService googleMapsService;

    @CrossOrigin
    @RequestMapping(value = "/getRestaurants", params = {"latitude","longitude"}, method = RequestMethod.GET)
    public String getRestaurantByLocation( @RequestParam(value="latitude")double latitude, @RequestParam(value="longitude")double longitude ) throws Exception {
        String locationResponse = zomatoService.getRestaurantsByLocation(latitude,longitude);
        return locationResponse;
    }

    @CrossOrigin
    @RequestMapping(value = "/getRestaurants", params = {"place"}, method = RequestMethod.GET)
    public String getRestaurantByPlaceName( @RequestParam(value="place")String place) throws Exception {
        LocationApiResponse locationResponse = googleMapsService.getLocationCoordinates(place);
        return locationResponse.toString();
    }


}