package com.android3.server.api.kingbead.dto;

import lombok.Builder;

@Builder
public record KingbeadGetResponse(
        Long kingbeadId,
        String imageUrl
) {
}
