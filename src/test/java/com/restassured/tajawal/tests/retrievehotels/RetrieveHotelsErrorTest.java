package com.restassured.tajawal.tests.retrievehotels;

import com.restassured.tajawal.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@Epic("Retrieve Hotel Details")
@Feature("Retrieve Hotel Details")
@DisplayName("Retrieve hotel details - tests to verify retrieve hotel error scenarios")
public class RetrieveHotelsErrorTest extends BaseTest {

    @Test
    @DisplayName("should get error for invalid method")
    void shouldGetErrorForInvalidMethod() {
        retrieveHotelSteps
                .givenIHaveRetrieveHotelEndpoint()
                .whenIRetrieveHotelDetailsWithInvalidMethod("query","paris")
                .thenIVerifyError(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }

    //@Disabled("Service should throw bad request error in case of invalid header or empty header value")
    @ValueSource(strings = {"application/xml","application/javascript"})
    @NullAndEmptySource
    @DisplayName("should get valid error for invalid header")
    void shouldGetErrorForInvalidHeader(String headerValue) {
        retrieveHotelSteps
                .givenIHaveRetrieveHotelEndpoint()
                .whenIRetrieveHotelDetailsWithInvalidHeader("query","paris",
                        headerUtils.modifyHeaderAndGetHeader("Content-Type",headerValue))
                .thenIVerifyError(HttpStatus.SC_BAD_REQUEST);
    }

    @ParameterizedTest
    @DisplayName("should get empty hotel list for invalid query params values")
    @ValueSource(strings = {"@@#$","adae123131xzxsdd"})
    @NullAndEmptySource
    void shouldGetErrorForInvalidQueryParams(String queryParamValue) {
        retrieveHotelSteps
                .givenIHaveRetrieveHotelEndpoint()
                .whenIRetrieveHotelDetails("query",queryParamValue)
                .thenIVerifyEmptyHotelResponse();
    }

}
