package com.project.moodanalyzer.controller;

import com.project.moodanalyzer.entity.Playlist;
import com.project.moodanalyzer.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    public Iterable<Playlist> getPlaylistsByMood(@RequestParam String mood) {
        return playlistRepository.findByMood(mood);
    }

    @PostMapping("/save")
    public Playlist savePlaylist(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
