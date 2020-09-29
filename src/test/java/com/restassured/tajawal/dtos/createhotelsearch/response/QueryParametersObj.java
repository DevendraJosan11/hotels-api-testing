package com.restassured.tajawal.dtos.createhotelsearch.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class QueryParametersObj {

    @JsonProperty("sortBy")
    private String sortBy;
    @JsonProperty("isGeo")
    private Integer isGeo;
    @JsonProperty("hId")
    private String hId;
    @JsonProperty("isCountry")
    private String isCountry;
    @JsonProperty("placeId")
    private String placeId;
    @JsonProperty("types")
    private List<Object> types = null;

}
