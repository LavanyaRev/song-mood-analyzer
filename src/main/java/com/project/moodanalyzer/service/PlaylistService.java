package com.project.moodanalyzer.service;

import com.project.moodanalyzer.entity.Playlist;
import com.project.moodanalyzer.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getPlaylistsByMood(String mood) {
        return playlistRepository.findByMood(mood);
    }

    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
