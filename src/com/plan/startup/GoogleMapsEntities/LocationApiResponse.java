package com.plan.startup.GoogleMapsEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by anirudh.b on 05/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationApiResponse {
    @JsonProperty List<LocationApiResult> results;
    @JsonProperty String status;

    public List<LocationApiResult> getResults() {
        return results;
    }

    public void setResults(List<LocationApiResult> results) {
        this.results = results;
    }
}
