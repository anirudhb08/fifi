package com.plan.startup.ZomatoEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by anirudh.b on 05/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse {
    @JsonProperty List<Restaurant> nearby_restaurants;
    @JsonProperty String link;
    @JsonProperty Location location;
}
