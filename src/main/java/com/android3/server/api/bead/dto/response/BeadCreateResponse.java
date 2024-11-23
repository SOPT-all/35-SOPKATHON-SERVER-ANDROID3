package com.android3.server.api.bead.dto.response;

import lombok.Builder;

@Builder
public record BeadCreateResponse(
        long count
) {
}
