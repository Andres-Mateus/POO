
package Estado;

import Calculos.Vector2D;
import Graficos.ArchivoActivo;
import ObjetosJuego.Fondo;
import ObjetosJuego.Corredor;
import ObjetosJuego.Toro;
import java.awt.Graphics;

public class EstadoJuego {
    private Fondo fondo;
    private Corredor corredor;
    private Toro toro;
    
    public EstadoJuego(){
        fondo = new Fondo(new Vector2D(), ArchivoActivo.fondo);
        corredor = new Corredor(new Vector2D(120, 270), ArchivoActivo.corredor);
        toro = new Toro(new Vector2D(1000,270), ArchivoActivo.toro);
    }
    
    public void actualizar(){
        corredor.actualizar();
    }
    
    public void dibujar(Graphics grafico){
        fondo.dibujar(grafico);
        corredor.dibujar(grafico);
        toro.dibujar(grafico);
    }
}
