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
public class MostradoDatos {
    public void mostrarArray(ArrayList miArray){
        System.out.println(miArray.toString());
    }
    
    public void mostrarArrayofArray(ArrayList<String[]> miArray){
        for(int i=0; i<miArray.size(); i++){
            for(int j=0; j<miArray.get(i).length;j++){
                System.out.print(miArray.get(i)[j]+",");
            }
            System.out.print("\n");
        }
    }
    
    public void mostrarString(String miString){
        System.out.println(miString);
    }
}
