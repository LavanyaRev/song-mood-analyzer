package com.project.moodanalyzer.service;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;
import com.project.moodanalyzer.util.AudioFeatures;
import com.project.moodanalyzer.util.MoodClassifier;
import org.springframework.stereotype.Service;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AudioAnalysisService {

    /**
     * Analyze an audio file and return extracted features.
     */
    public AudioFeatures analyzeAudio(File audioFile) throws IOException, UnsupportedAudioFileException {

        // Create dispatcher to read audio file
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromFile(audioFile, 1024, 512);

        // Store pitch values
        final List<Double> pitchList = new ArrayList<>();
        PitchDetectionHandler pitchHandler = (res, event) -> {
            if (res.getPitch() > 0) {
                pitchList.add((double)res.getPitch());
            }
        };
        dispatcher.addAudioProcessor(new PitchProcessor(
                PitchProcessor.PitchEstimationAlgorithm.YIN, 44100, 1024, pitchHandler));

        // Store energy values (RMS)
        final List<Double> energyList = new ArrayList<>();
        dispatcher.addAudioProcessor(new be.tarsos.dsp.AudioProcessor() {
            @Override
            public boolean process(be.tarsos.dsp.AudioEvent audioEvent) {
                float[] buffer = audioEvent.getFloatBuffer();
                double sum = 0.0;
                for (float sample : buffer) sum += sample * sample;
                energyList.add(Math.sqrt(sum / buffer.length)); // Double added to List<Double>
                return true;
            }

            @Override
            public void processingFinished() {
                // nothing to do
            }
        });


        // Run dispatcher synchronously
        dispatcher.run();

        // Calculate average pitch and energy
        double avgPitch = pitchList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double avgEnergy = energyList.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        // Placeholder BPM (replace with real BPM detection later)
        double bpm = calculateBPM(audioFile);

        return new AudioFeatures(bpm, avgPitch, avgEnergy);
    }

    /**
     * Dummy BPM calculation
     */
    private double calculateBPM(File audioFile) {
        return 120; // placeholder
    }

    /**
     * Classify mood using MoodClassifier
     */
    public String classifyMood(AudioFeatures features) {
        return MoodClassifier.classify(features);
    }
}
