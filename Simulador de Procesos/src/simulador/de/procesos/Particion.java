package simulador.de.procesos;

public class Particion {
    private int inicio;
    private int fin;
    private boolean estado;

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
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int Tamaño() {
        return fin-inicio;
    }
    
    public void CrearParticion (int _inicio, int _fin,boolean _estado) {
        inicio = _inicio;
        fin = _fin;
        estado = _estado;
    }
}
