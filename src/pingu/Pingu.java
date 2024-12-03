package pingu;

import javax.swing.SwingUtilities;
import view.TelaPrincipal;

public class Pingu {

   public static void main(String[] args) {
    // Use SwingUtilities to ensure UI creation happens on the Event Dispatch Thread
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Create and show the main window (TelaPrincipal)
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
        }
    });
}
    
}
