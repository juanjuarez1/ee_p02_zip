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
import java.io.*;
public class Leer{
    Lista<Character> lista= new Lista<Character>();    
    Lista<NodoArbol<Frecuencia> >lista2= new Lista<NodoArbol<Frecuencia>>();    
    Cola<NodoArbol<Frecuencia>> cola= new Cola<NodoArbol<Frecuencia>>();
    Lista<Frecuencia> resultado= new Lista<Frecuencia>();
    Cola<Character> msj=new Cola<Character>();
    FileReader lector;
    Arbol<Frecuencia> arbol= new Arbol<Frecuencia>();
    String linea;
    String linea2="";
    String encriptado="";
    Pila<String> caracter=new Pila<String>();   
    public void leer(String ruta){//guarda en el string "linea2" todo el texto del archivo                                             
        try{
            FileReader a= new FileReader(ruta);
            BufferedReader lector= new BufferedReader(a);
            linea= lector.readLine();
            while(linea != null){               
                linea2+=linea;
                linea= lector.readLine(); 
            }        
        }catch(IOException e){}
        finally
        {
            try{
                lector.close();
            }catch( Exception ex ){}
        }
        caracteres();
    }

    public void caracteres(){//incresa en "lista" cada caracter de "linea2"
        for(int x=0;x<linea2.length();x++){
            lista.insertarFinal(linea2.charAt(x));
        }
        contar();
    }

    public void contar(){//lee "lista" y cuenta la frecuencia de cada caracter eliminandolos de la misma y guardandolos en "lista2" con su frecuencia hatsa dejar vacia "lista"
        Nodo<Character> temporal=lista.getInicio();
        Nodo<Character> nuevo=temporal;
        Nodo<Character> encontrado=null;
        int contador=0;
        while(temporal!=null){           
            if(temporal.getDato()==nuevo.getDato()){
                contador++;
                encontrado=temporal;
                temporal=temporal.getSiguiente();
                lista.eliminar(encontrado);
            }else{           
                temporal=temporal.getSiguiente();
            }
        }
        lista2.insertarFinal(new NodoArbol(new Frecuencia(nuevo.getDato(),contador)));
        if(!lista.vacia()){             
            contar();
        }       
    }    

    public void insertar(){//inserta en la cola todos los valores de lista2, lease metodo insertar de cola
        Nodo<NodoArbol<Frecuencia>> temporal=lista2.getInicio();
        while(temporal!=null){
            cola.insertar(temporal.getDato());
            temporal=temporal.getSiguiente();
        }              
    }

    public void sacar(){//obtiene el primer y segundo nodo de la cola ordenada y y llama a l metodo sumar
        Nodo<NodoArbol<Frecuencia>> a=cola.inicio();
        cola.retirar();
        Nodo<NodoArbol<Frecuencia>> b=cola.inicio();              
        if(b!=null){                  
            cola.retirar();
            sumar(a.getDato(),b.getDato());            
        }else{                    
            arbol.setRaiz(a.getDato());   
            recorrerArbol();
        }
    }

    public void sumar(NodoArbol<Frecuencia> a,NodoArbol<Frecuencia> b){//suma la frecuencia de a y b y crea la raiz del arbol con su suma de frecuencia y coloca de hijos a "a" y "b" y
                                                                       //coloca al nuevo nodo segun su prioridad raiz donde tenga q ir en la cola, enseguida saca 2 nuevos valores de la cola
        Frecuencia fa=a.getDato();
        Frecuencia fb=b.getDato();
        Frecuencia fc=new Frecuencia(fa.getFrecuencia()+fb.getFrecuencia());
        NodoArbol<Frecuencia> ar=new NodoArbol(fc);
        ar.setIzquierdo(a);
        ar.setDerecho(b); 
        cola.insertar(ar);                    
        sacar(); 
    }
    String s="";
    public void recorrerArbol(){             
        caracter.push(s);
        inorden(arbol.getRaiz());
    }    

    public void inorden(NodoArbol<Frecuencia> r){        
        if(r!=null){
            s+="0";
            caracter.push(s);  
            inorden(r.getIzquierdo()); 
            s=caracter.peek().getDato();            
            s+="1";
            caracter.push(s);  
            inorden(r.getDerecho());                     
        }else{           
            caracter.pop();   
        }

        if(r!=null){
            if(r.getIzquierdo()==null&&r.getDerecho()==null){
                r.getDato().setCodigo(caracter.peek().getDato());
                resultado.insertarInicio(r.getDato());     
            }           
            caracter.pop();
            if(caracter.peek()!=null){
                s=caracter.peek().getDato();   
            }            
        }
    }

    public void comparar(){
        for(int x=0;x<linea2.length();x++){                  
            encriptar(linea2.charAt(x));
        }                
    }

    public void encriptar(char letra){
        Nodo<Frecuencia>temporal=resultado.getInicio();
        while(letra!=temporal.getDato().getCaracter()){
            temporal=temporal.getSiguiente();
        }
        encriptado+=temporal.getDato().getCodigo();        
    }

    public String arbolfinal(){
        NodoArbol<Frecuencia> temporal=arbol.getRaiz();
        s="";
        s+=temporal;       
        return s;
    }

    public void leerEncriptado(String ruta){
        linea2="";linea="";        
        try{
            FileReader a= new FileReader(ruta);
            BufferedReader lector= new BufferedReader(a);
            linea= lector.readLine();
            while(linea != null){               
                linea2+=linea;
                linea=lector.readLine();
            }        
        }catch(IOException e){}       
        finally
        {
            try{
                lector.close();
            }catch( Exception ex ){}
        }      
        for(int x=0;x<linea2.length();x++){
            msj.push(linea2.charAt(x));                                 
        }            
        desencriptar(arbol.getRaiz());
    }
    String mensj="";
    String me="";
    public void desencriptar(NodoArbol<Frecuencia> temp){
        NodoArbol<Frecuencia> temporal=temp;
        boolean flag=true;
        while(!msj.vacia()){
            flag=false;
            char l=msj.peek();
            if(l=='0'){            
                if(temporal.getIzquierdo()!=null){                  
                    temporal=temporal.getIzquierdo();                    
                    msj.pop();
                    desencriptar(temporal);
                }else{
                    mensj+=temporal.getDato().getCaracter();
                    temporal=arbol.getRaiz();
                    System.out.println(mensj);
                    desencriptar(temporal);
                }
            }else if(l=='1'){            
                if(temporal.getDerecho()!=null){                  
                    temporal=temporal.getDerecho();
                    msj.pop();                  
                    desencriptar(temporal);
                }else{
                    mensj+=temporal.getDato().getCaracter();                    
                    temporal=arbol.getRaiz();
                    System.out.println(mensj);
                    desencriptar(temporal);
                }
            }
        }        
        if(flag){            
            mensj+=temporal.getDato().getCaracter();           
            me=mensj;
        }       
    }

    public String mensaje(){
        String mes=me;
        return mes;
    }

    public String NuevoTamaño(){
        int tam=encriptado.length();
        String a=tam+"";
        return a;
    }

    public String Frecuencia(){
        String s="";
        Nodo<NodoArbol<Frecuencia >> temporal=lista2.getInicio();
        Frecuencia f=temporal.getDato().getDato();        
        if(!lista2.vacia()){
            while(temporal!=null){
                s+=f+"\n";                
                temporal=temporal.getSiguiente();
                if(temporal!=null){
                    f=temporal.getDato().getDato();   
                }                                
            }
        }                     
        return s;       
    }

    public String tamaño(){
        int tamaño=linea2.length()*8;
        String a=tamaño+""; 
        return a;
    }

    public String caracter(){
        int tamaño=linea2.length();
        String a=tamaño+""; 
        return a;
    }
}