/*
    Crea todas la propiedades y acciones del corredor
*/
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

public class Corredor extends ObjetoJuego{
    private double x_aux, y_aux;
    private boolean sube, baja, saltando;
    private Area cabeza, piernaatras, piernaadelante;
    private static Area cuerpo;
    
    public Corredor(Vector2D posicion, BufferedImage textura) {
        super(posicion, textura);
        x_aux=0;
        y_aux=0;
        sube=false;
        baja=false;
        saltando=false;
        getBounds();
    }
    
  
    public Corredor(Vector2D posicion){
        super(posicion);
    }

    public static Area getCuerpo() {
        return cuerpo;
    }

    
    @Override
    public void actualizar() {
        if(Teclado.Espacio){
            saltando=true;
        }
        saltar();
        getBounds();
        if(Toro.isColision()){
            posicion.setPosicionX(120);
            posicion.setPosicionY(230);
            saltando=false;
        }
    }

    @Override
    public void dibujar(Graphics grafico) {
       grafico.drawImage(textura, (int)posicion.getPosicionX(), (int)posicion.getPosicionY(), null);
    }
    
    public void saltar(){
        if((int)posicion.getPosicionX()+x_aux>0 && (int)posicion.getPosicionX()+x_aux<Ventana.ancho-ArchivoActivo.corredor.getWidth()){
            posicion.setPosicionX(posicion.getPosicionX()+x_aux);
        }
        if(saltando){
            if(posicion.getPosicionY()==230){
                sube=true;
                y_aux=-2.1;
                baja=false;
            }
            if(posicion.getPosicionY()<=75){
                baja=true;
                y_aux=2.1;
                sube=false;
            }
            
            if(sube){
                posicion.setPosicionY(posicion.getPosicionY()+y_aux);
            }
            if(baja){
                posicion.setPosicionY(posicion.getPosicionY()+y_aux);
                if(posicion.getPosicionY()==230){
                    saltando=false;
                }
            }
        }
    }
    
    public void getBounds(){
        Ellipse2D forma = new Ellipse2D.Double(posicion.getPosicionX(),posicion.getPosicionY(), 20, 20);
        cabeza = new Area(forma);
        Rectangle forma1 = new Rectangle((int)posicion.getPosicionX(),(int)(posicion.getPosicionY()+20),30,25);
        piernaatras=new Area(forma1);
        Rectangle forma2 = new Rectangle((int)(posicion.getPosicionX()+20),(int)(posicion.getPosicionY()+20), 30,25);
        piernaadelante= new Area(forma2);
        
        //System.out.println("ancho corredor "+ArchivoActivo.corredor.getWidth()+"alto corredor "+ArchivoActivo.corredor.getHeight());
        
        cuerpo=cabeza;
        cuerpo.add(cabeza);
        cuerpo.add(piernaatras);
        cuerpo.add(piernaadelante);
        
    }
}
