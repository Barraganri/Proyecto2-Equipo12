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
    NodoHeap root;
    
    
    public Heap(){
        root=null;
    }

    public Heap(int val) {
        root = new NodoHeap(val);
    }

    public Heap(NodoHeap root) {
        this.root = root;
    }



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
        if (padre.izq == null && padre.der != null) {
            padre.setIzq(hijo);
            swap(padre.izq);
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
    
    private void swap(NodoHeap hijo){
         NodoHeap Padre = Padrebusq(hijo);
        while(Padre.valor<hijo.valor){
             int tmp=hijo.valor;
             hijo.setValor(Padre.valor);
             Padre.setValor(tmp);
  
             swap(Padre);
         }
         
         }
   
    
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

    protected void visit(NodoHeap n) {
        System.out.println(n.valor + " ");
    }


        
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

