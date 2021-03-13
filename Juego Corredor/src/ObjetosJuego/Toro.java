package ObjetosJuego;

import Calculos.Vector2D;
import Entrada.Teclado;
import Graficos.ArchivoActivo;
import LogicaJuego.Juego;
import Principal.Ventana;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;


public class Toro extends ObjetoJuego{
    private Vector2D velocidad;
    private final double escala;
    private int nivel; 
    private Area cabeza, cuerpo, toro;
    private static boolean colision; 
    
    public Toro(Vector2D posicion, BufferedImage textura){
        super(posicion, textura);
        velocidad = new Vector2D(-3,0);
        escala=-2;
        nivel=Juego.getNivel();
        colision=false;
    }

    public static boolean isColision() {
        return colision;
    }
    
    @Override
    public void actualizar(){
        posicion= posicion.suma(velocidad);
        colision=colision();
        if(colision){
            posicion.setPosicionX(1000);
            posicion.setPosicionY(230);
        }
        if((posicion.getPosicionX()+ArchivoActivo.toro.getWidth())<=0){
            posicion.setPosicionX(Ventana.ancho);
            Juego.setPuntos(Juego.getPuntos()+1);
        }
        if(Juego.getNivel()>nivel && velocidad.getPosicionX()<=7){
            velocidad=velocidad.suma(new Vector2D(escala,0));
            nivel=Juego.getNivel();
        }
        Juego.actualizar();
    }
    
    @Override
    public void dibujar(Graphics grafico){
        grafico.drawImage(textura, (int)posicion.getPosicionX(), (int)posicion.getPosicionY(), null);
    }
    
    public Area getBounds(){
        Ellipse2D forma1 = new Ellipse2D.Double(posicion.getPosicionX(),(posicion.getPosicionY()+20), 15, 15);
        Rectangle forma2 = new Rectangle((int)(posicion.getPosicionX()), (int)(posicion.getPosicionY()+35), 40, 35);
        cabeza = new Area(forma1);
        cuerpo = new Area(forma2); 
        
        toro=cabeza;
        toro.add(cabeza);
        toro.add(cuerpo);
        
        return toro;
    }
    
    public boolean colision(){
        Area areaA = new Area(Corredor.getCuerpo());
        areaA.intersect(getBounds());
        return !areaA.isEmpty();
    }
}
