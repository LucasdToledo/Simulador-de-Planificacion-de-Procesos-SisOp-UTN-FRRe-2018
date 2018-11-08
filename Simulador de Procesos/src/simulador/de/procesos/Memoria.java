
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Memoria {
    //Tamaño de la memoria
    private int tamaño;
    //Variable que determina si la memoria es estática o dinámica
    private boolean tipo;
    //Lista de particiones
    private ArrayList<Particion> ListaParticiones;

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
    
    public void setListaParticiones(ArrayList<Particion> ListaParticiones) {
        this.ListaParticiones = ListaParticiones;
    }
    
    //Este es el constructor
    public void CrearMemoria (int _tam, boolean _tipo) {
        tamaño = _tam;
        tipo = _tipo;
        ArrayList <Particion> ListadeParticiones = new ArrayList();
        ListaParticiones = ListadeParticiones;
        //Se crea la primera partición, sea fijo o dinámico debe existir
        Particion part = new Particion();
        part.CrearParticion(0, tamaño, true);
        //Agregamos la partición creada a la lista
        ListaParticiones.add(part);
        if(tipo){
            JOptionPane.showMessageDialog(null,"Memoria creada exitosamente. "
                    + "El tipo de la memoria es Dinamica");  
        }
        else{
            JOptionPane.showMessageDialog(null,"Memoria creada exitosamente. "
                    + "El tipo de la memoria es Estática"); 
        }
    }
    
    public void Mostrar(){
        JOptionPane.showMessageDialog(null,"El tamaño de la memoria es de "+tamaño+" Kb"); 
        Iterator<Particion> it = ListaParticiones.iterator();
        String enLista = "";
        int i = 0;
        while (it.hasNext()) {
            enLista = enLista +"\n"+ "Partición: "+ i + "  " +it.next();
            i++;
        } 
        JOptionPane.showMessageDialog(null,enLista);
    }    
}
