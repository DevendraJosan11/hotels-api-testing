package com.restassured.tajawal.dtos.retrievehotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class GoogleType {

    @JsonProperty("TypeNameEN")
    private String typeNameEN;
    @JsonProperty("TypeNameAR")
    private String typeNameAR;

}
