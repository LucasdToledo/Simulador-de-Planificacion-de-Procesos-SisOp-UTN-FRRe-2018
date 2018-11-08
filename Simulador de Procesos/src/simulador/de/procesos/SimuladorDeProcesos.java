
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class SimuladorDeProcesos extends javax.swing.JFrame {

    /**
     * Creates new form SimuladorDeProcesos
     */
    public SimuladorDeProcesos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents                                                                  
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ACÁ VA DISEÑADO TAL COMO ESTÁ EL MOCKUP ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END: initComponents                                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Esqueleto
       
        //Creamos e inicializamos las listas de procesos
        ArrayList ColaNuevo = null, ColaListos, ColaBloqueados = new ArrayList();
        
        //Creamos una particion y una memoria
        Particion particion = new Particion();
        Memoria mem = new Memoria();
        
        //Creamos un asignador
        Asignador asignador = new Asignador();
        
        //Carga de procesos
        boolean bandera = true;
        int opcionProcesos;
        while(bandera) {
            String descripcion = JOptionPane.showInputDialog("¿Cuál es el nombre del proceso?");
            int prioridad = Integer.parseInt(JOptionPane.showInputDialog("Prioridad"));
            int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración total del proceso"));
            int tarribo = Integer.parseInt(JOptionPane.showInputDialog("Tiempo de arribo"));
            int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño"));
            Proceso nuevoproceso = new Proceso();
            nuevoproceso.CrearProceso(prioridad, duracion, descripcion, tarribo, tam);
            ColaNuevo.add(nuevoproceso);
            opcionProcesos = JOptionPane.showConfirmDialog(null, "¿Desea crear otro proceso?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (opcionProcesos == 1) {
                bandera = false;
            }
        }
        Iterator<Proceso> it = ColaNuevo.iterator();
        String enLista = "";
        int i = 0;
        while (it.hasNext()) {
            enLista = enLista +"\n"+ "Proceso: "+ i + "  " +it.next();
            i++;
        } 
        JOptionPane.showMessageDialog(null,enLista);
        
       //Pedimos al usuario que ingrese el tamaño de la memoria
        int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la memoria"));
        
        //Con este bucle nos aseguramos de que el usuario ingrese correctamente el string     
        boolean flag = true;
        boolean flag2 = true;
        String aux = ""; 
        int contador = 0;
        int part = 0;
        while (flag){
            
            aux = JOptionPane.showInputDialog("Ingrese el tipo de memoria, 'FIJA' o 'VARIABLE'");
            aux = aux.toUpperCase();
            switch (aux){
                case("VARIABLE"): 
                    mem.CrearMemoria(tam,true);
                    flag =false;
                break;
                case ("FIJA"):
                    mem.CrearMemoria(tam,false); 
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea crear las particiones o nos encargamos de eso?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    //Si el usuario elige que sí
                    if (resp == 0){
                        
                        ArrayList<Particion> listaux;
                        //Esto hace que se puedan ingresar particiones hasta que ocupe toda la memoria
                        while(flag2){ //bandera para saber cuando salir del mientras y no agregar mas particiones
                        part = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la partición"));//variable donde guardo el tamaño de la particion ingresada
                        contador = contador + part;//contador que acumula los tamanos de la sparticiones apra saber cuando sobrepasa la memoria
                            if(contador < mem.getTamaño()){  //si mi contador es mas chico que la memoria significa que tengo espacio para crear
                                listaux = asignador.Particionar(mem, part); //crea las particiones en la lsita de particiones
                                mem.setListaParticiones(listaux);
                            }
                             if(contador > mem.getTamaño()){ //no tengo espacio y no puede ingresar la particion
                                 JOptionPane.showMessageDialog(null,"Excedio el tamaño de la memoria vuelva a ingresar la particion");
                                 contador = contador - part;
                             }
                             if(contador == mem.getTamaño()){ // cuando el contador es igual a la memoria significa que es la ultima particion que puede ingresar
                                listaux = asignador.Particionar(mem, part);
                                 mem.setListaParticiones(listaux);
                                    flag2 = false; //pone la bandera en false para que no pedir mas particiones
                             }
                        }
                    
                    }
                    flag =false;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "404: Not found inteligencia en ti, vuelve a intentar");
                break;
            }
        }
        mem.Mostrar();// ACA TERMINA LA CREACION DE MEMORIA
        
       
        

    //CARGA DE PROCESOS
      String asig;
     //Ciclo for
     // for (inicializacion; condicion; aumento o decremento){instrucciones;}
           
           
           asig = JOptionPane.showInputDialog("ingrese el tipo de asignador. bf, ff, wf");
           
           switch (asig){
                case("ff"): 
                   asignador.setAlgoritmo(1);
                break;
                case ("bf"):
                    asignador.setAlgoritmo(2);
                break;
                case ("wf"):
                    asignador.setAlgoritmo(3);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "404: Not found inteligencia en ti, vuelve a intentar");
                break;
            }
       
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorDeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimuladorDeProcesos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
