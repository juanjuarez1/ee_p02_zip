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
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
public class TestMenuJ implements ActionListener
{
    private JFrame Menu,Ventana2,Ventana3, Ventana4,Ventana5,Ventana6;
    private JTextArea textAreal,a,b;
    private JLabel Tam,Car,NuevoTamaño,NuevoFrec,Resultado;
    private JButton comprimir,mostrarArbol,MostrarFrecuencia;
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem Salir, Abrir,Guardar,Descomprimir;
    JFileChooser file = new JFileChooser();
    File archivo;
    Leer main= new Leer();
    String ruta;
    private JScrollPane scroll,scroll2,scroll3;

    public TestMenuJ()
    {
        Menu = new JFrame("Compresor de Huttman");   
        Menu.setLayout(null);
        Menu.setSize(300, 200);
        Menu.setVisible(true);
        Menu.setResizable(false);
        mb=new JMenuBar();
        Menu.setJMenuBar(mb);
        menu1=new JMenu("Opciones");
        
        mb.add(menu1);
        Abrir=new JMenuItem("Abrir...");
        Abrir.setBackground(Color.blue );
        menu1.add(Abrir);
        Abrir.addActionListener(this);        

        Guardar=new JMenuItem("Guardar...");
        Guardar.setBackground(Color.blue);
        menu1.add(Guardar);
        Guardar.addActionListener(this);

        Descomprimir=new JMenuItem("Descomprimir...");
        Descomprimir.setBackground(Color.blue);
        menu1.add(Descomprimir);
        Descomprimir.addActionListener(this);

        Salir=new JMenuItem("Salir...");
        Salir.setBackground(Color.blue);
        menu1.add(Salir);
        Salir.addActionListener(this);
    }

    public void MenuAbrir(String tamaño,String caracteres) {
        Ventana2 = new JFrame("Informacion del archivo"); 
         Ventana2.getContentPane().setBackground(Color.yellow);
        Ventana2.setBounds(0,0,300,200);
        Ventana2.setResizable(false);
        Ventana2.setVisible(true);
        Ventana2.setLayout(null);
        Tam=new JLabel("Tamaño del archivo: "+tamaño+" bits");
        Tam.setBounds(10,20,300,30);
        Ventana2.add(Tam);
        Car=new JLabel("Numero de caracteres: "+caracteres);
        Car.setBounds(10,60,300,30);
        Ventana2.add(Car);
        JButton comprimir=new JButton("Comprimir!!");;//creando variables globales de los botones
        comprimir.setBounds(95,110,100,30);
        Ventana2.add(comprimir);
        comprimir.addActionListener(this);        
    } 

    public void Ventana2(String tamaño){    
        Ventana3 = new JFrame("Informacion actualizada");
       Ventana3.getContentPane().setBackground(Color.green);        
        Ventana3.setBounds(0,0,300,200);

        Ventana3.setLayout(null);

        NuevoTamaño=new JLabel("Nuevo tamaño del archivo: "+tamaño+" bits");
        NuevoTamaño.setBounds(30,10,300,30);
        Ventana3.add(NuevoTamaño);

        JButton mostrarArbol =new JButton("Mostrar Arbol");;//creando variables globales de los botones
        mostrarArbol.setBounds(30,50,200,30);
        Ventana3.add(mostrarArbol);
        mostrarArbol.addActionListener(this);

        JButton MostrarFrecuencia=new JButton("Mostrar Frecuencias");;//creando variables globales de los botones
        MostrarFrecuencia.setBounds(30,90,200,30);
        Ventana3.add(MostrarFrecuencia);
        MostrarFrecuencia.addActionListener(this);

        Ventana3.setVisible(true);
    }

    public void Ventana3(String mensaje){       
        Ventana4 = new JFrame("Texto desencriptado");  
        Ventana4.getContentPane().setBackground(Color.blue);
        Ventana4.setBounds(0,0,500,400);        
        Ventana4.setLayout(new FlowLayout ());   
        textAreal = new JTextArea(mensaje,21,40);        
        textAreal.setPreferredSize(new Dimension (480,390));
        textAreal.setLineWrap (true); 
        textAreal.setWrapStyleWord(true);
        textAreal.setEditable(false);

        scroll3 = new JScrollPane(textAreal);
        Ventana4.add(scroll3);     
        //Ventana4.add(textAreal);       
        Ventana4.setVisible(true);
    }

    public void Ventana4(){       
        Ventana5 = new JFrame("Tabla de frecuencias");   
         Ventana5.getContentPane().setBackground(Color.orange);
        Ventana5.setBounds(0,0,400,350);        
        Ventana5.setLayout(new FlowLayout ());   
        a = new JTextArea(main.Frecuencia(),15,20);     
        //a.setPreferredSize(new Dimension (480,3000));
        a.setLineWrap (true); 
        a.setWrapStyleWord(true);
        a.setEditable(false);//
        scroll = new JScrollPane(a);
        Ventana5.add(scroll);
        //Ventana5.add(textAreal);
        Ventana5.setVisible(true);
    }

    public void Ventana5(){       
        Ventana6 = new JFrame("Arbol:");  
        Ventana4.getContentPane().setBackground(Color.blue);
        Ventana6.setBounds(0,0,400,350);        
        Ventana6.setLayout(new FlowLayout ());   
        b = new JTextArea(main.arbolfinal(),15,20);     
        //b.setPreferredSize(new Dimension (30,480));
        // b.setLineWrap (true); 
        // b.setWrapStyleWord(true);
        b.setEditable(false);//
        scroll2 = new JScrollPane(b);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        Ventana6.add(scroll2);
        //Ventana5.add(textAreal);
        Ventana6.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {       
        if (e.getSource()==Abrir){//abrir    

            file.showOpenDialog(null);
            archivo = file.getSelectedFile();
            try
            {
                String nombre = archivo.getName();
                ruta = archivo.getAbsolutePath();
                main.leer(ruta);
                MenuAbrir(main.tamaño(),main.caracter());
            }catch( Exception exp){}

        }

        if (e.getSource()==Guardar){//Guardar
            try{       
                String nombre="";
                JFileChooser file=new JFileChooser();
                file.showSaveDialog(file);
                File guarda =file.getSelectedFile();
                if(guarda !=null)
                {
                    /*guardamos el archivo y le damos el formato directamente,
                     * si queremos que se guarde en formato doc lo definimos como .doc*/
                    FileWriter  save=new FileWriter(guarda+".txt");
                    save.write(main.encriptado);
                    save.close();
                    JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
            }

        }

        if (e.getSource()==Descomprimir){//descomprimir
            file.showOpenDialog(null);
            archivo = file.getSelectedFile();
            try
            {
                String nombre = archivo.getName();
                ruta = archivo.getAbsolutePath();
                main.leerEncriptado(ruta);              
            }catch( Exception exp){}          
            Ventana3(main. mensaje());
        }

        if (e.getSource()==Salir){//salir           
            System.exit(0);
        }

        if(e.getActionCommand().equals("Comprimir!!")){//podemos comparar por el contenido del boton         
            main.insertar();
            main.sacar();
            main.comparar();
            Ventana2(main.NuevoTamaño());
            Ventana2.dispose();
        } 

        if(e.getActionCommand().equals("Mostrar Arbol")){//podemos comparar por el contenido del boton 
            Ventana5();
        }

        if(e.getActionCommand().equals("Mostrar Frecuencias")){//podemos comparar por el contenido del boton      
            Ventana4();
        } 
    }

    public static void main(String[] args) {              
      TestMenuJ menus = new TestMenuJ();    
    }    
}