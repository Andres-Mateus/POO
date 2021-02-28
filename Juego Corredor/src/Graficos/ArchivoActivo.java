
package Graficos;

import java.awt.image.BufferedImage;

public class ArchivoActivo {
    
    public static BufferedImage fondo;
    public static BufferedImage corredor;
    public static BufferedImage toro;
        
    public static void inicializar(){
        fondo = Carga.cargarImagen("/Multimedia/FondoPS2.png");
        corredor = Carga.cargarImagen("/Multimedia/Corredor.png");
        toro = Carga.cargarImagen("/Multimedia/torito2.png");
    }
    
}
