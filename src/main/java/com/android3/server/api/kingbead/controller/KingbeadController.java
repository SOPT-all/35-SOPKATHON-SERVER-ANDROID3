package com.android3.server.api.kingbead.controller;

import com.android3.server.api.kingbead.dto.KingbeadCreateDto;
import com.android3.server.api.kingbead.dto.KingbeadGetResponse;
import com.android3.server.api.kingbead.service.KingbeadService;
import com.android3.server.global.response.ApiResponseDto;
import com.android3.server.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KingbeadController {

    private final KingbeadService kingbeadService;

    @PostMapping("/kingbead")
    public ApiResponseDto createKingbead(@RequestHeader Long userId) {
        return ApiResponseDto.success(SuccessCode.KINGBEAD_CREATED_SUCCESS, kingbeadService.createKingbead(userId));
    }

    @GetMapping("/kingbeads")
    public ApiResponseDto<List<KingbeadGetResponse>> getKingbeads(@RequestHeader(name = "userId") Long userId){
        return ApiResponseDto.success(SuccessCode.GET_KINGBEADS_SUCCESS,kingbeadService.getKingbeads(userId));
    }
}
