/*
    Ventana del juego con el hilo del juego y el lienzo donde se dibuja
*/
package Principal;

import Entrada.Teclado;
import Estado.EstadoJuego;
import Graficos.ArchivoActivo;
import LogicaJuego.Juego;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JOptionPane;

public class Ventana extends JFrame implements Runnable{
    public static final int ancho=1300, alto=400;
    private Canvas lienzo;
    private Thread hilojuego;//donde se corre el juego
    
    private BufferStrategy buferobjetos;//
    private Graphics grafico;//graficos
    
    private EstadoJuego estadojuego;//estado de los componentes del juego
    private Teclado teclado;//añade los eventotos del teclado
    
    private final int FPS = 60;//numero máximo de fotogramas por segundo
    private double tiempofotograma = 1000000000/FPS;//tiempo por cada fotograma en nanosegundos
    private double variaciontiempo = 0;//cambio de tiempo entre fotogramas
    private double promedioFPS= FPS;//la cantidad promedio de FPS al ir corriendo el juego
    public static boolean runninggame = false;//estado del juego
            
    public Ventana(){
        this.setTitle("Salta o Muere");
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);//abre al centro de la pantalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);//no redimenzionalbe
        
        
        lienzo = new Canvas();//lienzo donde se dibuja todo el juego
        teclado = new Teclado();
        
        lienzo.setPreferredSize(new Dimension(ancho, alto));//tamaño canva
        lienzo.setMaximumSize(new Dimension(ancho, alto));//tamaño máximo
        lienzo.setMinimumSize(new Dimension(ancho, alto));//tamaño minimo
        lienzo.setFocusable(true);//recibir entradas de teclado
        
        this.add(lienzo);//añade el canva a la ventana
        lienzo.addKeyListener(teclado);//añade al canva un oyente de teclado de la clase Teclado para identificar la tecla presionada
        
        this.setVisible(true);
    }

    public static void setRunninggame(boolean runninggame) {
        Ventana.runninggame = runninggame;
    }
    
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "¿Estás listo para jugar?");
        Ventana ventana = new Ventana();
        ventana.start();
        Ventana ventana2 = new Ventana();
        ventana2.start();
    }
    
    public void inicializar(){//inicializa los componentes necesarios para el juego
        ArchivoActivo.inicializar();//carga todos los recursos en la ventana
        estadojuego = new EstadoJuego();//inicializa el objeto de estado de juego para tener todos los compo inicialesnentes
    }
   
    public void actualizar(){//actualizar el canva
        teclado.actualizar();//actualiza la tecla usada
        estadojuego.actualizar();//actualizamos los componentes del juego
    }
    
    public void dibujar(){
        buferobjetos = lienzo.getBufferStrategy();
        
        if(buferobjetos==null){
            lienzo.createBufferStrategy(3);//3 buffer para el canva
            return;
        }
        
        grafico = buferobjetos.getDrawGraphics();//crea un grafico con el buffer en el canva
        
        //-----------------
        
        grafico.fillRect(0, 0, ancho, alto);//borra el canva anterior
        estadojuego.dibujar(grafico);//dibuja todos los componentes ya inicializados y actualizados en estado de juego pasandole el canva
        grafico.drawString(("FPS: "+promedioFPS),1125,350);//muestra los FPS en el borde de la pantalla
        
        //------------------
        
        grafico.dispose();
        buferobjetos.show();
    }
    
    @Override
    public void run(){
        long tantes = System.nanoTime();//tiempo en llegar al método
        long tahora = 0;
        int fotogramas = 0;
        int tiempo = 0;
        inicializar();
        while(runninggame){
            tahora = System.nanoTime();//tiempo actual del juego cuando llega al while
            variaciontiempo += (tahora-tantes)/tiempofotograma;
            tiempo += (tahora-tantes);
            tantes = tahora;
            System.out.println("Tiempo: "+tiempo);
            if(variaciontiempo >= 1){
                actualizar();//actualiza el canva cada ciclo igual de tiempo
                dibujar();//dibuja el canva ya actualizado
                variaciontiempo--;
                fotogramas++;//aumenta un fotograma si se alcanza el tiempo objetivo
            }
            
            if(tiempo >= 1000000000){//cuando el tiempo es = 1 segundo se actualizan los FPS
                promedioFPS = fotogramas;
                fotogramas = 0;
                tiempo = 0;
            }
        }
        //System.out.println("Se paro");
        stop();
    }
    
    public void start(){
        hilojuego = new Thread(this);
        hilojuego.start();
        runninggame=true;//el juego esta corriendo
    }
    
    public void stop(){
        try{
            //System.out.println("paso por aquí");
            hilojuego.join();
            runninggame=false;//el juego termino de correr
            System.exit(0);
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null,"Se produjo el error: "+e.getMessage());
        }
    }
    
}
