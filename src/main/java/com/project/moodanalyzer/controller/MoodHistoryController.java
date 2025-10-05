package com.project.moodanalyzer.controller;

import com.project.moodanalyzer.entity.Song;
import com.project.moodanalyzer.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mood-history")
public class MoodHistoryController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/{userId}")
    public Iterable<Song> getMoodHistory(@PathVariable Long userId) {
        return songRepository.findByUserId(userId);
    }
}
