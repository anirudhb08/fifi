package com.plan.startup.Controllers;


import com.plan.startup.FlockEntities.FlockInstall;
import com.plan.startup.GoogleMapsEntities.LocationApiResponse;
import com.plan.startup.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.Resource;




/**
 * Created by anirudh.b on 04/02/17.
 */
@RestController
public class StartController {
    @Autowired ZomatoService zomatoService;
    @Autowired GoogleMapsService googleMapsService;
    @Autowired GaanaService gaanaService;
    @Autowired FlockService flockService;
    @Autowired SaavnService saavnService;
    @Autowired LinkedBlockingQueue<String> queue;
    Thread thread;

    @CrossOrigin
    @RequestMapping(value = "/getRestaurants", params = {"latitude","longitude"}, method = RequestMethod.GET)
    public String getRestaurantByLocation( @RequestParam(value="latitude")double latitude, @RequestParam(value="longitude")double longitude ) throws Exception {
        String restaurantsByLocation = zomatoService.getRestaurantsByLocation(latitude,longitude);
        return restaurantsByLocation;
    }

    @CrossOrigin
    @RequestMapping(value = "/getRestaurants", params = {"place"}, method = RequestMethod.GET)
    public String getRestaurantByPlaceName( @RequestParam(value="place")String place) throws Exception {
        LocationApiResponse locationResponse = googleMapsService.getLocationCoordinates(place);
        double latitude = locationResponse.getResults().get(0).getGeometry().getLocation().getLatitude();
        double longitude = locationResponse.getResults().get(0).getGeometry().getLocation().getLongitude();
        String restaurantsByLocation = zomatoService.getRestaurantsByLocation(latitude,longitude);
        return restaurantsByLocation;
    }

    @CrossOrigin
    @RequestMapping(value = "/addSong", params = {"name"}, method = RequestMethod.GET)
    public String addSong(@RequestParam(value="name")String songName) throws Exception {
        queue.add(songName);
        return "OK";
    }

    @CrossOrigin
    @RequestMapping(value = "/startServer",method = RequestMethod.GET)
    public String startSongServer() throws Exception {
        queue.clear();
        if(thread==null) {
            thread = new Thread(gaanaService);
            thread.start();
        } else{
            thread.interrupt();
        }
        return "Server up and running";
    }

    @CrossOrigin
    @RequestMapping(value = "/flockListener",method = RequestMethod.GET)
    public HttpResponseEntity<String> listen() throws Exception {
        flockService.checkLog();
        return (new HttpResponseEntity<String>("Done", HttpStatusMessage.OK));
    }

    @CrossOrigin
    @RequestMapping(value = "/getSaavnSong",method = RequestMethod.GET)
    public HttpResponseEntity<String> getSaavn() throws Exception {
        String s = saavnService.getCurrentSong();
        return (new HttpResponseEntity<String>(s, HttpStatusMessage.OK));
    }

    @CrossOrigin
    @RequestMapping(value = "/addSaavnSong",method = RequestMethod.GET)
    public HttpResponseEntity<String> addSaavn(@RequestParam(value="song") String url) throws Exception {
        saavnService.addSong(url);
        return (new HttpResponseEntity<String>("Ok", HttpStatusMessage.OK));
    }

    @CrossOrigin
    @RequestMapping(value = "/subscribe",method = RequestMethod.GET)
    public HttpResponseEntity<Integer> subscribeSaavn() throws Exception {
        int g = saavnService.subscribe();
        return (new HttpResponseEntity<Integer>(g, HttpStatusMessage.OK));
    }
}