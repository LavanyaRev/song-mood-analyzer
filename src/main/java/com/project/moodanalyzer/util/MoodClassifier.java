package com.project.moodanalyzer.util;

import com.project.moodanalyzer.util.AudioFeatures;

public class MoodClassifier {

    public static String classify(AudioFeatures features) {
        double bpm = features.getBpm();
        double energy = features.getEnergy();
        double pitch = features.getPitch();

        if (bpm > 120 && energy > 0.5) {
            return "Energetic";
        } else if (bpm >= 90 && bpm <= 120 && pitch > 150) {
            return "Happy";
        } else if (bpm < 90 && energy < 0.3) {
            return "Sad/Calm";
        } else {
            return "Neutral";
        }
    }
}
