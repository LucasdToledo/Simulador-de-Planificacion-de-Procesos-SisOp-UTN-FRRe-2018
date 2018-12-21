package simulador.de.procesos;

import java.util.ArrayList;


public class Proceso {
    private int numero; 
    private int prioridad;
    private int cicloES; //Ciclos de CPU y E-S
    private int cicloCPU;
    private int cicloCPU2;
    private int duracion;
    private int idProceso;
    private String descripcion;
    private int tarribo;
    private int tamaño;
    int inicioEjecucion;
    int finEjecución;
    boolean sjf;

    public boolean isSjf() {
        return sjf;
    }

    public int getCicloCPU2() {
        return cicloCPU2;
    }

    public void setCicloCPU2(int cicloCPU2) {
        this.cicloCPU2 = cicloCPU2;
    }
    
    

    public void setSjf(boolean sjf) {
        this.sjf = sjf;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCicloES() {
        return cicloES;
    }

    public void setCicloES(int cicloES) {
        this.cicloES = cicloES;
    }

    public int getCicloCPU() {
        return cicloCPU;
    }

    public void setCicloCPU(int cicloCPU) {
        this.cicloCPU = cicloCPU;
    }

    public int getDuracion() {
        return cicloES + cicloCPU + cicloCPU2;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTarribo() {
        return tarribo;
    }

    public void setTarribo(int tarribo) {
        this.tarribo = tarribo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setInicioEjecucion(int inicioEjecucion) {
        this.inicioEjecucion = inicioEjecucion;
    }

    public void setFinEjecución(int finEjecución) {
        this.finEjecución = finEjecución;
    }

    public int getInicioEjecucion() {
        return inicioEjecucion;
    }

    public int getFinEjecución() {
        return finEjecución;
    }
    
    public void CrearProceso(String _des,int _tarribo,int _tam, int _es, int _cpu, int _cpu2){
        cicloES = _es;
        cicloCPU = _cpu;
        cicloCPU2 = _cpu2;
        descripcion = _des;
        tarribo = _tarribo;
        tamaño = _tam;
        sjf = true;
        idProceso = 0;
    }

    @Override
    public String toString() {
        return "ID:" + idProceso + ", Proceso: " +descripcion +  ", Tamaño=" +tamaño;}
    }
    
    

