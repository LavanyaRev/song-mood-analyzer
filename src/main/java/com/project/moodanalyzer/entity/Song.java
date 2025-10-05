package com.project.moodanalyzer.entity;  // 👈 adjust if your folder name differs

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String filePath;
    private Double bpm;
    private Double pitch;
    private Double energy;
    private String mood;
}

