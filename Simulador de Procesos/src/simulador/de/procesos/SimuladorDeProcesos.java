
package simulador.de.procesos;

import javax.swing.JOptionPane;
import java.awt.Color; 
import static java.lang.Integer.parseInt; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTable­Model;

public class SimuladorDeProcesos {

    public static void main(String[] args) {
        
        String dato = JOptionPane.showInputDialog(null, "Ingresa tu nombre");
        
        JOptionPane.showMessageDialog(null, "Hola "+dato);
    }
    
}
