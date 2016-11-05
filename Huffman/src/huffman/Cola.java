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
public class Cola<T extends Comparable<T>>{
    private Lista<T> cola= new Lista<T>();
    public void insertar(T dato){//lease listadoble<T> prioridad
        cola.prioridad(dato);
    }   

    public void  retirar(){
        cola.eliminarInicio();
    }

    public Nodo<T> inicio(){
        Nodo<T> a=cola.getInicio();
        return a;
    }

    public T peek(){
        T a=cola.getInicio().getDato();
        return a;
    }

    public void push(T dato){
        cola.insertarFinal(dato);
    }

    public void pop(){//eliminar inicio
        cola.eliminarInicio();     
    }

    public boolean vacia(){
        boolean a=  cola.vacia();
        return a;
    }

    public String toString(){
        String s="";
        s+=cola;
        return s;
    }

}