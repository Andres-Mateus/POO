
package puntos.y.lineas;

import java.util.Scanner;
public class Linea{
  Punto3d l1;
  Punto3d l2;

  public Linea(){
    l1=new Punto3d();
    l2=new Punto3d();
  }

  public void leer(){
    System.out.println("Establesca el punto inicial de la linea\n");
    l1.leer(1);
    System.out.println("Establesca el punto final de la linea\n");
    l2.leer(2);
  }

  public void Longitudlinea(){
      double distancia=l1.distancia(l2);
      System.out.println("la longitud de la linea es: "+distancia);
      imprimirlinea();
  }
  public void MoverLinea(){
      Scanner entrada = new Scanner(System.in);
      double desplazamientoX;
      double desplazamientoY;
      double desplazamientoZ;
      System.out.println("Digite el dezplazamiento de la linea en X:"); 
      desplazamientoX=entrada.nextDouble();
      System.out.println("Digite el dezplazamiento de la linea en Y:"); 
      desplazamientoY=entrada.nextDouble();
       System.out.println("Digite el dezplazamiento de la linea en z:"); 
      desplazamientoZ=entrada.nextDouble();

      l1.moverX(desplazamientoX);
      l1.moverY(desplazamientoY);
      l1.moverZ(desplazamientoZ);

      l2.moverX(desplazamientoX);
      l2.moverY(desplazamientoY);
      l2.moverZ(desplazamientoZ);
      imprimirlinea();
  }

  public void MoverLineaDiag(){
    Scanner entrada = new Scanner(System.in);
    int movidiag;
     System.out.println("Digite el dezplazamiento diagonal de la linea");
     movidiag=entrada.nextInt();
     l1.MoverDiagonal(movidiag);
     l2.MoverDiagonal(movidiag);
     imprimirlinea();
  }

  public void imprimirlinea(){
    System.out.print("Coordenada Inicial, ");
    l1.imprimir();
    System.out.print("Coordenada Final, ");
    l2.imprimir();
  }
}
