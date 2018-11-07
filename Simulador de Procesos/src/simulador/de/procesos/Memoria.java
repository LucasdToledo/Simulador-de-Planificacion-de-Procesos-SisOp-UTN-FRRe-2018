
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    //Tamaño de la memoria
    private int tamaño;
    //Variable que determina si la memoria es estática o dinámica
    private boolean tipo;
    //Lista de particiones
    private List<Particion> ListaParticiones;

    public int getTamaño() {
        return tamaño;
    }
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isTipo() {
        return tipo;
    }
    //True = Dinámica; False=Estática
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
    public List<Particion> getListaParticiones() {
        return ListaParticiones;
    }
    public void setListaParticiones(List<Particion> ListaParticiones) {
        this.ListaParticiones = ListaParticiones;
    }
    
    public void CrearMemoria (int _tam, boolean _tipo) {
        tamaño = _tam;
        tipo = _tipo;
        List <Particion> ListadeParticiones = new ArrayList();
        ListaParticiones = ListadeParticiones;
        if(tipo){
             Particion part = new Particion();
             part.CrearParticion(0, tamaño, true);
             ListaParticiones.add(part);
        }
    }
}
