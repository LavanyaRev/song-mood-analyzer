package com.project.moodanalyzer.controller;

import com.project.moodanalyzer.entity.MoodHistory;
import com.project.moodanalyzer.service.MoodHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood-history")
@RequiredArgsConstructor
public class MoodHistoryController {

    private final MoodHistoryService moodHistoryService;

    // Save a new mood entry
    @PostMapping("/save")
    public ResponseEntity<MoodHistory> saveMood(@RequestBody MoodHistory moodHistory) {
        MoodHistory saved = moodHistoryService.saveMood(moodHistory);
        return ResponseEntity.ok(saved);
    }

    // Get all mood history for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MoodHistory>> getMoodHistory(@PathVariable Long userId) {
        List<MoodHistory> history = moodHistoryService.getMoodHistoryByUser(userId);
        return ResponseEntity.ok(history);
    }
}
