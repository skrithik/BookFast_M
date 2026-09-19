package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}