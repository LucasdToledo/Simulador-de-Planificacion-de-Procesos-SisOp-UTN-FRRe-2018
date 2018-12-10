package simulador.de.procesos;

public class Particion {
    private int tamaño;
    private boolean estado;
    private Proceso proces;
    //True es vacio y false ocupado

    public Proceso getProces() {
        return proces;
    }

    public void setProces(Proceso proces) {
        estado = false;
        this.proces = proces;
    }

    public boolean isEstado() {
        //Si exite un proceso cargado
        if (proces != null){
                //Y si duración es 0, significa que el proceso termino y la partición estará vacía
                //El proceso no se borra sino que se sobreescribe como en las memorias reales.
                if (proces.getDuracion() == 0){
                    estado = true;
                }
        }
        return estado;
    }

    //En teoría no se debería usar este método porque al asignar un proceso se actualiza el estado automáticamente.
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int Tamaño() {
        return tamaño;
    }
    
    public void CrearParticion (int _tamParticion) {
        tamaño = _tamParticion;
        estado = true;
    }

    //Cambiamos el comportamiento de clase indicando la manera de mostrar los datos si se usa un Print
    @Override
    public String toString() {
        return "Tamaño="+(tamaño) + " Estado= " + estado + "Proceso= " + proces;
    }
   
}
