package com.mycompany.proyecto2_equipo12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class NodoHeap {
    
    int valor;
    NodoHeap izq = null;
    NodoHeap der = null;
    
    public NodoHeap(){
        izq=der=null;
    }
  
    public NodoHeap(int data){
        this(data,null,null);

    }
    
    public NodoHeap(NodoHeap n){
        this(n.valor,n.izq,n.der);
    }
     
    public NodoHeap(int data, NodoHeap lt, NodoHeap rt){
        valor=data;
        izq = lt;
        der = rt;
    }   

    public void setValor(int valor) {
        this.valor = valor;
    }


    public void setIzq(NodoHeap izq) {
        this.izq = izq;
    }
    
    public void setDer(NodoHeap der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return "NODO{" + "valor=" + valor + ", izq=" + izq + ", der=" + der + '}';
    }

    
}
