/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaEntrenadores implements Serializable {
    //hacemos una lista observable
    private ObservableList<Entrenador> lista;

    //creamos el constructor
    public ListaEntrenadores() {
        lista = ObservableCollections.observableList(new ArrayList<Entrenador>());
    }
    //añadimos las funciones alta y existe Entrenador
    public void altaEntrenador (Entrenador e){
        lista.add(e);
    }
    
    public boolean existeEntrenador (Entrenador e){
        return lista.contains(e);
    }
            
    //hay que hacer bound para la lista
    public static final String PROP_LISTA = "lista";

    public ObservableList<Entrenador> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Entrenador> lista) {
        ObservableList<Entrenador> oldLista = this.lista;
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
