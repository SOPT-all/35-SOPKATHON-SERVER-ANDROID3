package com.android3.server.api.kingbead.service;

import com.android3.server.api.kingbead.domain.Kingbead;
import com.android3.server.api.kingbead.dto.KingbeadCreateDto;
import com.android3.server.api.kingbead.dto.KingbeadCreateResponse;
import com.android3.server.api.kingbead.dto.KingbeadGetResponse;
import com.android3.server.api.kingbead.repository.KingbeadRepository;
import com.android3.server.api.user.User;
import com.android3.server.api.user.repository.UserRepository;
import com.android3.server.global.exception.CustomException;
import com.android3.server.global.response.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KingbeadService {

    private final KingbeadRepository kingbeadRepository;
    private final UserRepository userRepository;

    public KingbeadCreateResponse createKingbead(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        Kingbead kingbead = new Kingbead(user);
        kingbeadRepository.save(kingbead);

        return KingbeadCreateResponse.builder()
                .count(kingbeadRepository.count())
                .build();
    }

    @Transactional(readOnly = true)
    public List<KingbeadGetResponse> getKingbeads(final Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        List<Kingbead> kingbeadList = kingbeadRepository.findAll();

        return kingbeadList.stream()
                .map(kingbead -> KingbeadGetResponse.builder()
                        .kingbeadId(kingbead.getId())
                        .imageUrl(kingbead.getImageUrl())
                        .build())
                .collect(Collectors.toList());
    }

}
