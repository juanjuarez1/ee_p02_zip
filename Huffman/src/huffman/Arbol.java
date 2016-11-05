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
import java.util.*;
public class Arbol<T extends Comparable<T>>{    
    NodoArbol<T> raiz;

    public void setRaiz(NodoArbol<T> raiz){
        this.raiz=raiz;
    }

    public NodoArbol<T> getRaiz(){
        return raiz;
    }

    public void preorden(NodoArbol <T> r){       
        if(r!=null){           
            System.out.println(r.getDato());          
            preorden(r.getIzquierdo());           
            preorden(r.getDerecho());
        }
    }

    public void inorden(NodoArbol<T> r){        
        if(r!=null){            
            inorden(r.getIzquierdo() );
            System.out.println(r.getDato());
            inorden(r.getDerecho());
        }
    }

    public void posorden(NodoArbol<T> r){       
        if(r!=null){         
            posorden(r.getIzquierdo());        
            posorden(r.getDerecho());
            System.out.println(r.getDato());
        }
    }

    public Arbol llenar(NodoArbol<Integer> posicion){
        NodoArbol<Integer>nodo=posicion;
        int respuesta;
        int valor;
        System.out.println("insertar datos a la izquieda? si(1)");
        Scanner sc= new Scanner(System.in);   respuesta=sc.nextInt();

        if(respuesta==1){
            System.out.println("ingrese valor:");
            valor=sc.nextInt();
            nodo.setIzquierdo(new NodoArbol<Integer>(valor));
            llenar(nodo.getIzquierdo());         
            System.out.println("insertar datos por la derecha ?si(1)");
            respuesta=sc.nextInt();
            if(respuesta==1){
                System.out.println("ingrese valor: ");
                valor=sc.nextInt();
                nodo.setDerecho(new NodoArbol<Integer>(valor));
                llenar(nodo.getDerecho());
            }            
        }else{
            System.out.println("insertar datos a la derecha? si(1)");
            respuesta=sc.nextInt();
            if(respuesta==1){
                System.out.println("ingrese valor: ");
                valor=sc.nextInt();
                nodo.setDerecho(new NodoArbol<Integer>(valor));
                llenar(nodo.getDerecho());
                System.out.println("insertar datos por la derecha ?si(1)");
                respuesta=sc.nextInt();
                if(respuesta==1){
                    System.out.println("ingrese valor: ");
                    valor=sc.nextInt();
                    nodo.setDerecho(new NodoArbol<Integer>(valor));
                    llenar(nodo.getDerecho());
                }            

            }
        }           
        return this;
    }
}