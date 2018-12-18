/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fvg
 */
public class Planificador {
    private int algorit;
    boolean iniciaEjecucion;
    
    public void Planificador(){
        iniciaEjecucion = true;
    }

    public int getAlgorit() {
        return algorit;
    }

    public void setAlgorit(int algorit) {
        this.algorit = algorit;
    }
    
    //Dentro de este método se definirán los algoritmos de planificación
    public ArrayList <Proceso> elegirSiguiente (ArrayList<Proceso> colaListos, int tiempo){
      
        ArrayList <Proceso> nuevaColaListos;
        nuevaColaListos = colaListos;
        Proceso proaux;
        if (!colaListos.isEmpty()){
            switch(algorit){
                case(1):    //Round Robin
                    break;
                case(2):    //SRTF
                    break;
                case (3):   //SJF
                    break;
                case (4):   //FCFS
                    proaux = nuevaColaListos.get(0);
                    if (iniciaEjecucion){ 
                        proaux.setInicioEjecucion(tiempo);
                        iniciaEjecucion = false;
                    }
                    if (proaux.getCicloCPU()> 0){
                        proaux.setCicloCPU(proaux.getCicloCPU()-1);
                    }
                    else{
                        if (proaux.getCicloES()> 0){
                            proaux.setCicloES(proaux.getCicloES()-1);
                        }
                        else{
                            proaux.setFinEjecución(tiempo-1);
                            nuevaColaListos.remove(0);
                            if (!nuevaColaListos.isEmpty()){
                                proaux = nuevaColaListos.get(0);
                                proaux.setInicioEjecucion(tiempo);
                                proaux.setCicloCPU(proaux.getCicloCPU()-1);
                            }
                        }
                    }
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "La cola de listos está vacía");
            iniciaEjecucion = true;
        }
        
        return nuevaColaListos;
    } 
    
}
