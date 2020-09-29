package com.restassured.tajawal.tests.createhotels;

import com.restassured.tajawal.dtos.createhotelsearch.request.CreateHotelRequestDTO;
import com.restassured.tajawal.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Create Hotel ")
@Feature("Create Hotel ")
@DisplayName("Create hotel details - tests to verify Create hotel negative scenarios")
public class CreateHotelErrorTest extends BaseTest {

    @Test
    @DisplayName("should get valid error message for invalid method")
    void shouldGetValidErrorMessageForInvalidMethod() {
        createHotelSteps
                .givenIHaveCreateHotelEndPointAndPayload(new CreateHotelRequestDTO())
                .whenICreateHotelRequestWithInvalidMethod()
                .thenIVerifyError(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }
}
