
package simulador.de.procesos;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Asignador {
    private int algoritmo;
     int finalparticion =0;
     int cont =0;

    public int getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(int algoritmo) {
        this.algoritmo = algoritmo;
    }
    
    //Funcion que crea una nueva partición
    ArrayList Particionar (Memoria _mem, int _tamParticion){
        
        //Vamos a devolver la lista de particiones nueva que creamos aca
        ArrayList <Particion> NuevaListaParticiones;
        
        //La lista actual la copiamos para trabajar mejor
        NuevaListaParticiones = (ArrayList<Particion>) _mem.getListaParticiones();
        
        int total, inicio, fin;
        //Para este ejemplo suponemos una memoria vacía
        inicio=0;
        //Para este ejemplo, el fin es el tamaño de la particion pero si ya existen otras
        //debería tener eso en cuenta
        fin=_tamParticion;
        if (_mem.getTamaño() >= _tamParticion){
            Particion particion = new Particion();
            particion.CrearParticion(inicio, fin, true);
            NuevaListaParticiones.add(particion);
        }
        //Si la persona pone un valor muy alto ponemos lo máximo que tengamos
        if(_mem.getTamaño() < _tamParticion){
            JOptionPane.showMessageDialog(null,"Excedió el tamaño de la memoria."); 
            //Hace falta un método en la clase memoria que diga memoria disponible.
        }
        return NuevaListaParticiones;
    }
    //Desfragmentar: las particiones vacías consecutivas se convierten en una sola
    //Sólo es válido para partiocionamiento que no sea estático
    public void Desfragmentar (Memoria _mem){
        
    }
    
    //Asigna un proceso a una partición creada
    Memoria Asignar (Memoria _mem, Proceso _proceso){
        Memoria memoria = new Memoria();
        ArrayList <Particion> listaParticionesNueva;
                    listaParticionesNueva = _mem.getListaParticiones();
                    
                    //Bucle de selección de algoritmo según elección del usuario
                    Iterator<Particion> it = listaParticionesNueva.iterator();
                    int posicion = 0;//POSICION DE LA LISTA DE PARTICIONES
                    boolean banderita = true;//bandera para controlar el while
                    boolean banderaBF = true;
                    int resg1 = 99999;
                    int resg2 = 99999;
                    
         switch (algoritmo){
                case(1): //Algoritmos bf
                    //Creo variables de trabajo
                    
                    while (it.hasNext() && (banderita) ) {
                       if(_mem.isTipo()){ //Si es Variable
                            if(_mem.getListaParticiones().isEmpty()){ //La primera vez cuando no hay particiones
                                it.next().CrearParticion(0, _proceso.getTamaño(), true);
                                _mem.getListaParticiones().add(it.next());
                                it.next().setProces(_proceso);
                                finalparticion = it.next().getFin();
                                cont = cont + finalparticion;
                            }
                            else{
                                if((cont + _proceso.getTamaño()) <= _mem.getTamaño()){
                                    it.next().CrearParticion(finalparticion+1, finalparticion + _proceso.getTamaño(), true);
                                    _mem.getListaParticiones().add(it.next());
                                    it.next().setProces(_proceso);
                                    finalparticion = it.next().getFin();
                                    cont = cont + _proceso.getTamaño();
                                }
                             }
                        }    
                       else{ //Si es Fija
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()<resg1){
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                    }
                                } 
                               
                            }
                        }
                       posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                    }
                    if(resg1!=99999) {
                      listaParticionesNueva.get(resg2).setProces(_proceso); //Pone el proceso en la lista de particiones
                     //Pone el proceso en la lista de particiones
                     banderita = false; //bandera para que no vuelva a entrar en el while
                    }
                    memoria = _mem;
                    
                break;
                case (2)://ff
                    while (it.hasNext() && (banderita) ) {
                       if(_mem.isTipo()){ //Si es Variable
                            if(_mem.getListaParticiones().isEmpty()){ //La primera vez cuando no hay particiones
                                it.next().CrearParticion(0, _proceso.getTamaño(), true);
                                _mem.getListaParticiones().add(it.next());
                                it.next().setProces(_proceso);
                                finalparticion = it.next().getFin();
                                cont = cont + finalparticion;
                            }
                            else{
                                if((cont + _proceso.getTamaño()) <= _mem.getTamaño()){
                                    it.next().CrearParticion(finalparticion+1, finalparticion + _proceso.getTamaño(), true);
                                    _mem.getListaParticiones().add(it.next());
                                    it.next().setProces(_proceso);
                                    finalparticion = it.next().getFin();
                                    cont = cont + _proceso.getTamaño();
                                }
                             }
                        }    
                       else{ //Si es Fija
                           
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                //aca preguntamos si lo que tenemos en el resguardo, es de tamaño mayor a la actual
                                listaParticionesNueva.get(posicion).setProces(_proceso); //Pone el proceso en la lista de particiones
                                banderita = false; //bandera para que no vuelva a entrar en el while
                            }
                        }
                       posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                       
                    }
                    
                    memoria = _mem;
                    
                    
                break;
                case (3): //WF
                    while (it.hasNext() && (banderita) ) {
                       if(_mem.isTipo()){ //Si es Variable
                            if(_mem.getListaParticiones().isEmpty()){ //La primera vez cuando no hay particiones
                                it.next().CrearParticion(0, _proceso.getTamaño(), true);
                                _mem.getListaParticiones().add(it.next());
                                it.next().setProces(_proceso);
                                finalparticion = it.next().getFin();
                                cont = cont + finalparticion;
                            }
                            else{
                                if((cont + _proceso.getTamaño()) <= _mem.getTamaño()){
                                    it.next().CrearParticion(finalparticion+1, finalparticion + _proceso.getTamaño(), true);
                                    _mem.getListaParticiones().add(it.next());
                                    it.next().setProces(_proceso);
                                    finalparticion = it.next().getFin();
                                    cont = cont + _proceso.getTamaño();
                                }
                             }
                        }    
                       else{ //Si es Fija
                           Particion partaux = it.next(); //particion auxiliar donde guardamos la particion que esta en es momento en la lista de particiones
                           
                            if(partaux.isEstado()&& partaux.Tamaño()>= _proceso.getTamaño()){ //Si la particion esta vacia, y el proceso entra ahi hace lo siguiente
                                if(banderaBF){
                                    resg1= partaux.Tamaño();
                                    resg2= posicion;
                                    banderaBF = false;
                                }
                                else{
                                    if(partaux.Tamaño()>resg1){
                                        resg1= partaux.Tamaño();
                                        resg2= posicion;
                                    }
                                } 
                               
                            }
                        }
                       posicion ++; //aumentamos la variable que indica en que posicion de la lista de particiones asignar el proceso
                    }
                    if(resg1!=99999) {
                      listaParticionesNueva.get(resg2).setProces(_proceso); //Pone el proceso en la lista de particiones
                     //Pone el proceso en la lista de particiones
                     banderita = false; //bandera para que no vuelva a entrar en el while
                    }
                    memoria = _mem;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "404: Not found inteligencia en ti, vuelve a intentar");
                break;
            }
        return memoria;
    }
    //Acá van los algoritmos BESTFIT, WORSTFIT Y FIRSTFIT como métodos
        
}
