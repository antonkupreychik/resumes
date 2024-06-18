package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Level;
import com.kupreychik.resumes.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LevelService {

    private final LevelRepository levelRepository;

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
}
