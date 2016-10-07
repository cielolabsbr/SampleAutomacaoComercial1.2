package lio;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LIO {

    public static void main(String[] args) throws IOException {       
        EventQueue.invokeLater(() -> {
            try {
                new tela().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(LIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }  
}


 
