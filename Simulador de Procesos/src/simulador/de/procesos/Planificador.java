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
    int quantum;
    int iRR;            // Numero de proceso en ejecucion
    int ResiduoRafaga;  //Carga el valor del quantum aun no consumido

    public Planificador() {
        this.iRR = 0;
    }

    public void setQuantum(int quantum) {
        ResiduoRafaga = quantum;
        this.quantum = quantum;
    }

    public int getQuantum() {
        return quantum;
    }
    
    public int getResiduo(){
        return ResiduoRafaga;
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
       
        //Busca el proceso de duración 0
        Iterator<Proceso> ite = colaListos.iterator();
        int i = 0;
        int resguardo;
        Proceso p;
        while (ite.hasNext()) {
            p = ite.next();
            if (p.getDuracion()==0){
                resguardo = i;
                colaListos.remove(resguardo);
            }
            i++;
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
                    /*
                    //Pregunto si existe algo dentro de la primer posicion de la lista, si hay cargo mis variables 
                    if ( Estado == 1 && !(colaListos.isEmpty())){
                        Rafaga= colaListos.get(iRR).getCicloCPU() ;
                        Quantum=3;
                        ResiduoRafaga= colaListos.get(iRR).getCicloCPU() ;
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
                            colaListos.get(iRR).setCicloCPU(ResiduoRafaga);
                            iRR++;
                        }
                    }
                    */
                    //Si todavía no se termina el quantum decrece el ResiduoRafaga
                    if (ResiduoRafaga > 0){
                        ResiduoRafaga--;
                    }
                    else {
                        //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                        if (colaListos.size()<= iRR){
                            iRR = 0;
                        }
                        //Si no es tan grande lo incremento
                        else {
                            iRR++;
                        }
                        //Como es un nuevo proceso reinicio el quantum
                        ResiduoRafaga = quantum;
                    }
                    proaux = nuevaColaListos.get(iRR);
                    JOptionPane.showMessageDialog(null, "Control: "+ iRR);
                    
                    //Se llama SJF pero cumple la misma función en RR
                    if (iniciaEjecucion && proaux.isSjf()){ 
                        proaux.setInicioEjecucion(tiempo);
                        iniciaEjecucion = false;
                        proaux.setSjf(false);
                    }
                    else{
                        if (proaux.isSjf()){
                            proaux.setInicioEjecucion(tiempo);
                            proaux.setSjf(false);
                        }
                    }
                    
                    //Si el proceso tiene ciclos CPU los consume de a uno
                    if (proaux.getCicloCPU()> 0){
                        proaux.setCicloCPU(proaux.getCicloCPU()-1);
                    }
                    //Pero si no los tiene, nos fijamos si hay ciclos de ES y los consumimos
                    else{
                        if (proaux.getCicloES()> 0){
                            proaux.setCicloES(proaux.getCicloES()-1);
                            
                            //Controlamos si se termino el proceso
                            if (proaux.getCicloES()==0){
                                
                                //Se guarda el tiempo de fin
                                proaux.setFinEjecución(tiempo);
                                iniciaEjecucion = true;
                                //Puede que no se haya consumido todo el quantum
                                //Pero como el proceso termina se lo reinicia
                                ResiduoRafaga = quantum;
                                //La cola de listos tiene un elemento menos
                                //Se reduce el contador para compensar el desfase
                                iRR--;
                            }
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
                    Proceso p1;
                    while (it.hasNext()) {
                        p1 = it.next();
                        if (p1.getDuracion()< colaListos.get(resguardo).getDuracion()&& p1.getCicloES()>0){
                            resguardo = i;
                        }
                        i++;
                    }
                    proaux = colaListos.get(resguardo);
                    //Ahora, guardo el inicio de ejecución si es el primer proceso
                    
                    if (iniciaEjecucion && proaux.isSjf()){ 
                        proaux.setInicioEjecucion(tiempo);
                        iniciaEjecucion = false;
                        proaux.setSjf(false);
                    }
                    else{
                        if (proaux.isSjf()){
                            proaux.setInicioEjecucion(tiempo);
                            proaux.setSjf(false);
                        }
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
                                proaux.setFinEjecución(tiempo);
                                iniciaEjecucion = true;
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
                                proaux.setFinEjecución(tiempo);
                                //Si hay mas procesos seteamos el tiempo de inicio del siguiente proceso
                                iniciaEjecucion = true;
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
