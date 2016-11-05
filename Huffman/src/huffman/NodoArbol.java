/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Juan Antonio Juarez Olivera
 */
public class NodoArbol<T extends Comparable<T>>implements Comparable<NodoArbol<T>>{
    private T dato;
    private NodoArbol<T> izquierdo,derecho;

    public NodoArbol(T dato){
        this.dato=dato; 
        this.izquierdo=this.derecho=null;       
    }

    public void setDato(T dato){
        this.dato=dato;
    }

    public T getDato(){
        return dato;
    }

    public void setIzquierdo(NodoArbol<T> izquierdo){
        this.izquierdo=izquierdo;
    }

    public NodoArbol<T> getIzquierdo(){
        return izquierdo;
    }

    public void setDerecho(NodoArbol<T> derecho){
        this.derecho=derecho;
    }

    public NodoArbol<T> getDerecho(){
        return derecho;
    }

    public int compareTo(NodoArbol<T> a){
        int x=dato.compareTo(a.getDato());
        return x;
    }

    public String toString(){
        String s="";       
        s+="( "+dato+","+ izquierdo+","+derecho+")";       
        return s;   
    }

    public String a(){
        String s="";
        s+=dato;
        return s;
    }
}
