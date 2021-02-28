package ObjetosJuego;

import Calculos.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fondo extends ObjetoJuego{

    public Fondo(Vector2D posicion, BufferedImage textura) {
        super(posicion, textura);
    }

    @Override
    public void actualizar() {}

    @Override
    public void dibujar(Graphics grafico) {
       grafico.drawImage(textura, (int)posicion.getPosicionX(), (int)posicion.getPosicionY(), null);
    }
    
}
