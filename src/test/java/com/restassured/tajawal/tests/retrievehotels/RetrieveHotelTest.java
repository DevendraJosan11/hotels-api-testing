package com.restassured.tajawal.tests.retrievehotels;

import com.restassured.tajawal.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Retrieve Hotel Details")
@Feature("Retrieve Hotel Details")
@DisplayName("Retrieve hotel details - tests to verify retrieve hotel details")
public class RetrieveHotelTest extends BaseTest {

    @Test
    @DisplayName("should get hotel details for Paris")
    void shouldRetrieveHotelDetailsSuccessfully() {
        retrieveHotelSteps
                .givenIHaveRetrieveHotelEndpoint()
                .whenIRetrieveHotelDetails("query","paris")
                .thenIVerifyRetrieveHotelResponse();
    }

    @Test
    @DisplayName("should get empty list of hotel and locations without query param")
    void shouldGetEmptyHotelList() {
        retrieveHotelSteps
                .givenIHaveRetrieveHotelEndpoint()
                .whenIRetrieveHotelDetails("query","")
                .thenIVerifyEmptyHotelResponse();
    }
}
