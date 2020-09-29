package com.restassured.tajawal.dtos.createhotelsearch.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class Room {

    @JsonProperty("guest")
    public List<Guest> guest = Collections.singletonList(new Guest());

}
