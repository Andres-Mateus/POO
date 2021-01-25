package juegodados;
import java.util.Scanner;
public class Juego {
    private boolean resultado;
    private Jugador jugador;
    private int apuesta;
    private int credito;

    public Juego(boolean resultado, Jugador jugador, int apuesta) {
        this.resultado = resultado;
        this.jugador = jugador;
        this.apuesta=apuesta;
        this.credito=jugador.getCredito();
    }
    
    public void setResultado(boolean resultado){
        this.resultado = resultado;
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    public void setApuesta(int apuesta){
        this.apuesta = apuesta;
    }
    
    public boolean getResultado(){
        return resultado;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    public int getApuesta(){
        return apuesta;
    }
    
    public void jugar(){  
        if(jugador.getCredito()<=0 || apuesta>jugador.getCredito()){
            System.out.println("No tienes suficiente dinero, no puedes continuar jugando");
            System.exit(0);
        }
        if(resultado==true){
            System.out.println("¡GANASTE!");
            apuesta=apuesta*2;
            credito=+apuesta;
            jugador.setCredito(jugador.getCredito()+apuesta);
            apuesta=0;
        }else if(resultado==false){
            System.out.println("PERDISTE :(");
            credito=jugador.getCredito()-apuesta;
            jugador.setCredito(credito);
        }
    }
    
    public void leer(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dinero que desea tener");
        jugador.setCredito(entrada.nextInt());
    }
    
     public void leerapuesta(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dinero a apostar");
        apuesta=entrada.nextInt();
    }
}
