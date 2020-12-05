
package calculadora.complejos;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Complejo c1=new Complejo();
    Complejo c2=new Complejo();
    int opcion;
    double norma;
    Complejo respuesta=new Complejo();
    System.out.println("Bienvenido al programa de operaciones entre complejos");
    do{
    System.out.println("Eliga la operación que desea hacer entre los complejos");
    System.out.println("1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Hallar el conjugado\n6.Hallar la norma\n7.salir");
    opcion=entrada.nextInt();
    System.out.print("\n");
    if(opcion!=5 && opcion!=6 && opcion<7){
      c1.leer(1);
      c2.leer(2);
    }else if(opcion==5 || opcion==6){
      c1.leer(1);
    }else if(opcion==7){ }
    switch(opcion){
        case 1:
        System.out.println("\nEl resultado de la suma es: ");
        Complejo.suma(c1, c2).imprimir();
        break;
        case 2:
        System.out.println("\nEl resultado de la resta es: ");
        Complejo.resta(c1, c2).imprimir();
        break;
        case 3:
        System.out.println("\nEl resultado de la multiplicacion es: ");
        Complejo.multiplicacion(c1, c2).imprimir();
        break;
        case 4:
        System.out.println("\nEl resultado de la división es: ");
        Complejo.dividir(c1, c2).imprimir();
        break;  
        case 5:
        System.out.println("\nEl resultado del conjugado es: ");
        Complejo.conjugado(c1).imprimir();
        break;   
        case 6:
        System.out.println("\nEl resultado de la norma es: ");
        norma=Complejo.norma(c1);
        System.out.println(norma+"\n");
        break;   
    }
    }while(opcion!=7 && opcion>0);
  }  
}
