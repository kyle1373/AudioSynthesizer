package com.g223.synth;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Visualizer extends JPanel{
    private String keys = "qwertyuiop[]";
    private boolean[] pressed = new boolean[12];
    private boolean onePressed;

    public Visualizer(){
        // Do nothing
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    
        final int LENGTHWIDTH = 54;
        Color Brown = new Color(0, 0, 24);
        Color LightBrown = new Color(0, 128, 174);
        for(int i = 0; i < keys.length(); i++){
            g.setColor(pressed[i] ? Color.YELLOW : LightBrown);
            g.fillRect(i * LENGTHWIDTH, 0, LENGTHWIDTH, LENGTHWIDTH);
            g.setColor(Brown);
            g.drawRect(i * LENGTHWIDTH, 0, LENGTHWIDTH, LENGTHWIDTH);
            g.drawString(" " + Character.toLowerCase(keys.charAt(i)), i * LENGTHWIDTH + 23, LENGTHWIDTH - 23);
        }
    }

    public void enableKey(char e){
        for(int i = 0; i < keys.length(); i++){
            if(keys.charAt(i) == e){
                break;
            }
            if(i == keys.length() - 1){
                return;
            }
        }
        if(onePressed){
            return;
        }
        pressed[keys.indexOf(e)] = true;
        onePressed = true;
        repaint();
    }

    public void disableKey(char e){
        for(int i = 0; i < keys.length(); i++){
            if(keys.charAt(i) == e){
                break;
            }
            if(i == keys.length() - 1){
                return;
            }
        }
        onePressed = false;
        pressed[keys.indexOf(e)] = false;
        repaint();
    }
}
