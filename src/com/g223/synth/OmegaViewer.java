package com.g223.synth;

import com.g223.synth.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class OmegaViewer extends JPanel {
    double[] amplitudes = new double[4];
    double[] pitches = new double[4];


    public OmegaViewer() {
        for(int i = 0; i < 4; i++){
            amplitudes[i] = 100;
            pitches[i] = 200;
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.drawRect(0, 0, 420, 90);
        graphics2D.drawLine(10, 60, 410, 60);
        for(int i = 0; i < 4; i++){
            graphics2D.drawLine((int) (pitches[i] + 10), (int) ((50 - amplitudes[i] / 2.0) + 10), (int) (pitches[i] + 10), 50 + 10);
        }

    }

    public void updateValues(double[] amplitudesInput, double[] pitchesInput){
        for(int i = 0; i < 4; i++){
            amplitudes[i] = amplitudesInput[i];
            pitches[i] = pitchesInput[i] / 10 + 200;
        }
    }
}