package com.restassured.tajawal.steps;

import com.restassured.tajawal.apicalls.ApiCalls;
import com.restassured.tajawal.dtos.createhotelsearch.response.CreateHotelResponseDTO;
import com.restassured.tajawal.dtos.retrievehotel.RetrieveHotelsResponseDTO;
import com.restassured.tajawal.dtos.createhotelsearch.request.CreateHotelRequestDTO;
import com.restassured.tajawal.endpoints.EndPoints;
import com.restassured.tajawal.utils.HeaderUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSteps<T extends BaseSteps<T>> {

    public Response             response;
    String                      endPoint;
    String                      payloadAsString;
    RetrieveHotelsResponseDTO   retrieveHotelsResponseDTO;
    CreateHotelRequestDTO       createHotelRequestDTO;
    CreateHotelResponseDTO      createHotelResponseDTO;

    @Autowired
    ApiCalls apiCalls;

    @Autowired
    EndPoints endPoints;

    @Autowired
    HeaderUtils headerUtils;
}
