package com.project.moodanalyzer.repository;

import com.project.moodanalyzer.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByMood(String mood);
}
