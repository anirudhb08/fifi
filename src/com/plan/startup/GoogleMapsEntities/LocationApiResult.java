package com.plan.startup.GoogleMapsEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh.b on 05/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationApiResult {
    @JsonProperty Geometry geometry;
    @JsonProperty String formatted_address;
}
