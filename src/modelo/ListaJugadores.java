/*
 * Clase para encapsular el ArrayList de Jugador
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaJugadores implements Serializable{
    //1 - Añadimos la Lista que tiene que ser observable
    //2 - Agregamos la libreria Beans/binding y hacemos el import
    //3- Añadimos una lista que sea Observable e importamos la colección
    private ObservableList<Jugador> lista;
    //4 - Añadimos el consrtuctor vacío
    public ListaJugadores() {
        lista = ObservableCollections.observableList(new ArrayList<Jugador>());
    }
    // ahora crearemos la clase Equipo
    
    
    public static final String PROP_LISTA = "lista";
     
    public ObservableList<Jugador> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Jugador> lista) {
        ObservableList<Jugador> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
   
    

    

}
