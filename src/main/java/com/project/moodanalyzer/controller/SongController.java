package com.project.moodanalyzer.controller;

import com.project.moodanalyzer.entity.Song;
import com.project.moodanalyzer.repository.SongRepository;
import com.project.moodanalyzer.service.AudioAnalysisService;
import com.project.moodanalyzer.util.AudioFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private AudioAnalysisService audioAnalysisService;

    @Autowired
    private SongRepository songRepository;

    @PostMapping("/upload")
    public Song uploadSong(@RequestParam Long userId,
                           @RequestParam MultipartFile file) throws IOException, UnsupportedAudioFileException {
        // Save file temporarily
        File tempFile = File.createTempFile("upload-", file.getOriginalFilename());
        file.transferTo(tempFile);

        // Analyze audio
        AudioFeatures features = audioAnalysisService.analyzeAudio(tempFile);
        String mood = audioAnalysisService.classifyMood(features);

        // Save in DB
        Song song = new Song();
        song.setUserId(userId);
        song.setFilePath(tempFile.getAbsolutePath());
        song.setBpm(features.getBpm());
        song.setPitch(features.getPitch());
        song.setEnergy(features.getEnergy());
        song.setMood(mood);

        return songRepository.save(song);
    }

    @GetMapping("/{userId}")
    public Iterable<Song> getUserSongs(@PathVariable Long userId) {
        return songRepository.findByUserId(userId);
    }
}
