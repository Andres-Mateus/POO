package juegodados;
import java.util.Random;
import java.util.Scanner;

public class Dado extends Juego{
    private static int lanzamiento;
    
    int numero1 = 0;
    int proceso = 0;
    
    public Dado(int resultado, Jugador jugador, int apuesta){
        super(resultado, jugador, apuesta);
        this.lanzamiento=0;
        super.setTxtAviso("");
        super.setTxtResultado("");
    }   
      
    public static int getTirada() {
        return lanzamiento;
    }
    
    public static void setTirada(int lanzamiento) {
        Dado.lanzamiento = lanzamiento;
    }
    
    
    public void jugar(){
        if(this.lanzamiento==0){
          numero1=this.numdado;  
        }

        girar(); 
        if(super.getCredito()<=0){
            this.lanzamiento=3;
            super.setResultado(-1);
            super.avisar(1);
        }else if(super.getApuesta()>super.getCredito()){
            this.lanzamiento=4;
            super.setResultado(-1);
            super.avisar(2);
             }
        boolean suerte = (numdado==1 || numdado==4 || numdado==5 || numdado==6 || numdado==8 || numdado==9 || numdado==10);
        
        if(this.lanzamiento==0 && (numdado==1 || numdado==4 || numdado==5 || numdado==6 || numdado==8 || numdado==9 || numdado==10)){
            this.lanzamiento=-2;
            super.avisar(3);
        }
  
        
        if(this.lanzamiento==0 && (numdado==2 || numdado==3 || numdado==12)){
            super.setResultado(2);
        }else if(this.lanzamiento==0 && (numdado==7 || numdado==11)){
            super.setResultado(1);
        }else if(this.lanzamiento==1 && numero1!=this.numdado){
            super.setResultado(2);
        }else if(this.lanzamiento==1 && numero1==this.numdado){
            super.setResultado(1);
        }
        
        if(this.lanzamiento==0){
        this.lanzamiento=1;
        proceso++;    
        super.jugar();   
        }else if(this.lanzamiento==1){
           this.lanzamiento=2;
           proceso++;
           super.jugar(); 
        }
    }
    
    public void girar(){
        Random r = new Random();
        
        this.numdado = (int) (r.nextDouble() * 12);
        if(this.numdado==0){
            this.numdado++;
        }
    }
}
