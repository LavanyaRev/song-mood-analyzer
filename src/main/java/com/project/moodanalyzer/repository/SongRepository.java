package com.project.moodanalyzer.repository;

import com.project.moodanalyzer.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByUserId(Long userId);
}
