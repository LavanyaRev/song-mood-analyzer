package com.project.moodanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;
    private String artist;

    private Double bpm;
    private Double pitch;
    private Double energy;

    private String mood;

    private String filePath;
}
