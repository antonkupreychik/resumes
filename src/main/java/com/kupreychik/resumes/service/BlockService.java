package com.kupreychik.resumes.service;

import com.kupreychik.resumes.model.Block;
import com.kupreychik.resumes.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BlockService {

    private final BlockRepository blockRepository;

    public List<Block> findAll() {
        log.info("Finding all blocks");
        return blockRepository.findAll();
    }

    public Block save(Block block) {
        log.info("Saving block {}", block);
        return blockRepository.save(block);
    }

}
