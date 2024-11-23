package com.android3.server.api.kingbead.controller;

import com.android3.server.api.kingbead.dto.KingbeadCreateDto;
import com.android3.server.api.kingbead.service.KingbeadService;
import com.android3.server.global.response.ApiResponseDto;
import com.android3.server.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KingbeadController {

    private final KingbeadService kingbeadService;

    @PostMapping("/kingbead")
    public ApiResponseDto createKingbead(@RequestHeader Long userId,
                                         @RequestBody KingbeadCreateDto kingbeadCreateDto) {
        kingbeadService.createKingbead(userId, kingbeadCreateDto);
        return ApiResponseDto.success(SuccessCode.KINGBEAD_CREATED_SUCCESS);
    }
}
