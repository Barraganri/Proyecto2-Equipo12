/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto2_equipo12;

/**
 *
 * @author Barragan
 */
public class NodoExpAri {
    char info;
    NodoExpAri der;
    NodoExpAri izq;
    NodoExpAri padre;

    public NodoExpAri() {
        this.info = ' ';
    }

    public NodoExpAri(char info) {
        this.info = info;
        this.der = this.izq = null;
    }

    public NodoExpAri getPadre() {
        return padre;
    }

    public void setPadre(NodoExpAri padre) {
        this.padre = padre;
    }

    public char getInfo() {
        return info;
    }

    public void setInfo(char info) {
        this.info = info;
    }

    public NodoExpAri getDer() {
        return der;
    }

    public void setDer(NodoExpAri der) {
        this.der = der;
    }

    public NodoExpAri getIzq() {
        return izq;
    }

    public void setIzq(NodoExpAri izq) {
        this.izq = izq;
    }

    @Override
    public String toString() {
        return "NodoExpAri{" + "info=" + info + ", padre=" + padre + '}';
    }
    
    
}
