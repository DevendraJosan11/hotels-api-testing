package com.restassured.tajawal.apicalls;

import com.restassured.tajawal.utils.RestUtils;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiCalls {

    @Autowired
    RestUtils restUtils;

    public Response getHotels(String endPointUrl, String queryParamName, String queryParamValue, Headers headers) {
        return restUtils.get(endPointUrl, queryParamName, queryParamValue, headers);
    }

    public Response deleteHotels(String endPointUrl, String queryParamName, String queryParamValue) {
        return restUtils.delete(endPointUrl, queryParamName, queryParamValue);
    }

    public Response createHotels(String endPointUrl, String payload, Headers headers) {
        return restUtils.post(endPointUrl, payload, headers);
    }

    public Response createHotelsWithInvalidMethod(String endPointUrl, String payload, Headers headers) {
        return restUtils.put(endPointUrl, payload, headers);
    }
}
