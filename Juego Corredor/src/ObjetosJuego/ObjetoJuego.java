/*
    Clase para crear cualquier objeto del juego, con su posiciones y propiedades
*/
package ObjetosJuego;

import Calculos.Vector2D;
import LogicaJuego.Juego;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class ObjetoJuego {
    protected BufferedImage textura;
    protected Vector2D posicion;
    protected Juego juego;
    
    public ObjetoJuego(Vector2D posicion, BufferedImage textura){
        this.posicion=posicion;
        this.textura=textura;
        this.juego=new Juego();
    } 
    
    public ObjetoJuego(Vector2D posicion){
       this.posicion=posicion; 
    }
    
    public abstract void actualizar();
    
    public abstract void dibujar(Graphics grafico);
    
    public Vector2D getPosicion(){
        return this.posicion;
    }
    
    public void setPosicion(Vector2D posicion){
        this.posicion=posicion;
    }
}
