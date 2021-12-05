package com.mycompany.proyecto2_equipo12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dani_
 */
public class NodoHeap {
    /**
     * Instanciado de Variables
     */
    int valor;
    NodoHeap izq = null;
    NodoHeap der = null;
    
    /**
     * Constructor para la declaracion del Nodo
     */
    public NodoHeap(){
        izq=der=null;
    }
  
    /**
     * Constructor para la declaracion del Nodo
     * @param data Número entero valor del Nodo
     */
    public NodoHeap(int data){
        this(data,null,null);

    }
   /**
    * Constructor para la declaracion del Nodo
    * @param data Número entero valor del Nodo
    * @param lt Hijo izquierdo del Nodo
    * @param rt Hijo derecho del Nodo
    */
    public NodoHeap(int data, NodoHeap lt, NodoHeap rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    /**
     * Método de acceso para asignar el valor del Nodo
     * @param valor Número entero Valor del Nodo
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Método de acceso para asignar el hijo izquierdo del Nodo
     * @param izq Hijo Izquierdo del Nodo
     */
    public void setIzq(NodoHeap izq) {
        this.izq = izq;
    }
    /**
     * Método de acceso para asignar el hijo derecho del Nodo
     * @param der Hijo Derecho del Nodo
     */
    public void setDer(NodoHeap der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return "NODO{" + "valor=" + valor + ", izq=" + izq + ", der=" + der + '}';
    }

    
}
