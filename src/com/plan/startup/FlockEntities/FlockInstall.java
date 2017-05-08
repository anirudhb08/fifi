package com.plan.startup.FlockEntities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anirudh.b on 15/04/17.
 */
public class FlockInstall {
    @JsonProperty public String name;
    @JsonProperty public String userId;
    @JsonProperty public String token;
}
