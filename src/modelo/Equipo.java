/*
 * Clase Equipo: se establece que un equipo tiene un único entrenador (y un
 * entrenado solo puede pertenecer a un equipo) y que un equipo tiene una lista
 * de jugadores. Cada Jugador solo puede pertenecer a un único equipo.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author usu21
 */
public class Equipo implements Serializable {
    //1 - Creamos los atributos
    private String nombre;
    private String pais;
    private Entrenador entrenador;
    private ListaJugadores jugadores;
    
    //2 - creamos constructor vacio
    public Equipo() {
        nombre="";
        pais="";
        entrenador=new Entrenador();
        jugadores = new ListaJugadores();
    }
    
    
    
    public static final String PROP_JUGADORES = "jugadores";

    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        ListaJugadores oldJugadores = this.jugadores;
        this.jugadores = jugadores;
        propertyChangeSupport.firePropertyChange(PROP_JUGADORES, oldJugadores, jugadores);
    }


    public static final String PROP_ENTRENADOR = "entrenador";

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        Entrenador oldEntrenador = this.entrenador;
        this.entrenador = entrenador;
        propertyChangeSupport.firePropertyChange(PROP_ENTRENADOR, oldEntrenador, entrenador);
    }

    
    public static final String PROP_PAIS = "pais";

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        propertyChangeSupport.firePropertyChange(PROP_PAIS, oldPais, pais);
    }

    public static final String PROP_NOMBRE = "nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
