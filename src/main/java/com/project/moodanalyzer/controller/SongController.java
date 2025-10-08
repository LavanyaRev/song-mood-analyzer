package com.project.moodanalyzer.controller;

import com.project.moodanalyzer.entity.Song;
import com.project.moodanalyzer.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    // Add a new song
    @PostMapping("/add")
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        Song saved = songService.addSong(song);
        return ResponseEntity.ok(saved);
    }

    // Get all songs
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    // Get song by ID
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Optional: get all songs uploaded by a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Song>> getSongsByUser(@PathVariable Long userId) {
        List<Song> songs = songService.getSongsByUser(userId);
        return ResponseEntity.ok(songs);
    }
}
