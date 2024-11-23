package com.android3.server.api.bead.repository;

import com.android3.server.api.bead.domain.Bead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeadRepository extends JpaRepository<Bead, Long> {
}
