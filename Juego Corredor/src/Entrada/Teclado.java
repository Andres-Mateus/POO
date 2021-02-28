package Entrada;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Teclado extends KeyAdapter{
    private boolean[] teclas = new boolean[256];
    
    public static boolean Espacio;
    
    public Teclado(){
        Espacio=false;
    }
    
    public void actualizar(){
        Espacio=teclas[KeyEvent.VK_SPACE];
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println("tecla: "+e.getKeyCode());
        teclas[e.getKeyCode()]=true;
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        teclas[e.getKeyCode()]=false;
    }
}
