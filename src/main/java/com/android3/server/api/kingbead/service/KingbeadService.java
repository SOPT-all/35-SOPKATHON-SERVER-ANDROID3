package com.android3.server.api.kingbead.service;

import com.android3.server.api.kingbead.domain.Kingbead;
import com.android3.server.api.kingbead.dto.KingbeadCreateDto;
import com.android3.server.api.kingbead.repository.KingbeadRepository;
import com.android3.server.api.user.User;
import com.android3.server.api.user.repository.UserRepository;
import com.android3.server.global.exception.CustomException;
import com.android3.server.global.response.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KingbeadService {

    private final KingbeadRepository kingbeadRepository;
    private final UserRepository userRepository;

    public void createKingbead(Long userId, KingbeadCreateDto kingbeadCreateDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        Kingbead kingbead = new Kingbead(user, kingbeadCreateDto.imageUrl());
        kingbeadRepository.save(kingbead);
    }

}
