
package puntos.y.lineas;
import java.util.Scanner;
class Main {
  
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Punto3d a=new Punto3d();
    Punto3d b=new Punto3d();
    int director;
    int opcion;
    Linea linea = new Linea();
    System.out.println("Bienvenido al programa de puntos y lineas");
    do{
      System.out.println("¿Con qué desea trabajar?\n1.Puntos\n2.Lineas\n3.salir"); 
      director=entrada.nextInt();
switch(director){
      case 1:
    do{  
    System.out.println("\nEligio Puntos");
    System.out.println("¿Que desea hallar?\n1.La distancia entre 2 puntos \n2.La distancia al origen de un punto\n3.Mover un punto\n4.Mover en diagonal un punto\n5.Terminar programa puntos");
    opcion=entrada.nextInt();
    if(opcion==1){
      a.leer(1);
      b.leer(2);
    }else if(opcion!=1 && opcion<5){
      a.leer(1);
    }
    switch(opcion){
      case 1:
      System.out.println("Distancia entre el punto 1 y el punto 2 es:"+a.distancia(b));
      System.out.print("1. ");
      a.imprimir();
      System.out.print("2. ");
      b.imprimir();
      break;
      case 2:
      System.out.println("Distancia desde el origen hasta el punto es: "+ a.distancia());
      a.imprimir();
      break;
      case 3:
      System.out.println("Digite el dezplazamiento de la coordenada 1 en X:");
      a.moverX(entrada.nextInt());
      System.out.println("Digite el dezplazamiento de la coordenada 1 en Y:");
      a.moverY(entrada.nextInt());
      System.out.println("Digite el dezplazamiento de la coordenada 1 en Z:");
      a.moverZ(entrada.nextInt());
      a.imprimir();
      break;
      case 4:
      System.out.println("Digite el dezplazamiento diagonal del punto 1");
      a.MoverDiagonal(entrada.nextInt());
      a.imprimir();
      break;
      case 5:
      break;
               }
    }while(opcion!=5 && opcion>0);
break;

case 2:
        System.out.println("\nEligio Lineas");
        linea.leer();
        do{
        System.out.println("\n¿Que desea hacer? \n\n1.La longitud de la linea\n2.Mover la linea\n3.Mover en diagonal la linea\n4.Reescribir los puntos\n5.Terminar programa lineas");
      opcion=entrada.nextInt();
      
      switch(opcion){
      case 1:
      linea.Longitudlinea();
      break;
      case 2:
      linea.MoverLinea();
      break;
      case 3:
      linea.MoverLineaDiag();
      break;
      case 4:
      linea.leer();
      break;
      case 5:
      break;
                        }
    }while(opcion!=5 && opcion>0); 
break;
}
}while(director!=3 && director>0);
  }
}