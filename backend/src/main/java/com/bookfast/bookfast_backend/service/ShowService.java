package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.entity.Show;
import com.bookfast.bookfast_backend.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Optional<Show> getShowById(Long id) {
        return showRepository.findById(id);
    }
}