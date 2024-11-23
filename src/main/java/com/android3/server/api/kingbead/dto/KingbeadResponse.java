package com.android3.server.api.kingbead.dto;

import lombok.Builder;

@Builder
public record KingbeadResponse(
        Long kingbeadId,
        String imageUrl
) {
}
