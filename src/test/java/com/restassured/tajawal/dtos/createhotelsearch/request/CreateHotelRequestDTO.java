package com.restassured.tajawal.dtos.createhotelsearch.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class CreateHotelRequestDTO {

    @JsonProperty("dates")
    private Dates dates = new Dates();
    @JsonProperty("destination")
    private String destination = "paris";
    @JsonProperty("room")
    private List<Room> room = Collections.singletonList(new Room());
    @JsonProperty("placeId")
    private String placeId = "ChIJD7fiBh9u5kcRYJSMaMOCCwQ";

}
