package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.Song;
import com.project.moodanalyzer.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    // Add a new song
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    // Get all songs
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // Get song by ID
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    // Get all songs uploaded by a user
    public List<Song> getSongsByUser(Long userId) {
        return songRepository.findByUserId(userId);
    }
}
