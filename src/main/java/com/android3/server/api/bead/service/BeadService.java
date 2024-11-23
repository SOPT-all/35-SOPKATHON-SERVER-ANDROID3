package com.android3.server.api.bead.service;

import com.android3.server.api.bead.domain.Bead;
import com.android3.server.api.bead.dto.request.BeadCreateRequest;
import com.android3.server.api.bead.dto.response.BeadCreateResponse;
import com.android3.server.api.bead.dto.response.BeadGetReponse;
import com.android3.server.api.bead.repository.BeadRepository;
import com.android3.server.api.user.User;
import com.android3.server.api.user.repository.UserRepository;
import com.android3.server.global.exception.CustomException;
import com.android3.server.global.response.enums.ErrorCode;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeadService {
    private final BeadRepository beadRepository;
    private final UserRepository userRepository;

    public BeadCreateResponse createBead(Long userId, BeadCreateRequest beadCreateRequest){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        Bead bead = new Bead(user, beadCreateRequest.content1(), beadCreateRequest.content2(), false);
        beadRepository.save(bead);

        long count = beadRepository.count();
        if (count == 8){

        }
        return BeadCreateResponse.builder()
                .count(count)
                .build();
    }

    public BeadGetReponse getBead(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        List<Long> getIds = beadRepository.findAll()
                .stream().map(bead -> bead.getId())
                .toList();

        if(getIds.size() == 0){
            throw new CustomException(ErrorCode.NOT_FOUND);
        }

        Random rnd = new Random();

        Long randomId = getIds.get(rnd.nextInt(getIds.size()));

        Bead bead = beadRepository.findById(randomId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND)
        );

        return BeadGetReponse.builder()
                .beadId(randomId)
                .content1(bead.getContent1())
                .content2(bead.getContent2())
                .build();
    }
}
