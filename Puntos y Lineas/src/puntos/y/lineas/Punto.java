
package puntos.y.lineas;
import java.util.Scanner;
public class Punto{
  private double x;
  private double y;
  
  public Punto(){
    x=0;
    y=0;
  }
  public Punto(double a,double b){
    x=a;
    y=b;
  }
  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }
  public void setX(double x){
    this.x=x;
  }
  public void setY(double y){
    this.y=y;
  }
  public void leer(int punto){
    Scanner entrada=new Scanner(System.in);
    System.out.println("Digite la coordenada x del punto: "+punto);
    x=entrada.nextFloat();
    System.out.println("Digite la coordenada y del punto: "+punto);
    y=entrada.nextFloat();
  }
  public void imprimir(){
    System.out.println("("+x+" , "+y+")");
  }
  public double distancia(Punto a){
    return Math.pow(Math.pow(x-a.getX(),2)+Math.pow(y-a.getY(),2),0.5);
  }
  public double distancia(){
    return Math.pow(Math.pow(x,2)+Math.pow(y,2),0.5);
  }
  public void moverX(double x){
    this.x+=x;
  }
  public void moverY(double y){
    this.y+=y;
  }
  public void  MoverDiagonal(double i){
    this.moverX(i);
    this.moverY(i);
  }
  public void MoverDiagonal(double i,double j){
    this.moverX(i);
    this.moverY(j);
  }
}
