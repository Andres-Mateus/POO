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
    private Thread hilojuego;
    
    private BufferStrategy buferobjetos;
    private Graphics grafico;
    
    private EstadoJuego estadojuego;
    private Teclado teclado;
    
    private final int FPS = 60;
    private double tiempofotograma = 1000000000/FPS;
    private double variaciontiempo = 0;
    private double promedioFPS= FPS;
    public static boolean runninggame = false;
            
    public Ventana(){
        this.setTitle("Salta o Muere");
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        lienzo = new Canvas();
        teclado = new Teclado();
        
        lienzo.setPreferredSize(new Dimension(ancho, alto));
        lienzo.setMaximumSize(new Dimension(ancho, alto));
        lienzo.setMinimumSize(new Dimension(ancho, alto));
        lienzo.setFocusable(true);
        
        this.add(lienzo);
        lienzo.addKeyListener(teclado);
        
        this.setVisible(true);
    }

    public static void setRunninggame(boolean runninggame) {
        Ventana.runninggame = runninggame;
    }
    
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "¿Estás listo para jugar?");
        Ventana ventana = new Ventana();
        ventana.start();
    }
    
    public void inicializar(){
        ArchivoActivo.inicializar();
        estadojuego = new EstadoJuego();
    }
   
    public void actualizar(){
        teclado.actualizar();
        estadojuego.actualizar();
    }
    
    public void dibujar(){
        buferobjetos = lienzo.getBufferStrategy();
        
        if(buferobjetos==null){
            lienzo.createBufferStrategy(3);
            return;
        }
        
        grafico = buferobjetos.getDrawGraphics();
        
        //-----------------
        
        grafico.fillRect(0, 0, ancho, alto);
        estadojuego.dibujar(grafico);
        grafico.drawString(("FPS: "+promedioFPS),1125,350);
        
        //------------------
        
        grafico.dispose();
        buferobjetos.show();
    }
    
    @Override
    public void run(){
        long tantes = System.nanoTime();
        long tahora = 0;
        int fotogramas = 0;
        int tiempo = 0;
        inicializar();
        while(runninggame){
            tahora = System.nanoTime();
            variaciontiempo += (tahora-tantes)/tiempofotograma;
            tiempo += (tahora-tantes);
            tantes = tahora;
            
            if(variaciontiempo >= 1){
                actualizar();
                dibujar();
                variaciontiempo--;
                fotogramas++;
            }
            
            if(tiempo >= 1000000000){
                promedioFPS = fotogramas;
                fotogramas = 0;
                tiempo = 0;
            }
        }
        System.out.println("Se paro");
        stop();
    }
    
    public void start(){
        hilojuego = new Thread(this);
        hilojuego.start();
        runninggame=true;
    }
    
    public void stop(){
        try{
            System.out.println("paso por aquí");
            hilojuego.join();
            System.exit(0);
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null,"Se produjo el error: "+e.getMessage());
        }
    }
    
}
