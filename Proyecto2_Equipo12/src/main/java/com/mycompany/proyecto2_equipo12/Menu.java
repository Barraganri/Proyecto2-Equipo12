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
    
    /**
     * Imprime el menú de usuario, donde éste podrá elegir entre las 
     * operaciones de un árbol AVL
     */
    public static void ArAVL () {
        
        ArbolAVL arbol = new ArbolAVL();
        
        
        Scanner teclado = new Scanner(System.in);
        boolean end = false;
        int opcion; 
        
        /**
         * Menú que el usuario verá en pantalla con todas las opciones
         */
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
                    System.out.println("\n\n ¿Cuantos nodos desea agregar al árbol?");
                    int nodos = teclado.nextInt();
                    System.out.println("\nIngrese los elementos:");
                    for (int i = 0; i < nodos; i++) {                           //for que se repetirá el número de veces que el usuario desee para agregar nodos
                        int num1 = teclado.nextInt();
                        arbol.agregar(num1);  
                    }
                    break;
                case 2:
                    System.out.println("\n ----[Buscar dato]-----");
                    System.out.println("\n ¿Que elemento busca?");
                    int bus = teclado.nextInt();
                    arbol.buscar(bus);
                    break;
                case 3:
                    System.out.println("\n ----[Eliminar clave]-----");
                    System.out.println("\n ¿Que elemento desea eliminar?");
                    int elem = teclado.nextInt();
                    arbol.eliminar(elem);
                    break;
                case 4:
                    System.out.println("\n ----[Imprimir árbol]-----");
                    System.out.println("El árbol se imprimirá con BFS");
                    arbol.breadthFrist(); 
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
            opcion = sc.nextInt();

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
        Scanner in = new Scanner(System.in);
        boolean end = false;
        int opcion;
        ArbolExpAri arbol = new ArbolExpAri();
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
            
            switch (opcion) {
                case 1:
                    System.out.println("\n\n ----[Ingresar expresión]-----");
                    System.out.println("Ingrese la expresion:");
                    System.out.println("Tome en cuenta los ejemplos dados en el manual");
                    String input = in.nextLine();
                    arbol.constArbol(input);
                    break;
                case 2:
                    System.out.println("\n\n ----[Mostrar Árbol]-----");
                    System.out.println("Impresion de arbol por BFS");
                    arbol.mostrarArbol();
                    break;
                case 3:
                    System.out.println("\n\n ----[Resolver]-----");
                    System.out.println("Solucion:");
                    arbol.evaluar();
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
    

