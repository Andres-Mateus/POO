package juegodados;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        GUI_Juego ventana1 = new GUI_Juego();
        ventana1.setVisible(true);
        
        Jugador jugador1 = new Jugador(1, "Jhon", "1234sd", 0);
        Juego dado1 = new Dado(false, jugador1, 0);
        Scanner entrada = new Scanner(System.in);
        int opcion=0;
        
        System.out.println("¡BIENVENIDO al juego de los dados");
        dado1.leer();
        do{
            System.out.println("¿Que desea realizar?");
            System.out.println("1.Tirar los dados\n2.Reescribir los datos\n3.Mostrar creditos\n4.Salir");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    dado1.leerapuesta();
                    dado1.jugar();
                    Dado.setTirada(0);
                break;
                case 2:
                    dado1.leer();
                break;
                case 3:
                    System.out.println("La cantidad de dinero que tiene es:"+jugador1.getCredito());
                break;
                case 4:
                    
                break;
            }
        }while(opcion!=4);
    }
    
}
