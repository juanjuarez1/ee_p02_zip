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
public class Frecuencia implements Comparable<Frecuencia>{
    private char caracter;
    private int frecuencia;
    private String codigo;
    public Frecuencia(char caracter,int frecuencia){
        setFrecuencia(frecuencia);       
        setCaracter(caracter);
    }

    public Frecuencia(int frecuencia){
        setFrecuencia(frecuencia);
    }

    public void setFrecuencia(int frecuencia){
        this.frecuencia=frecuencia;
    }

    public int getFrecuencia(){
        return frecuencia;
    }

    public void setCaracter(char caracter){
        this.caracter=caracter;
    }

    public char getCaracter(){        
        return caracter;
    }

    public void setCodigo(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public int compareTo(Frecuencia f){
        int n=0;
        if(getFrecuencia()<f.getFrecuencia()){
            n=-1;
        }else if(getFrecuencia()>f.getFrecuencia()){
            n=1;
        }
        return n;
    }

    public String toString(){
        String s="";
        s="Caracter:  '"+getCaracter()+"'  Frecuencia:  "+getFrecuencia();
        return s;
    }
}