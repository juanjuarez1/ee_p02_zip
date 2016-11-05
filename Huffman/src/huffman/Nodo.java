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
public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>>{
    private T dato;
    private Nodo<T> anterior,siguiente;

    public Nodo(T dato){
        this.dato=dato; 
        siguiente=null;
        anterior=null;
    }

    public void setDato(T dato){
        this.dato=dato;
    }

    public T getDato(){
        return dato;
    }

    public int compareTo(Nodo<T> a){
        int x=dato.compareTo(a.getDato());
        return x;
    }

    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente=siguiente;
    }

    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public void setAnterior(Nodo<T> anterior){
        this.anterior=anterior;
    }

    public Nodo<T> getAnterior(){
        return anterior;
    }

    public String toString(){
        String s="";       
        s+=getDato();
        return s;
    }
}
