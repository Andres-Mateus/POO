
package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Carga {
    
    public static BufferedImage cargarImagen(String ruta){
        try{
            return ImageIO.read(Carga.class.getResource(ruta));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se produjo el error: "+e.getMessage());
        }
        return null;
    } 
}
