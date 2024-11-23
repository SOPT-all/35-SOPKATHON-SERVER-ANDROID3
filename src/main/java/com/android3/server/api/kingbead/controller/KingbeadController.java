package com.android3.server.api.kingbead.controller;

import com.android3.server.api.kingbead.dto.KingbeadCreateDto;
import com.android3.server.api.kingbead.dto.KingbeadResponse;
import com.android3.server.api.kingbead.service.KingbeadService;
import com.android3.server.global.response.ApiResponseDto;
import com.android3.server.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/kingbeads")
    public ApiResponseDto<List<KingbeadResponse>> getKingbeads(@RequestHeader(name = "userId") Long userId){
        return ApiResponseDto.success(SuccessCode.GET_KINGBEADS_SUCCESS,kingbeadService.getKingbeads(userId));
    }
}
