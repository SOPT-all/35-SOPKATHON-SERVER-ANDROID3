package com.android3.server.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {
    //200 OK
    GET_SUCCESS(20000, HttpStatus.OK, "tt");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
