
package lio;
import java.awt.EventQueue;
import java.io.IOException;

/**
 *
 * @author Fernando Bergamo
 */
public class LIO {

    public static void main(String[] args) throws IOException {       
        EventQueue.invokeLater(() -> {
                new tela().setVisible(true);
        });
    }  
}


 
