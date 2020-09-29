package com.restassured.tajawal.dtos.createhotelsearch.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class Guest {

    @JsonProperty("type")
    private String type = "ADT";
    @JsonProperty("age")
    private Integer age = 35;

}
