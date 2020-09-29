package com.restassured.tajawal.dtos.retrievehotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class Location {

    @JsonProperty("name")
    private String name;
    @JsonProperty("placeId")
    private String placeId;
    @JsonProperty("source")
    private String source;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("displayType")
    private String displayType;
    @JsonProperty("googleType")
    private GoogleType googleType;

}
