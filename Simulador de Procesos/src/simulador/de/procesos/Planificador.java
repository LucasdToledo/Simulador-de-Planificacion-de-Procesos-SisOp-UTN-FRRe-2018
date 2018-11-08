

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fvg
 */
public class Planificador {
    int Contador;//Contador del total de procesos que se van ingresando
    int NProceso;//Carga el número de procesos ejecutándose
    int Rafaga=0;//Carga la ráfaga en ejecución
    int Quantum=0;//Carga el quantum en ejecución
    int ResiduoRafaga=0;//Carga el residuo en ejecución
    int TiempoProceso=0;//Carga el tiempo que se dura procesando
    int ValorBarra;//Carga el progreso de la Barra
    int CantidadProcesos;//Número de procesos terminados
    
    private void AgregarActionPerformed() {                                          
        // TODO add your handling code here:
        int y;
        y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de rafagas"));
        if(y<=100){
            Ingresar();
            jTFCapturaQuantum.setEditable(false);
        }else{
            JOptionPane.showMessageDialog(null, "Las Rafagas no pueden ser mayores de 100");
            jTFCapturaRafaga.setText(null);
            jTFCapturaRafaga.grabFocus();  
        }     
}
    public void Dormir(){
    try{
        Thread.sleep(700); //Dormir sistema
    }catch(InterruptedException ex){
        Logger.getLogger(Procesar.class.getName()).log(Level.SEVERE,null,ex);
    }

}
    public void Cargar(int i){ //Carga los valores de la Tabla
    NProceso=(int)jTIngreso.getValueAt(i,0);
    Rafaga=parseInt((String)(jTIngreso.getValueAt(i,1)));
    Quantum=parseInt((String)(jTIngreso.getValueAt(i,2)));
    ResiduoRafaga=parseInt((String)(jTIngreso.getValueAt(i,3)));
    if(NProceso>0){
        jLNumeroProceso.setText(String.valueOf(NProceso));
    }
    public void Ingresar(){ //Ingresar proceso a la tabla
    DefaultTableModel modelo=(DefaultTableModel) jTIngreso.getModel();

    Contador ++;
    Object[] miTabla = new Object[5];
    miTabla[0]= Contador;
    miTabla[1]= jTFCapturaRafaga.getText();
    miTabla[2]= jTFCapturaQuantum.getText();
    miTabla[3]= jTFCapturaRafaga.getText();
    miTabla[4]= "Listo";
    modelo.addRow(miTabla);
    jTIngreso.setModel(modelo);
    jTFCapturaRafaga.setText(null);
    jTFCapturaRafaga.grabFocus();
}
