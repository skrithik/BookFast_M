package com.bookfast.bookfast_backend.service;

import com.bookfast.bookfast_backend.entity.Screen;
import com.bookfast.bookfast_backend.repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public Optional<Screen> getScreenById(Long id) {
        return screenRepository.findById(id);
    }
}