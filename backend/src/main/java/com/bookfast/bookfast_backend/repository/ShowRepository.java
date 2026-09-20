package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}