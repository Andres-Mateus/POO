
package calculadora.complejos;
import java.util.Scanner;

public class Complejo{
  private float real=0;
  private float imaginario=0;
  public Complejo(){
    this.real=0;
    this.imaginario=0;
  }
  public Complejo(float real,float imaginario){
      this.imaginario=imaginario;
      this.real=real;
  }
  public void setReal(float real){
    this.real=real;
  }
  public void setImag(float imaginario){
    this.imaginario=imaginario;
  }
  public float getReal(){
    return this.real;
  }
  public float getImag(){
    return this.imaginario;
  }
  
  public static Complejo suma(Complejo c1,Complejo c2){
    Complejo suma=new Complejo(c1.real+c2.getReal(),c1.imaginario+c2.getImag());
    return suma;
  }
  
  public static Complejo resta(Complejo c1,Complejo c2){
    Complejo resta = suma(c1,new Complejo(-c2.real,-c2.imaginario));
    return resta;
  }

  public static Complejo multiplicacion(Complejo c1,Complejo c2){
    float real=(c1.real*c2.getReal())+(-1*(c1.imaginario*c2.getImag()));
    float imaginario=(c1.real*c2.getImag()) + (c1.imaginario*c2.getReal());
    Complejo multiplicacion=new Complejo(real,imaginario);
    return multiplicacion;
  }

  public static Complejo conjugado(Complejo c1){
    Complejo conjugado=new Complejo(c1.real,-c1.imaginario);
    return conjugado;
  }

  public static Complejo dividir(Complejo c1,Complejo c2){
    Complejo resultado=new Complejo();
    Complejo numer=c1.multiplicacion(c1,c2.conjugado(c2));
    resultado.real=numer.real/c2.multiplicacion(c2,c2.conjugado(c2)).real;
    resultado.imaginario=numer.imaginario/c2.multiplicacion(c2,c2.conjugado(c2)).real;
    return resultado;
  }
  
public static double norma(Complejo c1){
  double norma=Math.sqrt(Math.pow(c1.real,2)+Math.pow(c1.imaginario,2));
  return norma;
}

public void leer(int numero){
  Scanner sc=new Scanner(System.in);
  System.out.println("Digite la parte real del numero complejo: "+numero);
  this.real=sc.nextFloat();
  System.out.println("Digite la parte imaginaria del numero complejo: "+numero);
  this.imaginario=sc.nextFloat();
}

 public void imprimir(){
   if(this.imaginario>=0){
      System.out.println(this.real+"+"+this.imaginario+"i\n");
    }
    else{
      System.out.println(this.real+""+this.imaginario+"i\n");
    }
  }  
} 
