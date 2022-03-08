import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This class had a lot of help with this reference guide:
 * (https://docs.oracle.com/javase/tutorial/sound/MIDI-synth.html)
 */
public class PianoKeys extends JPanel implements KeyListener {
    
    // Setting up the environment, like the Synthesizer and audio channels
    private Synthesizer piano;
    private MidiChannel channel;
    
    // Array of black and white keys
    private String blackKeys = "SD GHJ L;";
    private String whiteKeys = "ZXCVBNM,./";
    private String allKeys = "ZSXDCVGBHNJM,L.;/";
    
    private int octave = 5; // starts at middle C
    private boolean[] keyOn = new boolean[allKeys.length()];
    private static final int KEYS_PER_OCTAVE = 12;
    
    public PianoKeys() {
        addKeyListener(this);
        startPiano();
    }

    private void startPiano()  {
        try {
            piano = MidiSystem.getSynthesizer();
            piano.open();
            channel = piano.getChannels()[0];
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(50, 50);

        g.drawString("Due to keyboard rollover limitations on certain computers,", 0, -45);
        g.drawString("pressing 3 or more keys may lead to inaccurate keyboard", 0 , -30);
        g.drawString("inputs. However, 2 or fewer keys should workperfectly fine." , 0, -15);
        g.drawString("Enjoy! -Kyle", 0, 0);
        
        // draw white keys
        final int WHITE_KEY_WIDTH = 30;
        final int WHITE_KEY_HEIGHT = 60;
        Color Brown = new Color(124, 66, 0);
        Color LightBrown = new Color(255, 218, 174);
        for (int k = 0; k < whiteKeys.length(); k++) {
            g.setColor(keyOn[allKeys.indexOf(whiteKeys.charAt(k))] ? Color.YELLOW : LightBrown);
            g.fillRect(k * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_HEIGHT);
            g.setColor(Brown);
            g.drawRect(k * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_HEIGHT);
            g.drawString(" " + Character.toLowerCase(whiteKeys.charAt(k)), k * WHITE_KEY_WIDTH + 10, WHITE_KEY_HEIGHT - 10);
        }

        // draw black keys
        final int BLACK_KEY_WIDTH = (int) (WHITE_KEY_WIDTH / 1.8);
        final int BLACK_KEY_HEIGHT = (int) (WHITE_KEY_HEIGHT / 2);
        for (int k = 0; k < blackKeys.length(); k++) {
            if (blackKeys.charAt(k) == ' ') {
                continue;
            }
            int x = (k + 1) * WHITE_KEY_WIDTH - BLACK_KEY_WIDTH / 2;
            g.setColor(keyOn[allKeys.indexOf(blackKeys.charAt(k))] ? Color.YELLOW : Brown);
            g.fillRect(x, 1, BLACK_KEY_WIDTH, BLACK_KEY_HEIGHT);
            g.setColor(LightBrown);
            g.drawRect(x, 1, BLACK_KEY_WIDTH, BLACK_KEY_HEIGHT);
            g.drawString(" " + Character.toLowerCase(blackKeys.charAt(k)), x + 2, BLACK_KEY_HEIGHT - 5);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        repaint();
        
        // select octave using 0~8 keys
        if ("012345678".contains("" + e.getKeyChar())) {
            octave = e.getKeyCode() - 48;
        }
        
        // select octave using '+' or '-' keys
        if (e.getKeyChar() == '+') {
            octave = octave < 8 ? octave + 1 : 8;
        }
        else if (e.getKeyChar() == '-') {
            octave = octave > 0 ? octave - 1 : 0;
        }
        
        // play a note
        int noteIndex = allKeys.indexOf((char) e.getKeyCode()); 
        if (noteIndex < 0 || keyOn[noteIndex]) {
            return;
        }
        keyOn[noteIndex] = true;
        channel.noteOn(octave * KEYS_PER_OCTAVE + noteIndex, 90);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        repaint();
        int noteIndex = allKeys.indexOf((char) e.getKeyCode()); 
        if (noteIndex < 0) {
            return;
        }
        keyOn[noteIndex] = false;
        channel.noteOff(octave * KEYS_PER_OCTAVE + noteIndex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PianoKeys view = new PianoKeys();
                JFrame frame = new JFrame();
                frame.setSize(1000, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.getContentPane().add(view);
                frame.setVisible(true);
                view.requestFocus();
            }
        });
    }
    
}