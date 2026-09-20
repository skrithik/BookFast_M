package com.bookfast.bookfast_backend.repository;

import com.bookfast.bookfast_backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}