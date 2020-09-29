package com.restassured.tajawal.tests.createhotels;

import com.restassured.tajawal.dtos.createhotelsearch.request.CreateHotelRequestDTO;
import com.restassured.tajawal.dtos.createhotelsearch.request.Guest;
import com.restassured.tajawal.dtos.createhotelsearch.request.Room;
import com.restassured.tajawal.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Epic("Create Hotel ")
@Feature("Create Hotel ")
@DisplayName("Create hotel details - tests to verify Create hotel scenarios")
public class CreateHotelTest extends BaseTest {

    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("dataProvider")
    @DisplayName("should get success")
    void shouldGetSuccessForValidRequests(final String description, final CreateHotelRequestDTO createHotelRequestDTO) {
        createHotelSteps
                .givenIHaveCreateHotelEndPointAndPayload(createHotelRequestDTO)
                .whenICreateHotelRequest()
                .thenIVerifyResponseSuccessfully();
    }

    private static Stream<Arguments> dataProvider() {
        return  Stream.of(
                Arguments.of("should get success for one person",new CreateHotelRequestDTO()),
                Arguments.of("should get success for multiple persons",new CreateHotelRequestDTO()
                        .room(Collections.singletonList(new Room()
                                .guest(Arrays.asList(
                                        new Guest().type("ADT"),
                                        new Guest().type("ADT").age(30),
                                        new Guest().type("CHD").age(3)))))),
                Arguments.of("should get success for multiple rooms and multiple guests",new CreateHotelRequestDTO()
                        .room(Arrays.asList(
                                new Room()
                                        .guest(Arrays.asList(
                                                new Guest().type("ADT"),
                                                new Guest().type("ADT").age(30),
                                                new Guest().type("CHD").age(3))),
                                new Room()
                                        .guest(Arrays.asList(
                                                new Guest().type("ADT"),
                                                new Guest().type("ADT").age(25),
                                                new Guest().type("CHD").age(3))))
                        )));
    }
}
