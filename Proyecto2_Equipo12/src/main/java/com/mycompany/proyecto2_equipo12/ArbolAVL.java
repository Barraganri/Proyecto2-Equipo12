/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;



/**
 *
 * @author tania
 */
public class ArbolAVL {
   
    AVLNode root;
    
    
    public ArbolAVL(){
        root=null;
    }
    
    public ArbolAVL(int val){
        root=new AVLNode(val);
    }
    
    public ArbolAVL(AVLNode root){
        this.root=root;
    }
    
    /*Método para realizar la rotación simple a la derecha*/
    public boolean buscar (int val, AVLNode nodoActual){
        if (root == null) {
            return false; //no existe el nodo
        }else if (nodoActual.valor == val){
            return true; //ya se encontro el dato
        }else if (nodoActual.valor < val){//si el dato es menor al valor
            return buscar(val, nodoActual.der); //si no se encontro, se busca por la derecha
        }else{
            return buscar(val, nodoActual.izq);//si es mayor, se busca por la izquierda
        }
    }
    
   public void preOrden(AVLNode root){
        if (root!=null) {
            System.out.println(root.valor);            
            preOrden(root.izq);
            preOrden(root.der);
        }
    }
    
    public void agregar(int clave){
        root = insertar(clave, root);
    }
    
    public void eliminar(int clave){
        root = insertar(clave, root);
    }
    
    //método para obtener la altura del arbol
    private int FE(AVLNode nodo){
        if (nodo == null) { //SI no existe, retorna -1
            return -1;      
        }
        return (height(nodo.izq)-height(nodo.der)); //si no, retornamos la altura
    }
    
    private int height(AVLNode nodo){
        if (nodo == null) {
            return -1;
        }
        return nodo.altura;
    }
    
    /*Método para realizar la rotación simple a la izquierda
    */
    public AVLNode rotacionIzq(AVLNode nodoActual){
        AVLNode nuevaRaiz = nodoActual.der;
        AVLNode aux = nodoActual.izq;
        
        nodoActual.izq = nodoActual;
        nodoActual.der = aux;
        
        nodoActual.altura = Math.max(height(nodoActual.izq), height(nodoActual.der))+1;
        nuevaRaiz.altura= Math.max(height(aux.izq), height(aux.der))+1;
        
        return nuevaRaiz; 
    }
    
    /*Método para realizar la rotación simple a la izquierda
    */
    public AVLNode rotacionDer(AVLNode nodoActual){
        AVLNode nuevaRaiz = nodoActual.izq;
        AVLNode aux = nodoActual.der;
        
        //
        nuevaRaiz.der = nodoActual;
        nodoActual.izq = aux;
        
        //Se actualiza la altura
        nodoActual.altura = Math.max(height(nodoActual.izq), height(nodoActual.der))+1;
        nuevaRaiz.altura= Math.max(height(nuevaRaiz.izq), height(nuevaRaiz.der))+1;
        
        return nuevaRaiz; 
    }
    
    public AVLNode rotacionDobleIzq(AVLNode nodoActual){
        AVLNode aux;
        nodoActual.izq = rotacionDer(nodoActual.izq);
        aux = rotacionIzq(nodoActual);
        return aux;
    }
    
    public AVLNode rotacionDobleDer(AVLNode nodoActual){
        AVLNode aux;
        nodoActual.der = rotacionIzq(nodoActual.der);
        aux = rotacionDer(nodoActual);
        return aux;
    }    
    
    //Método para insertar un nodo en un árbol AVL, este es
    //exactamente el mismo que con los ABB
    public AVLNode insertar (int clave, AVLNode nodo) {
        //Si el nodo no existe, lo crearemos con la clave dada
	if(nodo == null) {
	    nodo = new AVLNode(clave);
        }
        //si la clave es menor que el nodo en el que nos ubicamos,
        //revisarmos recursivamente el hijo izquierdo
        if (clave < nodo.valor) {
            nodo.izq = insertar(clave, nodo.izq);
        //Por el contrario, si es mayor, visitaremos recursivamente
        //el hijo derecho, esto siguiendo las reglas del ABB
        }else if (clave > nodo.valor) {
            nodo.der = insertar (clave, nodo.der);
        }else{
            //Si el valor ya existe, simplemente retornará el nodo
            //Esto por que ABB esperá que no repitamos claves
            return nodo;
        }
        
        /*A continuación, la caracteristica del arbol AVL, es que
        este equilibrado, por lo tanto actualizaremos la altura*/
        
        nodo.altura = Math.max(height(nodo.izq), height(nodo.der))+1;
        
        //Para decidir que ordenamiento vamos a usar debemos saber el FE
        int factor = FE(nodo);
        
        //Si el factor es 1 se aplica la rotación simple a la derecha
        if (factor > 1 && clave < nodo.izq.valor) {
            return rotacionDer(nodo);
        }
        //Si el factor es -1 se aplica la rotación simple a la izquierda
        if (factor < -1 && clave > nodo.der.valor) {
            return rotacionIzq(nodo);
        }
        //se combinan condiciones, (en estos casos el arbol esta en zigzag)
        
        if (factor > 1 && clave > nodo.izq.valor) {
            return rotacionDobleDer(nodo);
        }
        if (factor < -1 && clave < nodo.der.valor) {
            return rotacionDobleIzq(nodo);
        }
        return nodo;
    }
	  
    
    public AVLNode eliminarNodo (AVLNode nodoActual, int clave){
        //en caso de que el nodo sea nulo
        if (nodoActual == null) {
            return nodoActual;
        }
        //navega por izquierda o derecha
        if (clave < nodoActual.valor) {
            nodoActual.izq = eliminarNodo(nodoActual.izq, clave);
        }else if (clave > nodoActual.valor) {
            nodoActual.der = eliminarNodo(nodoActual.der, clave);
        }else{
            //una vez encontramos el nodo...
            //Para eliminar un nodo hoja o un nodo con un solo hijo
            if ((nodoActual.izq == null) || (nodoActual.der == null)) { //si tiene hijo izq o der
                AVLNode aux = null;
                if (aux == nodoActual.izq) { //si no existe hijo izquierdo
                    aux = nodoActual.der; //guardamos el derehco
                }else{
                    aux = nodoActual.izq;
                }
                //No tiene hijos, por lo tanto, solo se elimina
                if (aux == null) {
                    nodoActual = null;
                }else{
                //Caso en el que el nodo a eliminar tenga hijo
                    nodoActual = aux; //el nodo se elimina, pero lo reemplaza por su hijo
                }
            }else{
                //Caso en el que el nodo tenga dos hijos, buscamos al predecesor
                AVLNode aux = max(nodoActual.izq);
                //actualizamos el valor del predecesor
                nodoActual.valor = aux.valor;
                //Eliminamos el predecesor
                nodoActual.izq = eliminarNodo(nodoActual.izq, aux.valor);
            }
        }
        
        //Caso en el que solo tiene un nodo
        if (nodoActual == null) {
            return nodoActual;
        }
        
        //Se actualiza la altura
        nodoActual.altura = Math.max(height(nodoActual.izq), height(nodoActual.der))+1;
        
        int factor = FE(nodoActual);
        
        //Al igual que en insertar, 
        //rotación simple a la derecha
        if (factor > 1 && FE(nodoActual.izq) >=0) {
            return rotacionDer(nodoActual);
        }

        if (factor < -1 &&  FE(nodoActual.der) <=0) {
            return rotacionIzq(nodoActual);
        }

        if (factor > 1 && FE(nodoActual.izq) < 0) {
            return rotacionDobleIzq(nodoActual);
        }
        if (factor < -1 && FE(nodoActual.izq) > 0) {
            return rotacionDobleDer(nodoActual);
        }
        return nodoActual;
    } 
    
    /*Método que consigue el nodo con valor maximo, es decir, el padre.
    Tomamos el hijo que esta mas a la derecha y lo reemplazamos*/
     public AVLNode max (AVLNode nodo){
            AVLNode nodoActual = nodo;
            
            while (nodoActual.der != null) {
                nodoActual = nodoActual.der;
            }
            return nodoActual;
        }
     
     public AVLNode raiz(){
         return root;
     }
}
