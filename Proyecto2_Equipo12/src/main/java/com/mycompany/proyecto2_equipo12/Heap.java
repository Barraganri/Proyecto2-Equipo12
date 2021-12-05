package com.mycompany.proyecto2_equipo12;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dani_
 */
public class Heap {
    /**
     * Instanciado de variables
     */
    NodoHeap root;
    
    /**
     *Constructor para la declaración de la clase
     */
    public Heap(){
        root=null;
    }

    /**
     * Constructor para la declaración de la clase
     * @param root Nodo que sera la raíz
     */
    public Heap(NodoHeap root) {
        this.root = root;
    }


/**
 * Metodo para agregar un noda al Heap
 * @param hijo Nodo que se agregara
 * @param padre Padre del Nodo que se agregara
 */
    public void agregarNodo(NodoHeap hijo, NodoHeap padre) {
        
        if(root==null){
            root=hijo;
            return;
        }
        
        if (padre.izq == null && padre.der == null) {
            padre.setIzq(hijo);
            swap(padre.izq);
            return;
        }

        if (padre.izq != null && padre.der == null) {
            padre.setDer(hijo);
            swap(padre.der);
            return;
        }

        if (padre.izq != null && padre.der != null) {
            NodoHeap PadreIzq = padre.izq;
            NodoHeap PadreDer = padre.der;
            if (PadreIzq.izq == null || PadreIzq.der == null) {
                agregarNodo(hijo, PadreIzq);
                return;
            }
            if (PadreDer.izq == null || PadreDer.der == null) {
                agregarNodo(hijo, PadreDer);
                return;
            }
            agregarNodo(hijo, PadreIzq.izq);
            return;

        }
        
  
    }
    /**
     * Método para intercambiar nodos dentro del Heap
     * @param hijo Nodo que se ira cambiando de lugar
     */
    private void swap(NodoHeap hijo){
         NodoHeap Padre = Padrebusq(hijo);
        while(Padre.valor<hijo.valor){
             int tmp=hijo.valor;
             hijo.setValor(Padre.valor);
             Padre.setValor(tmp);
  
             swap(Padre);
         }
         
         }
   
    /**
     * Método para intercambiar la raiz(padre) con su hijo más
     * grande
     * @param raiz Nodo raíz del Heap
     */
    private void swapMayor(NodoHeap raiz){
        if(raiz.izq!=null){
           int izquierda=raiz.izq.valor;
            if(raiz.der!=null){
                int derecha=raiz.der.valor;
             
                if(izquierda >raiz.valor && izquierda>derecha){
   
                    raiz.izq.setValor(raiz.valor);
                    raiz.setValor(izquierda);
                    swapMayor(raiz.izq);
                    return;
                }

                if (izquierda > raiz.valor && izquierda < raiz.der.valor) {
                    raiz.der.setValor(raiz.valor);
                    raiz.setValor(derecha);
                    swapMayor(raiz.der);
                    return;
                }
            
            }
            if(izquierda >raiz.valor){
                raiz.izq.setValor(raiz.valor);
                    raiz.setValor(izquierda);
                    return;
            }
            
        }
        
        if(raiz.der!=null){
            int derecha=raiz.der.valor;
            if (derecha>raiz.valor){
                raiz.der.setValor(raiz.valor);
                raiz.setValor(derecha);
                return;
            }
        return;
        }
       
        
    }
    
    /**
     * Método para eliminar a la raíz por medio del intercambio
     */
    public void eliminado() {
        
        if (root==null){
            System.out.println("\nEl Heap no existe");
            return;
        }
         System.out.println("\nSe eliminará la raíz: " + root.valor);
        
        NodoHeap ultimo = ultimo();
        NodoHeap pUltimo = Padrebusq(ultimo);
      
        if (pUltimo.izq==ultimo){
            root.setValor(ultimo.valor);
            pUltimo.setIzq(null);
            swapMayor(root);    
            return;
        }
        if(pUltimo.der==ultimo){
            root.setValor(ultimo.valor);
            pUltimo.setDer(null);
            swapMayor(root);
            return;
        }
        root=null;
          return;
    }
/**
 * Impresión del valor de un Nodo
 * @param n Nodo visitado
 */
    protected void visit(NodoHeap n) {
        System.out.println(n.valor + " ");
    }


        /**
         * Método para encontrar al padre de un Nodo
         * @param buscado Nodo al que se desea buscar el padre
         * @return Padre del nodo 
         */
      public NodoHeap Padrebusq(NodoHeap buscado){
            NodoHeap r = root;
        Queue<NodoHeap> queue = new LinkedList();
        if(r!=null){
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoHeap) queue.poll();
               if(r.izq==buscado||r.der==buscado){
                    return r;
                   
               } 
                if (r.izq != null) {
                    queue.add(r.izq);
                  
                }
                if (r.der != null) {
                    queue.add(r.der);
                   
                } 
            }
            
        }
           return buscado;
        }
   

/**
 * Impresion BFS del Heap
 */
    public void breadthFrist(){
        
        if (root==null){
            System.out.println("\nEl Heap no existe");
            return;
        }
        System.out.println("\nBFS: ");
        
        NodoHeap r = root;
	Queue<NodoHeap> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoHeap) queue.poll();
                visit(r);
                
                if (r.izq != null) {
                    queue.add(r.izq);
                  
                }
                if (r.der != null) {
                    queue.add(r.der);
                   
                }
            }

        }
    }
    
    /**
     * Método utlizado en la eliminación de la raíz para
     * encontrar al nodo en la ultima posición del Heap 
     * para remplazar a la raíz
     * @return Ultimo Nodo de un Heap
     */
    public NodoHeap ultimo(){
        NodoHeap r = root;
        Queue<NodoHeap> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoHeap) queue.poll();
            
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }

        return r;
    }

    @Override
    public String toString() {
        return "Heap{" + "root=" + root + '}';
    }

}
