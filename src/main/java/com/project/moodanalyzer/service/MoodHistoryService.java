package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.MoodHistory;
import com.project.moodanalyzer.repository.MoodHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MoodHistoryService {

    @Autowired
    private MoodHistoryRepository moodHistoryRepository;

    public MoodHistory saveHistory(MoodHistory history) {
        return moodHistoryRepository.save(history);
    }

    public List<MoodHistory> getUserHistory(Long userId) {
        return moodHistoryRepository.findByUserId(userId);
    }
}
