/*
 * Clase Jugador (hereda de Persona).
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Jugador extends Persona {
    //1 - Añadimos las propiedades
    private String posicion;
    private boolean diestro;

    //2 - Añadimos el constructor vacio
    public Jugador() { //apñadimos Super() y  posicion=""
        super();
        posicion="";
    }
    
    public static final String PROP_DIESTRO = "diestro";

    public boolean isDiestro() {
        return diestro;
    }

    public void setDiestro(boolean diestro) {
        boolean oldDiestro = this.diestro;
        this.diestro = diestro;
        propertyChangeSupport.firePropertyChange(PROP_DIESTRO, oldDiestro, diestro);
    }

    public static final String PROP_POSICION = "posicion";

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        String oldPosicion = this.posicion;
        this.posicion = posicion;
        propertyChangeSupport.firePropertyChange(PROP_POSICION, oldPosicion, posicion);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
