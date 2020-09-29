package com.restassured.tajawal.utils;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class RestUtils {

    @Autowired
    HeaderUtils headerUtils;

    public Response get (String endPointUrl, String queryParamName, String queryParamValue, Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .queryParam(queryParamName,queryParamValue)
                .get(endPointUrl);
    }

    public Response post (String endPointUrl,String payload,Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .body(payload)
                .post(endPointUrl);
    }

    public Response put (String endPointUrl,String payload,Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .body(payload)
                .put(endPointUrl);
    }

    public Response delete(String endPointUrl,String queryParamName, String queryParamValue) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headerUtils.getHeaders())
                .queryParam(queryParamName,queryParamValue)
                .log()
                .all()
                .delete(endPointUrl);
    }
}
