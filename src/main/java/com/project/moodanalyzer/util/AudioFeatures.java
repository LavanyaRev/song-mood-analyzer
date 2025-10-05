package com.project.moodanalyzer.util;

public class AudioFeatures {
    private double bpm;
    private double pitch;
    private double energy;

    public AudioFeatures(double bpm, double pitch, double energy) {
        this.bpm = bpm;
        this.pitch = pitch;
        this.energy = energy;
    }

    public double getBpm() { return bpm; }
    public double getPitch() { return pitch; }
    public double getEnergy() { return energy; }
}
