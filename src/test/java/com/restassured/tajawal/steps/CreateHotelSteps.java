package com.restassured.tajawal.steps;

import com.restassured.tajawal.dtos.createhotelsearch.request.CreateHotelRequestDTO;
import com.restassured.tajawal.dtos.createhotelsearch.response.CreateHotelResponseDTO;
import com.restassured.tajawal.utils.JsonUtil;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
public class CreateHotelSteps extends BaseSteps<CreateHotelSteps>{

    @Step
    public CreateHotelSteps givenIHaveCreateHotelEndPointAndPayload(CreateHotelRequestDTO payload) {
        endPoint = endPoints.createHotelServicePath();
        createHotelRequestDTO = payload;
        payloadAsString = JsonUtil.getJsonStringFromPojo(payload);
        log.info("-------payload---------" + payloadAsString);
        return this;
    }

    @Step
    public CreateHotelSteps whenICreateHotelRequest() {
        response = apiCalls.createHotels(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateHotelSteps whenICreateHotelRequestWithInvalidMethod() {
        response = apiCalls.createHotelsWithInvalidMethod(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateHotelSteps thenIVerifyResponseStatusCode() {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertNotNull(response);
        assertEquals(HttpStatus.SC_OK,response.getStatusCode(),"Verify response status code");
        assertTrue(response.contentType().equals("application/json"));
        return this;
    }

    @Step
    public CreateHotelSteps thenIVerifyResponseSuccessfully() {
        thenIVerifyResponseStatusCode();
        createHotelResponseDTO = response.getBody().as(CreateHotelResponseDTO.class);
        assertEquals("hotel",createHotelResponseDTO.type(),"verify type");
        assertNotNull(createHotelResponseDTO.query(),"verify query");
        assertTrue(createHotelResponseDTO.queryParameters().contains("placeId="+createHotelRequestDTO.placeId()),"verify presence of place id in query parameters");
        assertNotNull(createHotelResponseDTO.isCountry(),"verify country");
        assertAll(
                ()-> assertNotNull(createHotelResponseDTO.queryParametersObj().sortBy(),"verify sortBy"),
                ()-> assertNotNull(createHotelResponseDTO.queryParametersObj().isGeo(),"verify isGeo"),
                ()-> assertNotNull(createHotelResponseDTO.queryParametersObj().hId(), "verify hID"),
                ()-> assertNotNull(createHotelResponseDTO.queryParametersObj().isCountry(),"verify country"),
                ()-> assertEquals(createHotelRequestDTO.placeId(),createHotelResponseDTO.queryParametersObj().placeId(),"verify place id is same as payload "),
                ()-> assertNotNull(createHotelResponseDTO.queryParametersObj().types(),"verify types")
        );
        return this;
    }

    @Step
    public CreateHotelSteps thenIVerifyError(int httpStatus) {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertEquals(httpStatus,response.getStatusCode(),"Verify error status code");
        return this;
    }
}
