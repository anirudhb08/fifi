package com.plan.startup.Controllers;

import com.plan.startup.Services.ZomatoService;
import com.plan.startup.ZomatoEntities.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anirudh.b on 04/02/17.
 */
@RestController
public class StartController {
    @Autowired ZomatoService zomatoService;

    @CrossOrigin
    @RequestMapping(value = "/test", params = {"latitude","longitude"}, method = RequestMethod.GET)
    public String getRestaurantByLocation( @RequestParam(value="latitude")double latitude, @RequestParam(value="longitude")double longitude ) throws Exception {
        String locationResponse = zomatoService.getRestaurantsByLocation(latitude,longitude);
        return locationResponse;
    }
}