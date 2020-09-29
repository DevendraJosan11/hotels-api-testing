package com.restassured.tajawal.dtos.createhotelsearch.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class Dates {

    @JsonProperty("checkin")
    public String checkin = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    @JsonProperty("checkout")
    public String checkout = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

}
