package com.project.moodanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long songId;      // References Song.id
    private String mood;      // e.g., "Happy", "Sad", "Energetic"
    private Double confidence; // AI confidence score, e.g., 0.87

    @Column(length = 2000)
    private String summary;   // Optional description or feedback about the mood
}
