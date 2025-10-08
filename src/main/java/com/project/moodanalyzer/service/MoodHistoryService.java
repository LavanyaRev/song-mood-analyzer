package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.MoodHistory;
import com.project.moodanalyzer.repository.MoodHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoodHistoryService {

    private final MoodHistoryRepository moodHistoryRepository;

    // Save a new mood entry
    public MoodHistory saveMood(MoodHistory moodHistory) {
        return moodHistoryRepository.save(moodHistory);
    }

    // Get all mood history for a user
    public List<MoodHistory> getMoodHistoryByUser(Long userId) {
        return moodHistoryRepository.findByUserIdOrderByTimestampDesc(userId);
    }
}
