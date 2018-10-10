
package simulador.de.procesos;

import java.util.List;

public class Memoria {
    private int tamaño;
    private List<Particion> ListaParticiones;

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public List<Particion> getListaParticiones() {
        return ListaParticiones;
    }

    public void setListaParticiones(List<Particion> ListaParticiones) {
        this.ListaParticiones = ListaParticiones;
    }
    
    public void CrearMemoria (int _tam, List<Particion> _ListaP) {
        tamaño = _tam;
        ListaParticiones = _ListaP;
    }
}
