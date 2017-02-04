package com.plan.startup.ZomatoEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh.b on 05/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantData {
    @JsonProperty String apikey;
    @JsonProperty String id;
    @JsonProperty String name;
    @JsonProperty String url;
    @JsonProperty String thumb;
    @JsonProperty String photos_url;
    @JsonProperty String menu_url;
    @JsonProperty String featured_image;
    @JsonProperty String has_online_delivery;
    @JsonProperty String is_delivering_now;
    @JsonProperty String deeplink;
    @JsonProperty String has_table_booking;
    @JsonProperty String events_url;

}
