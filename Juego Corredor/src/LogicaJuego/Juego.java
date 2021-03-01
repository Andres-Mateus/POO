
package LogicaJuego;

import ObjetosJuego.Toro;
import Principal.Ventana;
import javax.swing.JOptionPane;

public class Juego {
    private static int puntos;
    private static int vidas;
    private static int nivel;
    public Juego(){
        puntos=0;
        vidas=3;
        nivel=1;
    }

    public static int getPuntos() {
        return puntos;
    }

    public static int getVidas() {
        return vidas;
    }

    public static int getNivel() {
        return nivel;
    }

    public static void setPuntos(int puntos) {
        Juego.puntos = puntos;
    }
    
    public static void actualizar(){
        
        if(puntos==3 | puntos==6 | puntos==9 | puntos==12 | puntos==16){
           nivel++;
        }
        
        if(nivel>5){
          Ventana.setRunninggame(false);
          JOptionPane.showMessageDialog(null,"¡¡FELICIDADES, GANASTE!!");
        }
        
        if(Toro.isColision()==true && vidas==0){
           Ventana.setRunninggame(false);
           JOptionPane.showMessageDialog(null,"¡¡Lo siento perdiste!!");
        }else if(Toro.isColision()==true && vidas>0){
           JOptionPane.showMessageDialog(null,"¡¡Cuidado, te embistieron!!");
           vidas--;
        }
    }
    
}
