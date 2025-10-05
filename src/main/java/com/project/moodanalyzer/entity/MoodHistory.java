package com.project.moodanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoodHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long songId;
    private Double bpm;
    private Double pitch;
    private Double energy;
    private String mood;

    private LocalDateTime uploadDate;
}
