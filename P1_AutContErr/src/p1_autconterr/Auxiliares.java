/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1_autconterr;

import java.util.ArrayList;

/**
 *
 * @author pepe-
 */
public class Auxiliares {
    //Metodo que devuelve a partir de un estado y un caracter los nodos posibles a encontrar
    public ArrayList<String[]> estadosAceptables (String estado, String caracter, ArrayList<String[]> transiciones){
        ArrayList<String[]> estadosDisponibles = new ArrayList<>();
        
        for(int i=0; i<transiciones.size();i++){
            if(transiciones.get(i)[0].equals(estado) && transiciones.get(i)[1].equals(caracter)){
                estadosDisponibles.add(transiciones.get(i));
            }
        }
        
        return estadosDisponibles;
    }
}
