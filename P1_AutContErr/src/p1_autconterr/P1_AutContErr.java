/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p1_autconterr;

import java.io.FileNotFoundException;

/**
 * @author José Alberto Rincón Mendoza
 */
public class P1_AutContErr {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ObDatos obj = new ObDatos();
        MostradoDatos mostrado = new MostradoDatos();
        CompletarAutomata completado = new CompletarAutomata();
        
        //Proceso
        obj.formulario();
        
        mostrado.mostrarString(obj.titulo);
        mostrado.mostrarArray(obj.estados);
        mostrado.mostrarArray(obj.aceptacion);
        mostrado.mostrarString(obj.inicio);
        mostrado.mostrarArray(obj.alfabeto);
        mostrado.mostrarArrayofArray(obj.transiciones);
        
        completado.completar(obj.titulo,obj.estados,obj.aceptacion,obj.inicio,obj.alfabeto,obj.transiciones);
    }
    
}
