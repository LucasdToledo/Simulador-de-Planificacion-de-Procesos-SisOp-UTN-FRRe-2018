/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sole
 */
public class UIMemoria extends javax.swing.JFrame {
    int Cont = 0;
    public Memoria mem;
    public ArrayList<Proceso> colaProcesos;
    public int asignador;
    public int planificador;
    int contmemoriarestante;
    int contmemusada;
    boolean fsiguiente;
    
    /**
     * Creates new form UIMemoria
     */
    public UIMemoria() {
        contmemoriarestante = 0;
        contmemusada = 0;
        fsiguiente = false;
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

        SiguienteMem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaParti = new javax.swing.JTable();
        label1 = new java.awt.Label();
        tamParti = new javax.swing.JTextField();
        agregarTam = new javax.swing.JButton();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        memoriaUsada = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        Memoriarestante = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SiguienteMem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        SiguienteMem.setText("Siguiente");
        SiguienteMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteMemActionPerformed(evt);
            }
        });

        tablaParti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lugar", "Particón"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaParti);

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Tamaño de Partición");

        tamParti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamPartiActionPerformed(evt);
            }
        });

        agregarTam.setText("Agregar");
        agregarTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTamActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label2.setText("Particionamiento de Memoria ");

        label3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label3.setText("Total de Memoria");

        memoriaUsada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoriaUsadaActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label4.setText("Memoria Restante");

        Memoriarestante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemoriarestanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tamParti, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agregarTam))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(SiguienteMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(memoriaUsada)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Memoriarestante)))
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregarTam)
                        .addComponent(tamParti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memoriaUsada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Memoriarestante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SiguienteMem)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiguienteMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteMemActionPerformed
       if (fsiguiente){
            UIFinal b = new UIFinal();
            b.setMem(mem);
            b.setAsignador(asignador);
            b.setPlanificador(planificador);
            b.setVisible(true);
            this.setVisible(false);
       }
       else{
           JOptionPane.showMessageDialog(null,"Por favor, carga todas las particiones antes de avanzar");
       }
    }//GEN-LAST:event_SiguienteMemActionPerformed

    private void tamPartiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamPartiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamPartiActionPerformed

    private void agregarTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTamActionPerformed
       IngresarParti();
    }//GEN-LAST:event_agregarTamActionPerformed
    
    private void MemoriarestanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemoriarestanteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MemoriarestanteActionPerformed

    private void memoriaUsadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoriaUsadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memoriaUsadaActionPerformed

    public void setAsignador(int asig) {
        this.asignador = asig;
    }

    public void setPlanificador(int planificador) {
        this.planificador = planificador;
    }

    public Memoria getMem() {
        return mem;
    }

    public void setColaProcesos(ArrayList<Proceso> colaProcesos) {
        this.colaProcesos = colaProcesos;
    }

    public void setMem(int tamMemoria,boolean tipoParticionamiento) {
        Memoria memoria = new Memoria();
        memoria.CrearMemoria(tamMemoria, tipoParticionamiento);
        this.mem = memoria;
        contmemoriarestante = tamMemoria;
        Memoriarestante.setText(String.valueOf(tamMemoria));
    }
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UIMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIMemoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UIMemoria().setVisible(true);
        });
    }
    public  void IngresarParti() { 
        
        if((Integer.parseInt(tamParti.getText()) <= contmemoriarestante)&&(Integer.parseInt(tamParti.getText()) > 0)){
            DefaultTableModel modelo=(DefaultTableModel) tablaParti.getModel();
            Cont ++; 
            Object[] tabla = new Object[2];
            tabla[0]= Cont;
            tabla[1]= tamParti.getText();
            contmemusada = contmemusada + Integer.parseInt(tamParti.getText());
            memoriaUsada.setText(String.valueOf(contmemusada));
            contmemoriarestante = contmemoriarestante - Integer.parseInt(tamParti.getText()) ;
            Memoriarestante.setText(String.valueOf(contmemoriarestante));
              if (contmemoriarestante == 0){
                  fsiguiente = true;
              }
            modelo.addRow(tabla);
        }
        else { 
             JOptionPane.showMessageDialog(null,"La particion es demasiado grande");
        }
    }
    
    public void Borrar(int c){
        tablaParti.setValueAt(0,c,0);
        tablaParti.setValueAt("0",c,1);
        tablaParti.setValueAt("0",c,2);
        tablaParti.setValueAt("0",c,3);
        tablaParti.setValueAt("******",c,4);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Memoriarestante;
    private javax.swing.JButton SiguienteMem;
    private javax.swing.JButton agregarTam;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTextField memoriaUsada;
    private javax.swing.JTable tablaParti;
    private javax.swing.JTextField tamParti;
    // End of variables declaration//GEN-END:variables

    
    
}

