package ObjetosJuego;

import Calculos.Vector2D;
import Entrada.Teclado;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Corredor extends ObjetoJuego{

    public Corredor(Vector2D posicion, BufferedImage textura) {
        super(posicion, textura);
    }

    @Override
    public void actualizar() {
        if(Teclado.Espacio){
            posicion.setPosicionY(posicion.getPosicionY()-5);
        }
    }

    @Override
    public void dibujar(Graphics grafico) {
       grafico.drawImage(textura, (int)posicion.getPosicionX(), (int)posicion.getPosicionY(), null);
    }
}
