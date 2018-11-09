
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
    //Fragmentación
    private ArrayList frag_interna;
    private int frag_externa;

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

    public ArrayList getFrag_interna() {
        //En el caso de que no exista, se crea
        if (frag_interna == null){
            Iterator<Particion> ite = ListaParticiones.iterator();
            //Creamos un acumulador para saber el espacio libre entre particiones contínuas
            int acum= 0;
            //Creamos una bandera para guardar el estado de la particion anterior
            boolean flag = false;
            //Creamos una lista para guardar las secciones libres
            ArrayList zonasLibres;
            zonasLibres = new ArrayList();
            while (ite.hasNext()) {
                //Si la partición actual esta vacia
                if (ite.next().isEstado()){
                    //Si la partición anterior estaba ocupada 
                    if (flag == false){
                        //se guarda el valor de esta partición
                        flag = true;
                        //Y se guarda su tamaño en el acumulador
                        acum= ite.next().Tamaño();
                    }
                    //Si la partición anterior estaba vacía
                    else{
                        //Se acumula el tamaño
                        acum = acum + ite.next().Tamaño();
                    }
                }
                //Si la partición actual esta ocupada
                else {
                    //Si la particion anterior estaba vacía
                    if (flag == true){
                        //Se guarda el tamaño
                        zonasLibres.add(acum);
                        //Se guarda el estado de la partición actual
                        flag = false;
                    }                
                }
            }
            frag_interna = zonasLibres;
        }
        return frag_interna;
    }

    public int getFrag_externa() {
        Iterator<Particion> ite = ListaParticiones.iterator();
        int acum= 0;
        while (ite.hasNext()) {
            if (ite.next().isEstado()){
                acum= acum + ite.next().Tamaño();
            }
        }  
        return frag_externa;
    }
    
    //Este es el constructor
    public void CrearMemoria (int _tam, boolean _tipo) {
        tamaño = _tam;
        tipo = _tipo;
        ArrayList <Particion> ListadeParticiones = new ArrayList();
        ListaParticiones = ListadeParticiones;
        //Se crea la primera partición, sea fijo o dinámico debe existir
        Particion part = new Particion();
        //part.CrearParticion(0, tamaño, true);
        //Agregamos la partición creada a la lista
        //ListaParticiones.add(part);
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
