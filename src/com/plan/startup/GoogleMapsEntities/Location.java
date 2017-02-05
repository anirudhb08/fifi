package com.plan.startup.GoogleMapsEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh.b on 05/02/17.
 */

public class Location {
    @JsonProperty(value = "lat") double latitude;
    @JsonProperty(value = "lng") double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
