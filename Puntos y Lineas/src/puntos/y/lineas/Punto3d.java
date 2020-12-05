
package puntos.y.lineas;
import java.util.Scanner;
public class Punto3d extends Punto{
  private double z;
  public Punto3d(){
    super();
    this.z=0;
  }
  public Punto3d(double x,double y, double z){
    super(x,y);
    this.z=z;
  }
  public double getZ(){
    return z;
  }
  public void setZ(double z){
    this.z=z;
  }

  public void moverZ(double z){
    this.z+=z;
  }
  public void MoverDiagonal(double i){
    super.MoverDiagonal(i);
    this.moverZ(i);
  }
  public void MoverDiagonal(double i,double j,double k){
    super.MoverDiagonal(i,j);
    this.moverZ(k);
  }
  public void imprimir(){
    System.out.println("El punto es: ("+this.getX()+" , "+this.getY()+" , "+z+")");
  }
  public void leer(int punto3d){
    Scanner entrada=new Scanner(System.in);
    super.leer(punto3d);
    System.out.println("Digite la coordenada Z del punto: "+punto3d);
    z=entrada.nextFloat();
  }
  public double distancia(Punto3d a){
    return Math.pow(Math.pow(this.getX()-a.getX(),2)+Math.pow(this.getY()-a.getY(),2)+Math.pow(z-a.getZ(),2),0.5);
  }
  public double distancia(){
    return Math.pow(Math.pow(this.getX(),2)+Math.pow(this.getY(),2)+Math.pow(z,2),0.5);
  }
}
