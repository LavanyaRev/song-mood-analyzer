package com.project.moodanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mood_history")
public class MoodHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String mood;
    private Double bpm;
    private Double pitch;
    private Double energy;

    private LocalDateTime timestamp = LocalDateTime.now();
}
