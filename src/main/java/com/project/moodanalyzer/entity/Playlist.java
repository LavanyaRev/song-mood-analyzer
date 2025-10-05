package com.project.moodanalyzer.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;   // e.g., "Energetic Mix"
    private String mood;   // e.g., "Happy", "Sad", "Calm"

    // Optional: Store song IDs as a list (not normalized, simple approach)
    @ElementCollection
    private List<Long> songIds;
}
