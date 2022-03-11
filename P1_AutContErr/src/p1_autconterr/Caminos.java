/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1_autconterr;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pepe-
 */
public class Caminos {
    ObDatos obj = new ObDatos();
    int cont =0;
    public void Datos(){
        MostradoDatos mostrar = new MostradoDatos();
        
        obj.datosER();
        mostrar.mostrarString(obj.titulo);
        mostrar.mostrarArray(obj.estados);
        mostrar.mostrarArray(obj.aceptacion);
        mostrar.mostrarString(obj.inicio);
        mostrar.mostrarArray(obj.alfabeto);
        mostrar.mostrarArrayofArray(obj.transiciones);
    }
    
    public void arranque(){
        System.out.println("Ingrese la cadena a evaluar");
        System.out.print(">>>");
        Scanner scan = new Scanner (in);
        String cadena = scan.next();
        
        Caminos(obj.inicio,obj.aceptacion,String.valueOf(cadena.charAt(cont)));
    }
    
    public ArrayList<ArrayList<String>>Caminos(String inicio, ArrayList aceptacion,String caracter){
        Auxiliares aux = new Auxiliares();
        
        //Aquí se guardan los caminos
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        //Este es elcamino actual
        ArrayList<String> camino = new ArrayList<>();
        
        //empezamos por el vertice origen
        camino.add(inicio);
        
        ArrayList<String[]> vecinos = aux.estadosAceptables(inicio,caracter,obj.transiciones);
        for (String[] i : vecinos){
            String act = i[2];
            ArrayList<String> copia = (ArrayList<String>)camino.clone();
            copia.add(act);
            Caminos(act,aceptacion,copia,res,caracter);
            cont++;
        }
        return res;
        
    }
    private void Caminos(String inicio, ArrayList aceptacion,ArrayList<String> camino, ArrayList<ArrayList<String>> res,String caracter){
        Auxiliares aux = new Auxiliares();
        if(inicio.equals(aceptacion.get(0))){
            res.add(camino);
        }else{
            ArrayList<String[]> vecinos = aux.estadosAceptables(inicio,caracter,obj.transiciones);
            if(vecinos != null){
                for (String[] i : vecinos){
                    String act = i[2];
                    ArrayList<String> copia = (ArrayList<String>)camino.clone();
                    if(copia.contains(act)){
                        copia.add(act);
                        Caminos(act,aceptacion,copia,res,caracter);
                        cont++;
                    }
                } 
            }
        }
        
        MostradoDatos mostrar = new MostradoDatos();
        mostrar.mostrarArrayListOfArrayListOfString(res);
    }
    
    public void GestionErrores(ArrayList<String[]> transiciones, ArrayList alfabeto, String inicio, ArrayList aceptacion){
        
    }
}
