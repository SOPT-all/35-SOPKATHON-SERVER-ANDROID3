package com.android3.server.api.bead.controller;

import com.android3.server.api.bead.dto.request.BeadCreateRequest;
import com.android3.server.api.bead.service.BeadService;
import com.android3.server.global.response.ApiResponseDto;
import com.android3.server.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BeadController {

    private final BeadService beadService;

    @PostMapping("/bead")
    public ApiResponseDto createBead(
            @RequestHeader(name="userId") final Long userId,
            @RequestBody final BeadCreateRequest beadCreateRequest
            ) {

        beadService.createBead(userId, beadCreateRequest);
        return ApiResponseDto.success(SuccessCode.BEAD_CREATE_SUCCESS);

    }
}
