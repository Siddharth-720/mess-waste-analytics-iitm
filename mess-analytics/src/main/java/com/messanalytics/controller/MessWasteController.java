package com.messanalytics.controller;

import com.messanalytics.model.MessWaste;
import com.messanalytics.repository.MessWasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste")
public class MessWasteController {

    @Autowired
    private MessWasteRepository repository;

    // This URL will show all your waste records in the browser
    @GetMapping
    public List<MessWaste> getAllWaste() {
        return repository.findAll();
    }

    // This is for saving a new record (we will use this in Day 2)
    @PostMapping
    public MessWaste addWaste(@RequestBody MessWaste waste) {
        return repository.save(waste);
    }
}