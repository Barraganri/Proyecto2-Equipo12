/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;

import java.util.Scanner;

/**
 *
 * @author tania
 */
public class Main {
    public static void main(String[] args) {
       
        ArbolAVL arbol = new ArbolAVL();
        arbol.agregar(27);
        arbol.agregar(19);
        arbol.agregar(34);
        arbol.agregar(10); 
        arbol.agregar(20);
        arbol.agregar(14);
        arbol.agregar(30); 
        arbol.preOrden(arbol.raiz());
        
        Scanner sn = new Scanner(System.in);
        boolean end = false;
        int opcion; 
        System.out.println("\t __ ");
        System.out.println("\t|__). _ _    _ _ . _|     _    _     _ _|_ _ _    _  _ _  _  _ _  _  _");
        System.out.println("\t|__)|(-| )\\/(-| )|(_|)(  (_|  | )|_|(-_)|_| (_)  |_)| (_)(_)| (_||||(_|");
        System.out.println("\t                                                 |       _/"); 
        
        while(!end){         
            System.out.println("\n\t\t-------------------------------------------------");
            System.out.println("\t\t\t¿Qué tipo de árbol desea ejecutar?");
            System.out.println("\t\t-------------------------------------------------");
            System.out.println("\t\t|\t1. Árbol AVL  \t\t\t\t|");
            System.out.println("\t\t|\t2. Heap  \t\t\t\t|");
            System.out.println("\t\t|\t3. Arbol de expresión aritmética\t|");
            System.out.println("\t\t|\t4. Salir  \t\t\t\t|");
            System.out.println("\t\t-------------------------------------------------");
            
            System.out.println("\nElige una opción:     ");
            opcion = sn.nextInt();
            
            switch(opcion){
                case 1:
                    Menu.ArAVL();
                   break;
                case 2:
                    Menu.heap();
                   break;
                case 3:
                    Menu.ArExpAri();
                   break;
                case 4:
                    System.out.println("SALIENDO DEL PROGRAMA\n\n");
                    end = true;
                    break;
                default:
                     System.out.println("Opción no valida");
           }
        }
    }
}

