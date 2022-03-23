package com.g223.synth;

import javax.swing.*;
import java.awt.*;

public class SynthControlContainer extends JPanel {


    protected boolean on;
    private SynthesizerRemastered synth;
    private Point mouseClickLocation;

    public SynthControlContainer(SynthesizerRemastered synth) {
        this.synth = synth;

    }

    public Point getMouseClickLocation() {
        return mouseClickLocation;
    }

    public void setMouseClickLocation(Point mouseClickLocation) {
        this.mouseClickLocation = mouseClickLocation;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public Component add(Component component) {

        component.addKeyListener(synth.getKeyAdapter());
        return super.add(component);

    }

    @Override
    public Component add(Component component, int index) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(component, index);
    }

    @Override
    public Component add(String name, Component component) {
        component.addKeyListener(synth.getKeyAdapter());
        return super.add(name, component);
    }

    @Override
    public void add(Component component, Object constraints) {
        component.addKeyListener(synth.getKeyAdapter());
        super.add(component, constraints);

    }

    @Override
    public void add(Component component, Object constraints, int index) {
        component.addKeyListener(synth.getKeyAdapter());
        super.add(component, constraints, index);

    }
}
