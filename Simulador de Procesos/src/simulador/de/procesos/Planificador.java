/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
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
    
    public ArrayList <Proceso> procesoTerminado(ArrayList <Proceso> colaListos){
        switch (algorit){
            case (1):   //RR+Q
                break;  
            case (2):   //SRTF
                break;
            case (3):   //SJF
                break;
            case(4):    //FCFS
                colaListos.remove(0);
                break;
        }
        return colaListos;
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
                    //Busca el proceso con menor duración
                    Iterator<Proceso> it = colaListos.iterator();
                    int i = 0;
                    int resguardo = 0;
                    while (it.hasNext()) {
                        proaux = it.next();
                        if (proaux.getDuracion()> colaListos.get(i).getDuracion()){
                            resguardo = i;
                        }
                        i++;
                    }
                    proaux = colaListos.get(resguardo);
                    //Ahora, guardo el inicio de ejecución si es el primer proceso
                    if (iniciaEjecucion){ 
                        proaux.setInicioEjecucion(tiempo);
                        iniciaEjecucion = false;
                    }
                    //Si el proceso tiene ciclos CPU los consume de a uno
                    if (proaux.getCicloCPU()> 0){
                        proaux.setCicloCPU(proaux.getCicloCPU()-1);
                    }
                    //Pero si no los tiene, nos fijamos si hay ciclos de ES y los consumimos
                    else{
                        if (proaux.getCicloES()> 0){
                            proaux.setCicloES(proaux.getCicloES()-1);
                        }
                        //Si ambos valores son 0 el proceso ya se terminó
                        // por lo que hay que consumir otro proceso
                        else{
                            //Se guarda el tiempo de fin
                            proaux.setFinEjecución(tiempo-1);
                            //Controlamos que la cola de listos no este vacía
                            if (!nuevaColaListos.isEmpty()){
                                //Busca el proceso con menor duración
                                Iterator<Proceso> ite = colaListos.iterator();
                                while (ite.hasNext()) {
                                    proaux = ite.next();
                                    if (proaux.getDuracion()> colaListos.get(i).getDuracion()){
                                        resguardo = i;
                                    }
                                    i++;
                                }
                                proaux = nuevaColaListos.get(resguardo);
                                proaux.setInicioEjecucion(tiempo);
                                proaux.setCicloCPU(proaux.getCicloCPU()-1);
                            }
                        }
                    }
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
                            if (!nuevaColaListos.isEmpty()){
                                
                                proaux = nuevaColaListos.get(1);
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
