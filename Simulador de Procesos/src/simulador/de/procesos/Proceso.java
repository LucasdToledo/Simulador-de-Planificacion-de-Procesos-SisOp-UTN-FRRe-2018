package simulador.de.procesos;

public class Proceso {
    private int numero; 
    private int prioridad;
    private int duracion;
    private String descripcion;
    private int tarribo;
    private int tamaño;
    
    //Falta agregar un arreglo de 3 elementos para definir el ciclo CPU-E/S-CPU
    //No sé todavía cómo se definen los arreglos por eso no está aún
    
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
    
    public void CrearProceso(int _num,int _prior,int _dur,String _des,int _tarribo,int _tam){
        numero = _num;
        prioridad = _prior;
        duracion = _dur;
        descripcion = _des;
        tarribo = _tarribo;
        tamaño = _tam;
    }
    
    
}
