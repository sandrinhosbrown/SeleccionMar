/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleccionmar;

import java.awt.peer.MenuPeer;
import modelo.ListaEntrenadores;
import modelo.ListaJugadores;
import utilidades.Fichero;
import vista.MenuPrincipal;

/**
 *
 * @author usu21
 */
public class SeleccionMar {

    public static ListaJugadores todosJugadores;
    public static Fichero ficheroJugadores;
    public static ListaEntrenadores todosEntrenadores;
    public static Fichero ficheroEntrenadores;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //vamos creando los objetos que vamos necesitando
        //Creamos package Modelo
        //Creamos package Vista, creamos el MenuPrincipal y lo llamamos aquí
        ficheroJugadores = new Fichero("Jugadores.xml");
        todosJugadores = (ListaJugadores) ficheroJugadores.leer();
        if(todosJugadores == null ){
            todosJugadores = new ListaJugadores();
        }
        ficheroEntrenadores = new Fichero("Entrenadores.xml");
        todosEntrenadores = (ListaEntrenadores) ficheroEntrenadores.leer();
        if(todosEntrenadores == null ){
            todosEntrenadores = new ListaEntrenadores();
        }
        //...
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        //volvemos al MenuPrincipal.java 
    }
    
}
