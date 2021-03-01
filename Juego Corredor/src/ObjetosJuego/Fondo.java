package ObjetosJuego;

import Calculos.Vector2D;
import LogicaJuego.Juego;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fondo extends ObjetoJuego{
    private int x1, x2, y1, y2;
    public Fondo(Vector2D posicion, BufferedImage textura) {
        super(posicion, textura);
        x1=1300;
        y1=0;
    }

    @Override
    public void actualizar() {
        x1-=2;
        posicion.setPosicionX(posicion.getPosicionX()-2);
        if(x1==0 && posicion.getPosicionX()==-1300){
            x1=1300;
            posicion.setPosicionX(0);
        }
    }

    @Override
    public void dibujar(Graphics grafico) {
       grafico.drawImage(textura, (int)posicion.getPosicionX(), (int)posicion.getPosicionY(), null);
       grafico.drawImage(textura, x1,y1,null);
       
    }
    
}
