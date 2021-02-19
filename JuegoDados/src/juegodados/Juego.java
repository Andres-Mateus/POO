package juegodados;
import java.util.Scanner;
public class Juego {
    private int resultado;
    private Jugador jugador;
    private int apuesta;
    private int credito;
    protected int numdado;
    private int recompensa;
    private String txt_aviso;
    private String txt_resultado;
    
    public Juego(int resultado, Jugador jugador, int apuesta) {
        this.resultado = resultado;
        this.jugador = jugador;
        this.apuesta=apuesta;
        this.credito=jugador.getCredito();
        this.numdado=0;
        this.recompensa=0;
        this.txt_aviso="";
        this.txt_resultado="";
    }
    
    public void setResultado(int resultado){
        this.resultado = resultado;
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    public void setCredito(int credito){
        this.credito=credito;
    }
    
    public void setApuesta(int apuesta){
        this.apuesta = apuesta;
    }
    
    public void setRecompensa(int recompensa){
        this.recompensa=recompensa;
    }
    
    public void setTxtAviso(String txt_aviso){
        this.txt_aviso=txt_aviso;
    }
    
    public void setTxtResultado(String txt_resultado){
        this.txt_resultado=txt_resultado;
    }
    
    public int getResultado(){
        return resultado;
    }
    
    public int getCredito(){
        return credito;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    public int getApuesta(){
        return apuesta;
    }
    
    public int getNumero(){
       return numdado; 
    }
    
    public int getRecompensa(){
        return recompensa;
    }
    
    public String getTxtAviso(){
        return txt_aviso;
    }
    
    public String getTxtResultado(){
        return txt_resultado;
    }
    
    public void jugar(){ 
        if(resultado==1){
            txt_resultado = "**!GANASTE¡**";
            recompensa=apuesta*2;
            credito=+recompensa;
            jugador.setCredito(jugador.getCredito()+apuesta);
            apuesta=0;
        }else if(resultado==2){
            txt_resultado = "PERDISTE :(";
            recompensa=apuesta*-1;
            credito=jugador.getCredito()+recompensa;
            jugador.setCredito(credito);
        }
    }
    
     public void leerapuesta(int apuesta){
        this.apuesta=apuesta;
    }
     
    public void avisar(int numaviso){
        if(numaviso==1){
            txt_aviso="No tienes suficiente dinero, no puedes\n"
                    + "continuar jugando. Por favor presione el\n"
                    + "botón terminar";
        }else if(numaviso==2){
            txt_aviso="Su apuesta es mayor a sus créditos\n"
                    + "ingrese una apuesta menor";
        }else if(numaviso==3){
            txt_aviso="Tienes que tirar nuevamente el dado, si obtines el\n"
                    + "mismo numero ganas. Pero si obtienes un numero\n"
                    + "diferente, pierdes. Presione 'Tirar'";
        }
    }
    
    public void girar(){
        
    }
}
