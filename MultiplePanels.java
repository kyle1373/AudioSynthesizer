import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MultiplePanels{
    //Note: If you're trying to run the piano, go to PianoKeys.java and run there :D


    JFrame window = new JFrame("ECE45 Project");
    PianoKeysPanel pianoKeys = new PianoKeysPanel();
    BeeperPanel beeper = new BeeperPanel();

    
    MultiplePanels() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.setSize(1000, 600);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setLocationRelativeTo(null);
                window.getContentPane().add(pianoKeys);
                window.setVisible(true);
                pianoKeys.grabFocus();
            }
        });
        //window.add(pianoKeys, BorderLayout.CENTER);
        window.getContentPane().add(beeper, BorderLayout.EAST); 
        //window.setSize(1000, 600);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setVisible(true);
        //pianoKeys.requestFocus();
    }

        
 /*
 * 
 * TODO: Connect Beeper to PianoKeys.java.
 * 
 * Make a second keyboard which is an octave higher than the first
 *
 * Figure out a way to make a JFrame which combines both a graph and the paint interface
 */
}
