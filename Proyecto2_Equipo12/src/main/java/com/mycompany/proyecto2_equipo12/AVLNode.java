/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;

public class AVLNode {
    
    int valor, altura;
    AVLNode izq;
    AVLNode der;
    
    /**
     * Método constructor, reasigna la información, establece el valor inicial
     * de nuestra altura
     * @param data valor del nodo
     */
    public AVLNode(int data){
        valor=data;
        altura = 0;
    } 

}
