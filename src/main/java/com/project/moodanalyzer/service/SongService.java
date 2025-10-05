package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.Song;
import com.project.moodanalyzer.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public List<Song> getUserSongs(Long userId) {
        return songRepository.findByUserId(userId);
    }
}
