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
public class Menu {
    
    public static void ArAVL () {
        
        Scanner teclado = new Scanner(System.in);
        boolean end = false;
        int opcion; 

        while (!end) {
            System.out.println("\n\n");
            System.out.println("\t\t\t     __  __  __     __ __             ");
            System.out.println("\t\t\t /\\ |__)|__)/  \\|  |_ (_    /\\\\  /|  .");
            System.out.println("\t\t\t/--\\| \\ |__)\\__/|__|____)  /--\\\\/ |__.");    

            System.out.println("\n\t\t-------------------------------------------------");
            System.out.println("\t\t\t¿Que tipo de operación desea ejecutar?");
            System.out.println("\t\t-------------------------------------------------");
            System.out.println("\t\t|\t\t1. Agregar clave  \t\t|");
            System.out.println("\t\t|\t\t2. Buscar un valor  \t\t|");
            System.out.println("\t\t|\t\t3. Eliminar clave  \t\t|");
            System.out.println("\t\t|\t\t4. Imprimir arbol  \t\t|");
            System.out.println("\t\t|\t\t5. Salir  \t\t\t|");
            System.out.println("\t\t-------------------------------------------------");
            
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("\n ----[Agregar clave]-----");
                    break;
                case 2:
                    System.out.println("\n ----[Buscar dato]-----");
                    break;
                case 3:
                    System.out.println("\n ----[Eliminar clave]-----");
                    break;
                case 4:
                    System.out.println("\n ----[Imprimir árbol]-----");
                    
                    break;
                case 5:
                    System.out.println("REGRESANDO A MENU PRINCIPAL\n\n");
                    end = true;
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
    }
    
    public static void heap() {
        
       Scanner sc = new Scanner(System.in);
        Scanner valNodo = new Scanner(System.in);
        boolean end = false;
        int opcion;
        int val;
        Heap heap = null;
        NodoHeap nodoUni;

        while (!end) {
            System.out.println("\n\n");
            System.out.println("\t\t\t\t     __     __ ");
            System.out.println("\t\t\t\t|__||_  /\\ |__).");
            System.out.println("\t\t\t\t|  ||__/--\\|   .");    

            System.out.println("\n\t\t-------------------------------------------------");
            System.out.println("\t\t\t¿Que tipo de operación desea ejecutar?");
            System.out.println("\t\t-------------------------------------------------");
            System.out.println("\t\t|\t\t1. Agregar clave  \t\t|");
            System.out.println("\t\t|\t\t2. Eliminar raiz  \t\t|");
            System.out.println("\t\t|\t\t3. Imprimir arbol  \t\t|");
            System.out.println("\t\t|\t\t4. Salir  \t\t\t|");
            System.out.println("\t\t-------------------------------------------------");
            
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                   System.out.println("\n\n ----[Agregar clave]-----");
                    System.out.println("\nIngresa la clave: ");
                    val = valNodo.nextInt();
                    nodoUni = new NodoHeap(val);

                    if (heap != null) {
                        heap.agregarNodo(nodoUni, heap.root);
                    } else {
                        heap = new Heap(nodoUni);
                    }

                    break;
                case 2:
                    System.out.println("\n\n ----[Eliminar raíz]-----");
                    if (heap != null) {
                        heap.eliminado();
                    } else {
                        System.out.println("\nEl Heap no existe\n");
                    } 
                    break;
                case 3:
                   if (heap != null) {
                        heap.breadthFrist();
                    } else {
                        System.out.println("\nEl heap no existe\n");
                    }
                    break;
                case 4:
                    System.out.println("REGRESANDO A MENU PRINCIPAL\n\n");
                    end = true;
                    break;
                default:
                    System.out.println("Opción no valida");
            }


        }
    }
    
     public static void ArExpAri () {
         
        Scanner teclado = new Scanner(System.in);
        boolean end = false;
        int opcion;

        while (!end) {
            System.out.println("\n\n");
            System.out.println("     __  __  __     __ __   __  __   __    __  __  __ __  __            __  ___     _____  __     ");
            System.out.println(" /\\ |__)|__)/  \\|  |_ (_   |  \\|_   |_ \\_/|__)|__)|_ (_ |/  \\|\\ |   /\\ |__)| | |\\/||_  | |/   /\\ .");
            System.out.println("/--\\| \\ |__)\\__/|__|____)  |__/|__  |__/ \\|   | \\ |____)|\\__/| \\|  /--\\| \\ | | |  ||__ | |\\__/--\\."); 

            System.out.println("\n\t\t-------------------------------------------------");
            System.out.println("\t\t\t¿Que tipo de operación desea ejecutar?");
            System.out.println("\t\t-------------------------------------------------");
            System.out.println("\t\t|\t\t1. Ingresar expresión  \t\t|");
            System.out.println("\t\t|\t\t2. Mostrar Arbol  \t\t|");
            System.out.println("\t\t|\t\t3. Resolver  \t\t\t|");
            System.out.println("\t\t|\t\t4. Salir  \t\t\t|");
            System.out.println("\t\t-------------------------------------------------");
            
            System.out.println("\nElige una opcion: ");
            opcion = teclado.nextInt();
            ArbolExpAri arbol = new ArbolExpAri();
            switch (opcion) {
                case 1:
                    System.out.println("\n\n ----[Ingresar expresión]-----");
                   
                    break;
                case 2:
                    System.out.println("\n\n ----[Mostrar Árbol]-----");
                    break;
                case 3:
                    System.out.println("\n\n ----[Resolver]-----");
                    break;
                case 4:
                    System.out.println("REGRESANDO A MENU PRINCIPAL\n\n");
                    end = true;
                    break;
                default:
                    System.out.println("Opción no valida");
            }


        }
    }
}
    

