package com.restassured.tajawal.steps;

import com.restassured.tajawal.dtos.retrievehotel.RetrieveHotelsResponseDTO;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
public class RetrieveHotelSteps extends BaseSteps<RetrieveHotelSteps> {

    @Step
    public RetrieveHotelSteps givenIHaveRetrieveHotelEndpoint() {
        endPoint = endPoints.retrieveHotelServicePath();
        return this;
    }

    @Step
    public RetrieveHotelSteps whenIRetrieveHotelDetails(String queryParamName, String queryParamValue) {
        response = apiCalls.getHotels(endPoint,queryParamName,queryParamValue,headerUtils.getHeaders());
        return this;
    }

    @Step
    public RetrieveHotelSteps whenIRetrieveHotelDetailsWithInvalidHeader(String queryParamName, String queryParamValue, Headers headers) {
        response = apiCalls.getHotels(endPoint,queryParamName,queryParamValue,headers);
        return this;
    }

    @Step
    public RetrieveHotelSteps whenIRetrieveHotelDetailsWithInvalidMethod(String queryParamName, String queryParamValue) {
        response = apiCalls.deleteHotels(endPoint,queryParamName,queryParamValue);
        return this;
    }

    @Step
    public RetrieveHotelSteps thenIVerifyRetrieveHotelResponse() {
        verifyResponseStatusCode();
        retrieveHotelsResponseDTO = response.getBody().as(RetrieveHotelsResponseDTO.class);
        retrieveHotelsResponseDTO
                .hotels()
                .forEach(hotel -> {
                    assertAll(
                            ()-> assertNotNull(hotel.hotelId(),"verify hotel id"),
                            ()-> assertNotNull(hotel.name(),"verify hotel name"),
                            ()-> assertTrue(hotel.city().equals("Paris"),"verify hotel city"),
                            ()-> assertTrue(hotel.country().equals("France"),"verify hotel country"),
                            ()-> assertNotNull(hotel.thumbnailUrl(), "verify thumbnail url"),
                            ()-> assertTrue(hotel.displayType().equals("Hotel"),"verify hotel display type"),
                            ()-> assertNotNull(hotel.latitude(), "verify latitude"),
                            ()-> assertNotNull(hotel.longitude(),"verify longitude"),
                            ()-> assertNotNull(hotel.isActive(),"verify isActive")
                    );
                    });
        retrieveHotelsResponseDTO
                .locations()
                .forEach(location -> {
                    assertAll(
                            ()-> assertNotNull(location.name(),"verify location name"),
                            ()-> assertNotNull(location.placeId(),"verify place id"),
                            ()-> assertNotNull(location.source(),"verify location source"),
                            ()-> assertNotNull(location.country(),"verify location country"),
                            ()-> assertNotNull(location.city(),"verify location city"),
                            ()-> assertEquals("Location",location.displayType(),"verify location display type"),
                            ()-> assertNotNull(location.googleType().typeNameAR(),"verify typeNameAR"),
                            ()-> assertNotNull(location.googleType().typeNameEN(),"verify typeNameEN")
                    );
                });
        return this;
    }

    @Step
    public RetrieveHotelSteps thenIVerifyEmptyHotelResponse() {
        verifyResponseStatusCode();
        retrieveHotelsResponseDTO = response.getBody().as(RetrieveHotelsResponseDTO.class);
        assertTrue(retrieveHotelsResponseDTO.hotels().isEmpty(),"verify empty hotel list");
        assertTrue(retrieveHotelsResponseDTO.locations().isEmpty(),"verify empty location list");
        return this;
    }

    @Step
    public RetrieveHotelSteps thenIVerifyError(int httpStatus) {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertEquals(httpStatus,response.getStatusCode(),"Verify error status code");
        return this;
    }

    public RetrieveHotelSteps verifyResponseStatusCode() {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertNotNull(response);
        assertEquals(HttpStatus.SC_OK,response.getStatusCode(),"Verify response status code");
        assertTrue(response.contentType().equals("application/json"));
        return this;
    }
}
