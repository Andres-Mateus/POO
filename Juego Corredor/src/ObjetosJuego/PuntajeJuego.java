package ObjetosJuego;

import Calculos.Vector2D;
import LogicaJuego.Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PuntajeJuego extends ObjetoJuego{
    private int puntos;
    private int nivel;
    private int vidas;
    public PuntajeJuego(Vector2D posicion) {
        super(posicion);
        puntos=0;
        nivel=0;
        vidas=0;
    }

    @Override
    public void actualizar() {
        puntos=Juego.getPuntos();
        nivel=Juego.getNivel();
        vidas=Juego.getVidas();
    }

    @Override
    public void dibujar(Graphics grafico) {
        //Graphics2D grafico1 = (Graphics2D)grafico;
        Font puntaje = new Font("arial", Font.BOLD, 30);
        grafico.setFont(puntaje);
        grafico.setColor(Color.black);
        grafico.drawString("Puntos: "+puntos, 1100, (int)posicion.getPosicionY());
        grafico.drawString("Nivel: "+nivel, 570, (int)posicion.getPosicionY());
        grafico.drawString("Vidas: "+vidas, 20, (int)posicion.getPosicionY());
    }
    
}
