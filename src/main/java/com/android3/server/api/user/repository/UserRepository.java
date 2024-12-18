package com.android3.server.api.user.repository;

import com.android3.server.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
