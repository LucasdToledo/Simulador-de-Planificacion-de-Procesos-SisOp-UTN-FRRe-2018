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
    int iRR2;// Numero de proceso en ejecucion
    int ResiduoRafaga2; //Carga el valor del quantum aun no consumido
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
    
    public int getResiduoES(){
        return ResiduoRafaga2;
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
        if (!colaListos.isEmpty()){
            int i = 0;
            Proceso p;
            while (ite.hasNext()) {
                p = ite.next();
                if (p.getDuracion()==0){
                    colaListos.remove(i);
                }
                i++;
            }
        }
        return colaListos;
    }
    
    //Dentro de este método se definirán los algoritmos de planificación
    public ArrayList <Proceso> elegirSiguiente (ArrayList<Proceso> colaListos, ArrayList <Proceso> colaES, int tiempo){
    
        ArrayList <Proceso> nuevaColaListos;
        nuevaColaListos = colaListos;
        Proceso proaux;
        if (!colaListos.isEmpty() || !colaES.isEmpty() ){
            switch(algorit){
                case(1):    //Round Robin
                   
                    if (!nuevaColaListos.isEmpty()) {
                        
                        
                        //Ahora, guardo el inicio de ejecución si es el primer proceso
                    
                        if (iniciaEjecucion && nuevaColaListos.get(iRR).isSjf()){ 
                            nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                            iniciaEjecucion = false;
                            nuevaColaListos.get(iRR).setSjf(false);
                        }
                        else{
                            if (nuevaColaListos.get(iRR).isSjf()){
                                nuevaColaListos.get(iRR).setInicioEjecucion(tiempo);
                                nuevaColaListos.get(iRR).setSjf(false);
                            }
                        }
                        
                        if (nuevaColaListos.get(iRR).getCicloCPU()> 0){
                        
                            nuevaColaListos.get(iRR).setCicloCPU(nuevaColaListos.get(iRR).getCicloCPU()-1);
                            if (nuevaColaListos.get(iRR).getCicloCPU()==0 ) {
                                colaES.add(nuevaColaListos.get(iRR));
                                ResiduoRafaga = quantum;
                                if (nuevaColaListos.size()== iRR){
                                    iRR = 0;
                                    JOptionPane.showMessageDialog(null, "ALERTA: Puede que funque porque Reinició");
                                }
                            }
                            else{
                                if (ResiduoRafaga > 1){
                                    ResiduoRafaga--;
                                    JOptionPane.showMessageDialog(null, "Rafaga resto: " + ResiduoRafaga);
                                }else {
                                    //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                                    iRR++;
                                    JOptionPane.showMessageDialog(null, "iRR: " + iRR);
                                    if (nuevaColaListos.size()== iRR){
                                        iRR = 0;
                                    }
                                    ResiduoRafaga = quantum;
                                }
                            }
                        }
                        else{           
                            if (nuevaColaListos.get(iRR).getCicloCPU2()> 0){
                               nuevaColaListos.get(iRR).setCicloCPU2(nuevaColaListos.get(iRR).getCicloCPU2()-1);
                                if (nuevaColaListos.get(iRR).getCicloCPU2()==0) {
                                    nuevaColaListos.remove(iRR);
                                    //Se guarda el tiempo de fin
                                    nuevaColaListos.get(iRR2).setFinEjecución(tiempo);
                                    iniciaEjecucion = true;
                                    //Puede que no se haya consumido todo el quantum
                                    //Pero como el proceso termina se lo reinicia
                                    ResiduoRafaga = quantum;
                                    if (nuevaColaListos.size()== iRR){
                                        iRR = 0;
                                    }
                                }
                                else{        
                                    if (ResiduoRafaga > 1){
                                        ResiduoRafaga--;
                                        JOptionPane.showMessageDialog(null, "Rafaga resto: " + ResiduoRafaga);
                                    }
                                    else {
                                    //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                                        iRR++;
                                        JOptionPane.showMessageDialog(null, "iRR: " + iRR);
                                        if (nuevaColaListos.size()== iRR){
                                            iRR = 0;
                                        }
                                        ResiduoRafaga = quantum;
                                    }

                                }
                            }
                        }
                    }
                    //ESTO NO SE SI CIERRA ACA, salu2
                    //ENTRADA SALIDA
                    
                    if (!colaES.isEmpty()) {
                        if (colaES.get(iRR2).getCicloES()> 0){ 
                            colaES.get(iRR2).setCicloES(colaES.get(iRR2).getCicloES()-1);//restamos la entrada/salida
                            if(colaES.get(iRR2).getCicloES() == 0){ //si mi ciclo de entrada/salida ya TERMINO, lo mando a cola de LISTO
                                colaES.remove(iRR2);
                                ResiduoRafaga2 = quantum;
                                
                                if (colaES.size()== iRR2){
                                   iRR = 0;
                                }
                            }
                            else{                        
                                if (ResiduoRafaga2 > 1){  //si es mayor a 1, resto el quatum
                                    ResiduoRafaga2--;
                                }
                                else {
                                    //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                                    iRR2++;   //aca lo muevo
                                    if (colaES.size()== iRR2){
                                        iRR2 = 0;
                                    }
                                    //Como es un nuevo proceso reinicio el quantum
                                    ResiduoRafaga2 = quantum; //ACA BORRE EL -1. CALA LA BOCA MANITO. GUIDO
                                }
                            }
                            
                        }
                    }
                    
             
           //Pero si no los tiene, nos fijamos si hay ciclos de ES y los consumimos
            /*else{
                if (proaux.getCicloES()> 0){
                    proaux.setCicloES(proaux.getCicloES()-1);
                    
                }
                else{
                    if (proaux.getCicloCPU2()>0){
                        proaux.setCicloCPU2(proaux.getCicloCPU2()-1);
                        //Controlamos si se termino el proceso
                        if (proaux.getCicloCPU2()==0){
                            
                            //Se guarda el tiempo de fin
                            proaux.setFinEjecución(tiempo);
                            iniciaEjecucion = true;
                            //Puede que no se haya consumido todo el quantum
                            //Pero como el proceso termina se lo reinicia
                            ResiduoRafaga = quantum;
                            //La cola de listos tiene un elemento menos
                            JOptionPane.showMessageDialog(null, "Rafaga: " + ResiduoRafaga);
                        }
                    }
                }
            }
                    
                    //Si todavía no se termina el quantum decrece el ResiduoRafaga
                    if (ResiduoRafaga > 1){
                        ResiduoRafaga--;
                        JOptionPane.showMessageDialog(null, "Rafaga resto: " + ResiduoRafaga);
                    }
                    else {
                        //Si el contador es mayor al tamaño de la lista lo pongo a cero para que reinicie
                        iRR++;
                        JOptionPane.showMessageDialog(null, "iRR: " + iRR);
                        if (nuevaColaListos.size()== iRR){
                            iRR = 0;
                        }
                        //Como es un nuevo proceso reinicio el quantum
                        ResiduoRafaga = quantum; //ACA BORRE EL -1. CALA LA BOCA MANITO. GUIDO
                    }*/

                    
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
