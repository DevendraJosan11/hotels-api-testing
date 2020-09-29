package com.restassured.tajawal.dtos.retrievehotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class RetrieveHotelsResponseDTO {

    @JsonProperty("hotels")
    private List<Hotel> hotels;

    @JsonProperty("locations")
    private List<Location> locations = null;

}
