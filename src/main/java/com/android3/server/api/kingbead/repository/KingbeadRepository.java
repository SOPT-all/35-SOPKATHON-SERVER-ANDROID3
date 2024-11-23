package com.android3.server.api.kingbead.repository;

import com.android3.server.api.bead.domain.Bead;
import com.android3.server.api.kingbead.domain.Kingbead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KingbeadRepository extends JpaRepository<Kingbead, Long> {
    long count();
}
