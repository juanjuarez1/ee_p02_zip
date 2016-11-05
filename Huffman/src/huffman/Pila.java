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
public class Pila<T extends Comparable<T>>{
    private Lista<T> pila= new Lista<T>();
    public void push(T dato){
        pila.insertarFinal(dato);
    }

    public Nodo<T>  pop(){
        Nodo<T> a=pila.eliminarUltimo();
        return a;
    }

    public  Nodo<T>  peek(){
        Nodo<T> a=pila.ultimo();
        return a;
    }

    public Nodo<T> eliminarFinalDevolviendolo(){
        Nodo<T> a=pila.ultimo();
        pila.eliminarUltimo();
        return a;
    }

    public String toString(){
        String s="";
        s+=pila;
        return s;
    }

}