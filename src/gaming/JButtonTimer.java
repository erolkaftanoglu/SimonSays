package gaming;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author erol
 */
public class JButtonTimer implements Runnable {

    ArrayList<JButton> a;

    public JButtonTimer(ArrayList<JButton> a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            for (JButton jButton : a) {
                jButton.setEnabled(false);
                Thread.sleep(500);
                jButton.setEnabled(true);
                Thread.sleep(200);
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(JButtonTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
