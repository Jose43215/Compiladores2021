/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1_autconterr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author pepe-
 */

public class CompletarAutomata {
    //Lectura y escritura
    File datosDoc;
    FileWriter escribir;
    BufferedWriter bescribir;
    PrintWriter pescribir;
    
    //Variables usables
    ArrayList estados2 = new ArrayList();
    ArrayList<String[]> transiciones2 = new ArrayList<String[]>();
    int cont = 0;
    
    public void completar(String titulo, ArrayList estados, ArrayList aceptacion, String inicio, ArrayList alfabeto, ArrayList<String[]> transiciones){
        
        for(int i=0; i<alfabeto.size();i++){
            for(int j=0; j<estados.size();j++){
                cont =0;
                for(int k=0; k<transiciones.size(); k++){

                    if((transiciones.get(k)[0].equals(estados.get(j).toString()))&&(transiciones.get(k)[1].equals(alfabeto.get(i)))){
                            transiciones2.add(transiciones.get(k));
                            cont++;
                    }
                }
                
                if(cont == 0){
                    String[] transicionaux = {estados.get(j).toString(),alfabeto.get(i).toString(),"ER"};
                    transiciones2.add(transicionaux);
                }
            }
        }
        
        //baciar enestados 2 el nuevo obtenido
        for (int i = 0; i < estados.size(); i++) {
            estados2.add(estados.get(i));
        }
        //Agregar el estado ER
        estados2.add("ER");
        
        //completar transiciones ER
        for(int i=0; i<alfabeto.size();i++){
            String[] trans = {"ER",alfabeto.get(i).toString(),"ER"};
            transiciones2.add(trans);
        }
        
        
        CompletarAutomata completar = new CompletarAutomata();
        completar.escribir("PERmod", titulo,estados2,aceptacion, inicio, alfabeto, transiciones2);
    }
    
    public void escribir (String nombre, String titulo, ArrayList estados, ArrayList aceptacion, String inicio, ArrayList alfabeto, ArrayList<String[]> transiciones){
        try{
            datosDoc = new File("C:\\Users\\pepe-\\Documents\\NetBeansProjects\\P1_AutContErr\\automatas\\"+nombre+".txt");
            escribir = new FileWriter(datosDoc);
            bescribir = new BufferedWriter(escribir);
            pescribir = new PrintWriter(bescribir);
            
            //Escribimos titulo
            pescribir.write(titulo);
            //Segunda linea (estados)
            pescribir.println();
            for(int i=0; i<estados.size(); i++){
                if(i==estados.size()-1){
                    pescribir.append(estados.get(i).toString());
                }else{
                    pescribir.append(estados.get(i).toString()+",");
                }
            }
            //tercera linea aceptación
            pescribir.println();
            for(int i=0; i<aceptacion.size(); i++){
                if(i==aceptacion.size()-1){
                    pescribir.append(aceptacion.get(i).toString());
                }else{
                    pescribir.append(aceptacion.get(i).toString()+",");
                }
            }
            //Cuarta linea inicial
            pescribir.println();
            pescribir.append(inicio);
            //quinta linea
            pescribir.println();
            for(int i=0; i<alfabeto.size(); i++){
                if(i==alfabeto.size()-1){
                    pescribir.append(alfabeto.get(i).toString());
                }else{
                    pescribir.append(alfabeto.get(i).toString()+",");
                }
            }
            //transiciones
            pescribir.println();
            for(int i=0; i<transiciones.size();i++){
                pescribir.append(transiciones.get(i)[0]+","+transiciones.get(i)[1]+","+transiciones.get(i)[2]);
                pescribir.println();
            }
            
            pescribir.close();
            bescribir.close();
        
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
