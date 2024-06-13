package com.kupreychik.resumes.controller.rest;

import com.kupreychik.resumes.model.Block;
import com.kupreychik.resumes.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @GetMapping
    public List<Block> getAllBlocks() {
        return blockService.findAll();
    }

}
