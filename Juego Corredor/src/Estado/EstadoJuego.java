/*
    Maneja la inicialización, el dibujo y la actualización de cada componente del juego
*/
package Estado;

import Calculos.Vector2D;
import Graficos.ArchivoActivo;
import LogicaJuego.Juego;
import ObjetosJuego.Fondo;
import ObjetosJuego.Corredor;
import ObjetosJuego.PuntajeJuego;
import ObjetosJuego.Toro;
import java.awt.Graphics;

public class EstadoJuego {
    private Fondo fondo;
    private Corredor corredor;
    private Toro toro;
    private PuntajeJuego puntajejuego;
    private Juego juego;
    
    public EstadoJuego(){
        juego = new Juego();
        fondo = new Fondo(new Vector2D(), ArchivoActivo.fondo);
        corredor = new Corredor(new Vector2D(120, 230), ArchivoActivo.corredor);
        toro = new Toro(new Vector2D(1000,230), ArchivoActivo.toro);
        puntajejuego = new PuntajeJuego(new Vector2D(0,30));
    }
    
    public void actualizar(){
        corredor.actualizar();
        toro.actualizar();
        puntajejuego.actualizar();
        fondo.actualizar();
    }
    
    public void dibujar(Graphics grafico){
        fondo.dibujar(grafico);
        corredor.dibujar(grafico);
        toro.dibujar(grafico);
        puntajejuego.dibujar(grafico);
    }
}
