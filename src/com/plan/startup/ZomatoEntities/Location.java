package com.plan.startup.ZomatoEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh.b on 05/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty String entity_type;
    @JsonProperty String entity_id;
    @JsonProperty String title;
    @JsonProperty double latitude;
    @JsonProperty double longitude;
    @JsonProperty int city_id;
    @JsonProperty String city_name;
    @JsonProperty int country_id;
    @JsonProperty String country_name;
}
