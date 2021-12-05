/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Barragan
 */
public class ArbolExpAri {

    public NodoExpAri root;
    public String postfija;

    public ArbolExpAri() {
        postfija = "";
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            return true;
        }
        return false;
    }

    void constArbol(String input) {
        root = new NodoExpAri();
        NodoExpAri nodo = this.root;
        for (int i = 0; i < input.length(); i++) {
            char caracter = input.charAt(i);
            if (caracter == '(') {
                if (nodo.izq == null) {
                    nodo.izq = new NodoExpAri();
                    nodo.izq.setPadre(nodo);
                    nodo = nodo.izq;
                }
                if (nodo.izq != null && nodo.der == null) {
                    nodo.der = new NodoExpAri();
                    nodo.der.setPadre(nodo);
                    nodo = nodo.der;
                }
            } else if (isOperator(caracter)) {
                if (nodo.info != ' ') {
                    if (nodo.getPadre() == null) {
                        nodo.setPadre(new NodoExpAri());
                        nodo.padre.setIzq(nodo);
                    }
                    nodo = nodo.padre;
                }
                nodo.setInfo(caracter);
                nodo.setDer(new NodoExpAri());
                nodo.der.setPadre(nodo);
                nodo = nodo.der;
            } else if (!isOperator(caracter) && caracter != ')') {
                if (i - 1 >= 0) {
                    if (input.charAt(i - 1) == ')') {
                        if (nodo.izq == null) {
                            nodo.izq = new NodoExpAri();
                            nodo.izq.setPadre(nodo);
                            nodo = nodo.izq;
                        }
                        nodo = nodo.izq;
                    }
                }
                nodo.setInfo(caracter);
                if (nodo.padre == null) {
                    nodo.setPadre(new NodoExpAri());
                    nodo.padre.setIzq(nodo);
                }
                nodo = nodo.padre;

            } else if (caracter == ')') {
                if (nodo.padre == null) {
                    nodo.setPadre(new NodoExpAri());
                    nodo.padre.setIzq(nodo);
                }
                nodo = nodo.padre;
            }
        }
        NodoExpAri aux = root;
        while (aux != null && aux.padre != null) {
            aux = aux.padre;
        }
        this.root = aux;
    }

    void mostrarArbol() {
        NodoExpAri r = root;
        Queue<NodoExpAri> queue = new LinkedList();
        System.out.println("Impresion por BFS del arbol:");
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoExpAri) queue.poll();
                System.out.print(r.getInfo());
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
    }

    void visit() {

    }

    void postorden(NodoExpAri nodo) {
        if (nodo.izq != null) {
            postorden(nodo.izq);
        }
        if (nodo.der != null) {
            postorden(nodo.der);
        }
        postfija = postfija + "" + nodo.info;
    }

    void evaluar() {
        Stack<Integer> pila = new Stack();
        int aux1 = 0, aux2 = 0, res = 0;
        postorden(root);
        System.out.println("Expresion Postfija:");
        System.out.println(postfija);
        System.out.println("\nResultado:");
        for (int i = 0; i < postfija.length(); i++) {
            char caracter = postfija.charAt(i);
            if (isOperator(caracter)) {
                aux1 = pila.pop();
                aux2 = pila.pop();
                res = operacion(caracter, aux1, aux2);
                pila.push(res);
            } else {
                int num = Character.getNumericValue(caracter);
                pila.push(num);
            }
        }
        System.out.println(res);
    }

    int operacion(char c, int a, int b) {
        int resultado;
        switch (c) {
            case '+' -> {
                resultado = a + b;
                return resultado;
            }
            case '-' -> {
                resultado = a - b;
                return resultado;
            }
            case '*' -> {
                resultado = a * b;
                return resultado;
            }
            case '/' -> {
                resultado = a / b;
                return resultado;
            }
            case '%' -> {
                resultado = a % b;
                return resultado;
            }
        }
        return -1;
    }

}
