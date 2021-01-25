package juegodados;
import java.util.Random;
import java.util.Scanner;

public class Dado extends Juego{
    private int numero;
    private static int tirada;
    int numero1 = 0;
    
    public Dado(boolean resultado, Jugador jugador, int apuesta){
        super(resultado, jugador, apuesta);
        this.numero=0;
        this.tirada=0;
    }   

    public static int getTirada() {
        return tirada;
    }

    public static void setTirada(int tirada) {
        Dado.tirada = tirada;
    }
    
    
    public void jugar(){
        girar();
        if(tirada==1 && (numero==1 || numero==4 || numero==5 || numero==6 || numero==8 || numero==9 || numero==10)){
            System.out.println("Tienes que tirar nuevamente el dado, si obtines el mismo numero ganas\nPero si obtienes un numero diferente pierdes.");
            System.out.println("El dado se tira automaticamente");
            tirada=0;
            jugar();
        }
        
        if(numero==2 || numero==3 || numero==12){
            super.setResultado(false);
        }else if(numero==7 || numero==11){
            super.setResultado(true);
        }else if(tirada==1 && numero1!=this.numero){
            super.setResultado(false);
        }else if(tirada==1 && numero1==this.numero){
            super.setResultado(true);
        }
        numero1=this.numero;
        
        if(tirada==0){
        tirada++;
        super.jugar();   
        }else{
           jugar(); 
        }
    }
    
    public void girar(){
        Random r = new Random();
        
        this.numero = (int) (r.nextDouble() * 12);
        System.out.println("El numero del dado fue: "+this.numero);
    }
}
