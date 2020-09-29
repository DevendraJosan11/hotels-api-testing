package com.restassured.tajawal.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class EndPoints {

    @Value("${getHotelURI}")
    private String getHotelURI;

    @Value("${createHotelURI}")
    private String createHotelURI;

    public String retrieveHotelServicePath() {
        return getHotelURI;
    }

    public String createHotelServicePath() {
        return createHotelURI;
    }

}
