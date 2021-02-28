package ObjetosJuego;

import Calculos.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class ObjetoJuego {
    protected BufferedImage textura;
    protected Vector2D posicion;
    
    public ObjetoJuego(Vector2D posicion, BufferedImage textura){
        this.posicion=posicion;
        this.textura=textura;
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
