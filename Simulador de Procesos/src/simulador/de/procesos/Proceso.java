package simulador.de.procesos;

import java.util.ArrayList;


public class Proceso {
    private int numero; 
    private int prioridad;
    private ArrayList rafaga; //Ciclos de CPU y E-S
    private int duracion;
    private String descripcion;
    private int tarribo;
    private int tamaño;
    
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

    public ArrayList getRafaga() {
        return rafaga;
    }

    public void setRafaga(ArrayList rafaga) {
        this.rafaga = rafaga;
    }

    public int getDuracion() {
        return duracion;
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
    
    public void CrearProceso(int _prior,int _dur,String _des,int _tarribo,int _tam){
        prioridad = _prior;
        duracion = _dur;
        descripcion = _des;
        tarribo = _tarribo;
        tamaño = _tam;
        //agregar los que faltan para los planificadores
    }

    @Override
    public String toString() {
        return descripcion + ", prioridad=" + prioridad + ", duracion=" + duracion+ ", tarribo=" + tarribo + ", tamaño=" + tamaño + '}';
    }
    
    
}
