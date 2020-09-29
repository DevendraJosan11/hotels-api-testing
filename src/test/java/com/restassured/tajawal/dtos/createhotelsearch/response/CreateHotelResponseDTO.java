package com.restassured.tajawal.dtos.createhotelsearch.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class CreateHotelResponseDTO {

    @JsonProperty("type")
    private String type;
    @JsonProperty("query")
    private String query;
    @JsonProperty("queryParameters")
    private String queryParameters;
    @JsonProperty("queryParametersObj")
    private QueryParametersObj queryParametersObj;
    @JsonProperty("isCountry")
    private Boolean isCountry;

}