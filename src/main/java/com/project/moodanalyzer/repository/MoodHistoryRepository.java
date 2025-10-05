package com.project.moodanalyzer.repository;

import com.project.moodanalyzer.entity.MoodHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoodHistoryRepository extends JpaRepository<MoodHistory, Long> {
    List<MoodHistory> findByUserId(Long userId);
}
