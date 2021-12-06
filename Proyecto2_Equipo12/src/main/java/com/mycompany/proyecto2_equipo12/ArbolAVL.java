/*Prueba buena
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba3;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tania
 */
public class ArbolAVL {
    
    AVLNode root;  
    
    //------[Métodos que serán llamados en el menú]-------
    
    /**
     * Reasigna el valor de root y manda a llamar a la función insertar
     * @param clave es el valor del nodo
     */
    public void agregar(int clave) {
        root = insertar(root, clave);
    }
    
    /**
     * Reasigna el valor de root y manda a llamar a la función eliminar
     * @param clave es el valor del nodo a eliminar
     */
    public void eliminar(int clave){
        root = eliminarNodo(root, clave);
    }
    
    /**
     * Imprime en pantalla si se encontro o no el elemento, dependiendo del
     * resultado de la busqueda
     * @param clave elemento a buscar
     */
    public void buscar(int clave){
        if (buscarNodo(clave, root)) {
            System.out.println("Se encontro");
        } else{
            System.out.println("El elemento no se encontro");
        }
    }
    
    /**
     * Imprime el valor del nodo
     * @param n nodo en el que se esta situado
     */
    protected void visit(AVLNode n){
        System.out.println(n.valor+" ");
    }	
    
    /**
     * Recorre el árbol con una queue, la cual creará una lista e
     * imprimirá los valores de los nodos que visite, recorriendo 
     * primero el subarbol izquiero y luego el derecho
     */
    public void breadthFrist(){
        AVLNode r = root;
	Queue<AVLNode> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (AVLNode)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    
    
    //--------[Métodos que ayudan a calcular las características del árbol AVL]------
    
    /**
     * Calcula la formula del factor de equilibrio 
     * @param nodo es el nodo del que sacaremos la diferencia de altura
     * @return devuelve la diferencia entre el hijo izquierdo y derecho de nuestro nodo
     */
    private int FE(AVLNode nodo){
        if (nodo == null) {                                                     //SI no existe, retorna -1
            return -1;      
        }
        return height(nodo.izq)-height(nodo.der);                               //si no, retornamos la altura
    }
    
    /**
     * Calcula la altura del nodo
     * @param nodo nodo del que calcularemos la altura
     * @return la altura del nodo
     */
    private int height(AVLNode nodo){
        if (nodo == null) {
            return -1;
        }
        return nodo.altura;
    }
    
    /**
     * Actuliza las alturas de los nodos
     * @param comparar nodo del cual compararemos las alturas de sus hijos
     * @return la altura con el valor más alto
     */
    int actualizar(AVLNode comparar){
       return Math.max(height(comparar.izq), height(comparar.der))+1;
    }
    
    /**
     * consigue el nodo con valor maximo, es decir, el padre.
     * tomamos el hijo que esta mas a la derecha y lo reemplazamos
     * @param nodo nudo que estamos analizando
     * @return nodo más a la derecha
     */
    public AVLNode max (AVLNode nodo){
        AVLNode nodoActual = nodo;
            
        while (nodoActual.der != null) {
            nodoActual = nodoActual.der;
        }
        return nodoActual;
    }
    
    
    //------[Métodos que desarrollan las rotaciones]-------
    
    /**
     * Realiza la rotación simple a la izquierda
     * @param nodoActual nodo que evaluaremos
     * @return el nodo que será la nueva raíz
     */
    public AVLNode rotacionIzq(AVLNode nodoActual){
        //Se guandan los datos
       AVLNode nuevaRaiz = nodoActual.der;
        AVLNode aux = nuevaRaiz.izq;
        
        //Se realiza la rotación
        nuevaRaiz.izq = nodoActual;
        nodoActual.der = aux;
        
        //Se actualiza la altura
        nodoActual.altura = actualizar(nodoActual);
        nuevaRaiz.altura= actualizar(nuevaRaiz);
        
        return nuevaRaiz;
    }
    
    /**
     * Realiza la rotación simple a la derecha
     * @param nodoActual nodo que evaluaremos
     * @return el nodo que será la nueva raíz
     */
    public AVLNode rotacionDer(AVLNode nodoActual){
        
        AVLNode nuevaRaiz = nodoActual.izq;
        AVLNode aux = nuevaRaiz.der;

        nuevaRaiz.der = nodoActual;
        nodoActual.izq = aux;
        
        nodoActual.altura=actualizar(nodoActual);
        nuevaRaiz.altura = actualizar(nuevaRaiz);
        
        return nuevaRaiz;
    }
    
    /**
     * Realiza la rotación doble a la izquierda
     * @param nodoActual nodo que evaluaremos
     * @return el nodo que será la nueva raíz
     */
    public AVLNode rotacionDobleIzq(AVLNode nodoActual){
        AVLNode aux;
        nodoActual.der = rotacionDer(nodoActual.der);
        aux = rotacionIzq(nodoActual);
        return aux;
    }
    
    /**
     * Realiza la rotación doble a la derecha
     * @param nodoActual nodo que evaluaremos
     * @return el nodo que será la nueva raíz
     */
    public AVLNode rotacionDobleDer(AVLNode nodoActual){
        AVLNode aux;
        nodoActual.izq = rotacionIzq(nodoActual.izq);
        aux = rotacionDer(nodoActual);
        return aux;
    }    
    
    
    //------[Métodos que desarrollan las operaciones que realizará nuestro árbol AVL]-------
    
    
    /**
     * Busca el nodo recorriendo el árbol por los hijos derecho o izquierdo,
     * cuando lo encuentra devuelve true or false.
     * @param val valor del nodo que estamos buscando
     * @param nodoActual nodo en el que buscaremos
     * @return 
     */
     public boolean buscarNodo (int val, AVLNode nodoActual){
        if (root == null) {
            return false;                                                       //no existe el nodo
        }
        if (nodoActual.valor == val){
            return true;                                                        //ya se encontro el dato
        }
        if (nodoActual.valor < val && nodoActual.der != null){                   //si el dato es menor al valor
            return buscarNodo(val, nodoActual.der);                             //si no se encontro, se busca por la derecha
        }
        if (nodoActual.valor > val && nodoActual.izq != null){
            return buscarNodo(val, nodoActual.izq);                             //si es mayor, se busca por la izquierda
        }
        return false;
    }
    
    
    
    /**
     * Recorre el árbol comprobando los valores de los nodos e insertandolo
     * en la posición correspondiente
     * @param nodo nodo en el que estaremos situados mientras buscamos la posicion
     * @param clave elemento que insertaremos
     * @return en donde debe insertarse
     */
    public AVLNode insertar (AVLNode nodo, int clave) {
	if(nodo == null) {                                                      //Si el nodo no existe, lo crearemos con la clave dada
	    nodo =  (new AVLNode(clave));
        }
        if (clave < nodo.valor) {                                               //si la clave es menor que el nodo en el que nos ubicamos, revisarmos recursivamente el hijo izquierdo
            nodo.izq = insertar(nodo.izq, clave);
        }else if (clave > nodo.valor) {                                         //Si es mayor, visitaremos recursivamente el hijo derecho, esto siguiendo las reglas del ABB
            nodo.der = insertar (nodo.der, clave);
        }else{                                                                  //Si el valor ya existe, simplemente retornará el nodo, esto por que ABB esperá que no repitamos claves
            return nodo;
        }
        
        nodo.altura = actualizar(nodo);                                         //Se actualiza la altura del nodo
        
        int factor = FE(nodo);                                                  //Para decidir que ordenamiento vamos a usar debemos saber el FE
        
        if (factor > 1 && clave < nodo.izq.valor) {                             //Si el factor es 1 se aplica la rotación simple a la derecha
            return rotacionDer(nodo);
        }
        if (factor < -1 && clave > nodo.der.valor) {                            //Si el factor es -1 se aplica la rotación simple a la izquierda
            return rotacionIzq(nodo);
        }        
        if (factor > 1 && clave > nodo.izq.valor) {                             
            return rotacionDobleDer(nodo);
        }
        if (factor < -1 && clave > nodo.der.valor) {
            return rotacionDobleIzq(nodo);
        }
        return nodo;
    }
	  
    /**
     * Recorre el árbol por ambos subarboles buscando el nodo, cuando lo encuentra
     * determina el caso al que pertenece y lo elimina
     * @param nodoActual nodo en el que nos situaremos 
     * @param clave elemento que buscamos eliminar
     * @return en donde se encuentra
     */
    public AVLNode eliminarNodo (AVLNode nodoActual, int clave) {
        if (nodoActual == null) {
            return nodoActual;
        }
        if (clave < nodoActual.valor) {
            nodoActual.izq = eliminarNodo(nodoActual.izq, clave);
        }else if (clave > nodoActual.valor) {
            nodoActual.der = eliminarNodo(nodoActual.der, clave);
        }else{
                                                                                //una vez encontramos el nodo...
            if ((nodoActual.izq == null) || (nodoActual.der == null)) {         //Para eliminar un nodo hoja o un nodo con un solo hijo
                AVLNode aux = null;
                if (aux == nodoActual.izq) {                                    //si no existe hijo izquierdo
                    aux = nodoActual.der;                                       //guardamos el derehco
                }else{
                    aux = nodoActual.izq;
                }
                if (aux == null) {                                              //No tiene hijos, por lo tanto, solo se elimina
                    nodoActual = null;
                }else{                                                           //Caso en el que el nodo a eliminar tenga hijo
                    nodoActual = aux;                                           //el nodo se elimina, pero lo reemplaza por su hijo
                }
            }else{                                                              //Caso en el que el nodo tenga dos hijos
                AVLNode aux = max(nodoActual.izq);
                nodoActual.valor = aux.valor;
                nodoActual.izq = eliminarNodo(nodoActual.izq, aux.valor);
            }
        }
        
        if (nodoActual == null) {                                               //Caso en el que solo tiene un nodo
            return nodoActual;
        }
      
        nodoActual.altura = actualizar(nodoActual);                             //Se actualiza la altura
        
        int factor = FE(nodoActual);
        
        if (factor > 1 && FE(nodoActual.izq) >=0) {
            return rotacionDer(nodoActual);
        }

        if (factor < -1 &&  FE(nodoActual.der) <=0) {
            return rotacionIzq(nodoActual);
        }

        if (factor > 1 && FE(nodoActual.izq) < 0) {
            return rotacionDobleDer(nodoActual);
        }
        if (factor < -1 && FE(nodoActual.izq) > 0) {
            return rotacionDobleIzq(nodoActual);
        }
        return nodoActual;
    } 
    
}
