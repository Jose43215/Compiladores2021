/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1_autconterr;

import java.io.File;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;

public class ObDatos {
    //Variabes utiles
    File datosDoc;    
    Scanner obtenedor = new Scanner(in);
    Scanner lector;
    //Arreglos de datos
    String titulo;
    ArrayList estados = new ArrayList();
    ArrayList aceptacion = new ArrayList();
    String inicio;
    ArrayList alfabeto = new ArrayList();
    ArrayList<String[]> transiciones = new ArrayList<String[]>();
    
    
    public void formulario() {
        
        System.out.println("##########Practica 1.- Automata Con Control De Errores#############");
        System.out.println("Ingrese la ruta del archivo de instrucciones:");
        System.out.print(">>");
        datosDoc = new File(obtenedor.next());
        
        try {
            lector = new Scanner(datosDoc);
        }catch(Exception ex) {
            System.out.println("mensaje: "+ex.getMessage());
        }
        
        /*while(lector.hasNextLine()){
            System.out.println(lector.nextLine());
        }*/
        //Obtenemos la descripción del automata
        titulo = lector.nextLine();
        
        //Obtenemos los estados
        String edos = lector.nextLine();
        String[] edosaux = edos.split(",");
        for (int i = 0; i<edosaux.length;i++) {
            estados.add(edosaux[i]);
        }
        
        //obtenemos el o los estados de aceptación
        String edosAcept = lector.nextLine();
        String[] edosAceptaux = edosAcept.split(",");
        for (int i=0; i<edosAceptaux.length;i++){
            aceptacion.add(edosAceptaux[i]);
        }
        
        //Obtenemos el estado inicial
        inicio = lector.nextLine();
        
        //Obtenemos el alfabeto
        String alfabeto = lector.nextLine();
        String[] alfabetoaux = alfabeto.split(",");
        for(int i=0; i<alfabetoaux.length; i++){
            this.alfabeto.add(alfabetoaux[i]);
        }
        
        //Obtenemos tranciciones
        while(lector.hasNext()){
            String transicion = lector.nextLine();
            String[] transicionaux = transicion.split(",");
            this.transiciones.add(transicionaux);
            
        }
    }
    /*C:\Users\pepe-\Documents\NetBeansProjects\P1_AutContErr\automatas\P1.txt*/
}
