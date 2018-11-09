package simulador.de.procesos;

public class Particion {
    private int inicio;
    private int fin;
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

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int Tamaño() {
        return fin-inicio;
    }
    
    public void CrearParticion (int _inicio, int _tam_proces,boolean _estado) {
        inicio = _inicio;
        fin = _inicio + _tam_proces;
        estado = _estado;
    }

    //Cambiamos el comportamiento de clase indicando la manera de mostrar los datos si se usa un Print
    @Override
    public String toString() {
        return "Tamaño="+(fin-inicio) + " Estado =" + estado;
    }
   
}
