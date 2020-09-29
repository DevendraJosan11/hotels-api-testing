package com.restassured.tajawal.dtos.retrievehotel;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class Hotel {

    @JsonProperty("hotelId")
    private Integer hotelId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("displayType")
    private String displayType;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("isActive")
    private Integer isActive;

}
