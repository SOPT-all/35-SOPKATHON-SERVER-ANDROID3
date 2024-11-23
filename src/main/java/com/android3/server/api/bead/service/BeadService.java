package com.android3.server.api.bead.service;

import com.android3.server.api.bead.domain.Bead;
import com.android3.server.api.bead.dto.request.BeadCreateRequest;
import com.android3.server.api.bead.repository.BeadRepository;
import com.android3.server.api.user.User;
import com.android3.server.api.user.repository.UserRepository;
import com.android3.server.global.exception.CustomException;
import com.android3.server.global.response.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeadService {
    private final BeadRepository beadRepository;
    private final UserRepository userRepository;

    public void createBead(Long userId, BeadCreateRequest beadCreateRequest){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        Bead bead = new Bead(user, beadCreateRequest.content());
        beadRepository.save(bead);
    }
}
