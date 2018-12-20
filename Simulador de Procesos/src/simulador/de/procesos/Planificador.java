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

    public void setInicio(){
        iniciaEjecucion = true;
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
    
 int Contador;//Contador del total de procesos que se van ingresando
 int Rafaga=0;//Carga la ráfaga en ejecución
 int Quantum=0;//Carga el quantum en ejecución
 int ResiduoRafaga=0;//Carga el residuo en ejecución
 int TiempoProceso=0;//Carga el tiempo que se dura procesando
 int CantidadProcesos;//Número de procesos terminados
 int Estado = 0; // 
 int i=1;// Numero de proceso en ejecucion
 int Ejecucion = 0; // 

                
    
    //Dentro de este método se definirán los algoritmos de planificación
    public ArrayList <Proceso> elegirSiguiente (ArrayList<Proceso> colaListos, int tiempo){
      
        ArrayList <Proceso> nuevaColaListos;
        nuevaColaListos = colaListos;
        Proceso proaux;
        if (!colaListos.isEmpty()){
            switch(algorit){
                case(1):    //Round Robin
                    
//Pregunto si existe algo dentro de la primer posicion de la lista, si hay cargo mis variables 
        if ( Estado == 1 && !(colaListos.isEmpty())){
            Rafaga= colaListos.get(i).getCicloCPU() ;
            Quantum=5;
            ResiduoRafaga= colaListos.get(i).getCicloCPU() ;
            Ejecucion = 1;
            Estado = 0;
        }else{
           Ejecucion = 0;
        }
        
        if (Quantum != 0 && Ejecucion == 1) {
            if (ResiduoRafaga != 0){
            ResiduoRafaga = ResiduoRafaga - 1;
            Quantum = Quantum - 1;
            }else{
                Estado=1;
            }
        }else{
            if (Quantum == 0 && Ejecucion == 1 ){
                Estado = 1;
                colaListos.get(i).setCicloCPU(ResiduoRafaga);
                i = i+1;
            }
        }
        
                    
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
                            
                            //Controlamos si no se termino el proceso
                            if (proaux.getCicloES()==0){
                                //Se guarda el tiempo de fin
                                proaux.setFinEjecución(tiempo-1);
                                //Controlamos que la cola de listos no este vacía
                                if (!nuevaColaListos.isEmpty()){
                                    //Busca el proceso con menor duración
                                    Iterator<Proceso> ite = colaListos.iterator();
                                    //Reinicio los contadores
                                    i = 0;
                                    resguardo = 0;
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
                            //Controlamos si no se termino el proceso
                            if (proaux.getCicloES()==0){
                                proaux.setFinEjecución(tiempo-1);
                                //Si hay mas procesos seteamos el tiempo de inicio del siguiente proceso
                                if (nuevaColaListos.size()>1){
                                    proaux = nuevaColaListos.get(1);
                                    proaux.setInicioEjecucion(tiempo);
                                }
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
