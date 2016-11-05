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
public class Lista<T extends Comparable<T>>{
    private Nodo<T> inicio;

    public Nodo<T> getInicio(){
        return inicio;       
    }

    public void setInicio(Nodo<T> inicio){
        this.inicio=inicio;
    }    

    public boolean vacia(){
        return inicio==null;
    }

    public void insertarInicio(T lista){
        Nodo<T> nodo= new Nodo<T>(lista);
        if(!vacia()){            
            nodo.setSiguiente(inicio);
            inicio.setAnterior(nodo);
            inicio=nodo;
        }else
            inicio=nodo;
    }

    public void prioridad(T lista){// inserta en orden de prioridad la informacion
        boolean flag=true;
        Nodo<T> temporal=inicio;
        Nodo<T> anterior=null;
        Nodo<T> nodo= new Nodo<T>(lista);
        if(!vacia()){
            while(temporal.compareTo(nodo)==-1 &&flag){
                anterior=temporal;
                if(temporal.getSiguiente()!=null){
                    temporal=temporal.getSiguiente();
                }else{
                    flag=false;
                    temporal.setSiguiente(nodo);
                    nodo.setAnterior(temporal);
                }
            }
            if(flag){
                if(temporal==inicio){
                    insertarInicio(lista);
                }else{
                    anterior.setSiguiente(nodo);
                    nodo.setAnterior(anterior);
                    nodo.setSiguiente(temporal);
                    temporal.setAnterior(nodo);
                }             
            }
        }else
            inicio=nodo;
    }

    public void insertarFinal(T lista){
        Nodo<T> nodo= new Nodo<T>(lista);
        if(!vacia()){
            Nodo<T> temporal = inicio;
            while(temporal.getSiguiente()!=null){
                temporal=temporal.getSiguiente();
            }
            temporal.setSiguiente(nodo);
            nodo.setAnterior(temporal);
        }else{
            inicio=nodo;
        }
    }

    public void insertarAntesDe(T lista,T referencia){        
        if(!vacia()){                        
            Nodo<T> temporal=inicio;
            boolean flag=true;
            while( temporal.getDato()!=referencia && flag ){
                if(temporal.getSiguiente()!=null){
                    temporal=temporal.getSiguiente();
                }else{
                    flag=false; System.out.println("referencia no encontrada");
                }
            }

            if(flag){
                Nodo<T> nodo= new Nodo<T>(lista);
                Nodo<T> encontrado= temporal.getAnterior();
                encontrado.setSiguiente(nodo);
                nodo.setSiguiente(temporal);
            }                            
        }else
            System.out.println("la lista esta vacia");
    }

    public Nodo<T> buscar(T lista){
        Nodo<T> temporal=null;
        if(!vacia()){
            temporal=inicio;
            boolean flag=true;
            while(lista.compareTo(temporal.getDato())!=0 && flag){
                if(temporal.getSiguiente()!=null){
                    temporal=temporal.getSiguiente();
                }else
                    flag=false; return null;
            }
        }
        return temporal;
    }

    public Nodo<T> ultimo(){
        Nodo<T> nodo=null;
        if(!vacia()){
            nodo=inicio;
            while(nodo.getSiguiente()!=null){
                nodo=nodo.getSiguiente();            
            }
        }
        return nodo;
    }

    public Nodo<T> eliminarUltimo(){
        Nodo<T> nodo=null;
        if(!vacia()){        
            nodo=inicio;
            while(nodo.getSiguiente()!=null){
                nodo=nodo.getSiguiente();            
            }
            if(nodo==inicio){
                nodo=null;
                inicio=null;
            }else{
                nodo=nodo.getAnterior();
                nodo.setSiguiente(null);
            }
        }
        return nodo;
    }

    public void eliminarInicio(){
        if(inicio.getSiguiente()!=null){
            Nodo<T> siguiente=inicio.getSiguiente();
            siguiente.setAnterior(inicio.getAnterior());
            inicio=siguiente;   
        }else{
            inicio=null;
        }
    }

    public void eliminar(Nodo<T> eliminado){
        Nodo<T> temporal=null;
        Nodo<T> anterior=null;
        if(!vacia()){
            temporal=inicio;
            boolean flag=true;
            while(eliminado.getDato().compareTo(temporal.getDato())!=0 && flag){
                anterior=temporal;
                if(temporal.getSiguiente()!=null){
                    temporal=temporal.getSiguiente();
                }else
                    flag=false;
            }

            if(flag){                
                if(temporal.getSiguiente()!=null){
                    if(temporal==inicio){
                        inicio=temporal.getSiguiente();
                    }else{                                     
                        anterior.setSiguiente(temporal.getSiguiente());
                    }
                }else{
                    if(temporal!=inicio){
                        anterior.setSiguiente(null);
                    }else
                        inicio=null;
                }
            }else
                System.out.println("valor no encontrado");

        }
    }    

    public String toString (){
        String s="";
        Nodo<T> temporal=inicio;
        if(!vacia()){
            while(temporal!=null){
                s+=temporal+"\n";
                temporal=temporal.getSiguiente();
            }
        }else{            
            System.out.println("la lista esta vacia");
        }
        return s;
    } 
}

