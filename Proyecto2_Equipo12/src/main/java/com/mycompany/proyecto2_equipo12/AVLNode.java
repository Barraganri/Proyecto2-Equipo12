/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;

public class AVLNode {
    
    int valor, altura;
    AVLNode izq = null;
    AVLNode der = null;
    
    public AVLNode(int data){
        this(data,null,null);
    }
    public AVLNode(int data, AVLNode lt, AVLNode rt){
        valor=data;
        izq = lt;
        der = rt;
        altura=0;
    }   
    
    public void setIzq(AVLNode izq) {
        this.izq = izq;
    }
    
    public void setDer(AVLNode der) {
        this.der = der;
    }

}