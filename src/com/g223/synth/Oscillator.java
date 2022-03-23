package com.g223.synth;

import com.g223.synth.utils.RefWrapper;
import com.g223.synth.utils.Utils;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


public class Oscillator extends SynthControlContainer {

    private static final int TONE_OFFSET_LIMIT = 2000;


    private Wavetable wavetable = Wavetable.Sine;
    private RefWrapper<Integer> toneOffset = new RefWrapper<>(0);
    private RefWrapper<Integer> volume = new RefWrapper<>(100);
    private double keyFrequency;
    private int wavetableStepSize;
    private int waveTableIndex;




    public Oscillator(SynthesizerRemastered synth) {
        super(synth);
        JComboBox<Wavetable> comboBox = new JComboBox<>(Wavetable.values());
        comboBox.setSelectedItem(Wavetable.Sine);
        comboBox.setBounds(10, 15, 80, 20);
        comboBox.addItemListener( l -> {

            if (l.getStateChange() == ItemEvent.SELECTED) {
                wavetable = (Wavetable) l.getItem();
            }
            synth.updateWaveviewer();

        } );
        add(comboBox);
        JLabel toneParameter = new JLabel("0.00");
        toneParameter.setBounds(80,60,40,20);
        toneParameter.setBorder(Utils.WindowDesign.LINE_BORDER);

        Utils.ParameterHandling.addParameterMouseListeners(toneParameter, this, -TONE_OFFSET_LIMIT, TONE_OFFSET_LIMIT, 1,toneOffset, () -> {
            applyToneOffset();
            toneParameter.setText("" + String.format("%.2f", getToneOffset()));
            synth.updateWaveviewer();


        });




        add(toneParameter);
        JLabel toneText = new JLabel("Pitch");
        toneText.setBounds(80,41,75,20);
        add(toneText);
        JLabel volumeParameter = new JLabel(" 100");
        volumeParameter.setBounds(10,60,58,20);
        volumeParameter.setBorder(Utils.WindowDesign.LINE_BORDER);
        Utils.ParameterHandling.addParameterMouseListeners(volumeParameter, this, 0, 100, 1, volume, () -> {
                     volumeParameter.setText(" " + volume.val + "");
                     synth.updateWaveviewer();



                });

        add(volumeParameter);
        JLabel volumeText = new JLabel( "Amplitude");
        volumeText.setBounds(11, 40, 75, 25);
        add(volumeText);
        JButton button = new JButton("Mute");
        button.setBounds(110, 15, 80, 20);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                volume.val = 0;
                volumeParameter.setText("0");
                synth.updateWaveviewer();
            }
        });
        add(button);
        setSize(279, 100);
        setBorder(Utils.WindowDesign.LINE_BORDER);
        setLayout(null);
    }

    public double getNextSample() {

        double sample = wavetable.getSamples()[waveTableIndex] * getVolumeMultiplier();
        waveTableIndex = (waveTableIndex + wavetableStepSize) % Wavetable.SIZE;
        return sample;

    }


    
    public void setKeyFrequency(double frequency)
    {
        keyFrequency =  frequency;
        applyToneOffset();
    }

    public double[] getSampleWaveform(int numSamples) {
        double[] samples = new double[numSamples];
        double frequency = 1.0 / (numSamples / (double)SynthesizerRemastered.AudioInfo.SAMPLE_RATE) * 4.0;
        int index = 0;
        int stepSize = (int)(Wavetable.SIZE * Utils.Math.offsetTone(frequency, getToneOffset()) / SynthesizerRemastered.AudioInfo.SAMPLE_RATE);
        for (int i = 0; i < numSamples; ++i) {
            samples[i] = wavetable.getSamples()[index] * getVolumeMultiplier();
            index = (index + stepSize) % Wavetable.SIZE;
        }
        return samples;
    }

    public double getToneOffset() {
        return toneOffset.val / 1000.0;
    }

    public double getVolumeMultiplier() {
        return volume.val / 100.0;
    }
            


    private void applyToneOffset() {
        wavetableStepSize = (int) (Wavetable.SIZE * Utils.Math.offsetTone(keyFrequency, getToneOffset()) / SynthesizerRemastered.AudioInfo.SAMPLE_RATE);
    }
}
