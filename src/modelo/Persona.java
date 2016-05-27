/*
 * Clase Padre de Entrenador y Jugador
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Persona implements Serializable{
    //creamos los atributos
    private String nombre;
    private String nacionalidad;
    private Date nacimiento;
    
    //creamos el constructor VACIO pq lo necesitamos para el XMLEncoder y para bindear
    public Persona() {
        nombre = "";
        nacionalidad = "";
        nacimiento = new Date();
    }
    
    //Agregamos el metodo equals para Nombre de Persona

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    } //ahora podemos hacer en ListaJugadores la funcion existe
    
    
    public static final String PROP_NACIMIENTO = "nacimiento";

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        Date oldNacimiento = this.nacimiento;
        this.nacimiento = nacimiento;
        propertyChangeSupport.firePropertyChange(PROP_NACIMIENTO, oldNacimiento, nacimiento);
    }

    public static final String PROP_NACIONALIDAD = "nacionalidad";

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        String oldNacionalidad = this.nacionalidad;
        this.nacionalidad = nacionalidad;
        propertyChangeSupport.firePropertyChange(PROP_NACIONALIDAD, oldNacionalidad, nacionalidad);
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
