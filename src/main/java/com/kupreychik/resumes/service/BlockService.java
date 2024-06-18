package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Block;
import com.kupreychik.resumes.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;

    /**
     * @param department
     * @return
     */
    public List<Block> findAll(String department) {
        log.info("Finding all blocks");
        if (department == null) {
            return blockRepository.findAll();
        } else {
            return blockRepository.findAllByDepartament(department);
        }
    }
}
