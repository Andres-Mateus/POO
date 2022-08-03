
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static int algoritmoEuclidesExtendido(int num1, int num2, AtomicInteger x, AtomicInteger y) {

        if (num2 == 0) {
            x.set(0);
            y.set(1);
            return num1;
        }

        AtomicInteger auxX = new AtomicInteger();
        AtomicInteger auxY = new AtomicInteger();

        int MCD = algoritmoEuclidesExtendido(num2, num1 % num2, auxX, auxY);

        x.set(auxY.get() - (num1 / num2) * auxX.get());
        y.set(auxX.get());

        return MCD;
    }
    
    public static int algoritmoEuclides(int num1, int num2){
        
        if(num2 == 0)
            return num1;
        else
            return algoritmoEuclides(num2, num1 % num2);
        
    }
    
    public static int minimoComunMultiplo(int num1, int num2){
        
        int mcm = (num1 / algoritmoEuclides(num1, num2)) * num2;
        
        return mcm;
    }
    
    public static void enunciado(){
        System.out.println("Elija una opción: "
                    + "\n 1 = Hallar Máximo Común Divisor y Combinación Lineal."
                    + "\n 2 = Hallar Minimo Común Múltiplo."
                    + "\n 3 = Hacer función entera piso."
                    + "\n 4 = Hacer función entera techo."
                    + "\n 5 = Hacer truncamiento de x, de n-cifras."
                    + "\n 6 = Hacer redondeo de x a n-cifras decimales."
                    + "\n S = Salir."
            );
    }
    
    public static void main(String[] args) {
        int a = 0, b = 0;
        double numA = 0.0, numB = 0.0;
        String opcion = "0", texto = "";
        Scanner sc = new Scanner(System.in);
        AtomicInteger x = new AtomicInteger(), y = new AtomicInteger();
       
        
        do {
            if(opcion != "")
                enunciado();
            
            opcion = sc.nextLine();            

            switch (opcion.trim()) {
                case "1" -> {
                    System.out.println("Ingresa el primer número.");
                    a = sc.nextInt();
                    System.out.println("Ingresa el segundo número.");
                    b = sc.nextInt();
                    System.out.println("");
                    
                    int MCD = algoritmoEuclidesExtendido(Math.max(a, b), Math.min(a, b), y, x);
                    System.out.println("(" + a + ", " + b + "): " + MCD);
                    System.out.println(MCD + " = " + x.get() + "(" + a + ")" 
                                            + " + " + y.get() + "(" + b + ")"+"\n");

                }
                case "2" -> {
                    System.out.println("Ingresa el primer número.");
                    a = sc.nextInt();
                    System.out.println("Ingresa el segundo número.");
                    b = sc.nextInt();
                    System.out.println("");
                    
                    int mcm = minimoComunMultiplo(Math.max(a, b), Math.min(a, b));
                    
                    System.out.println("[" + a + ", " + b + "]: " + mcm +"\n");
                }
                case "3" -> {
                    System.out.println("Ingresa el número x para redondeo "
                                            + "con función entera piso.");
                    texto = sc.nextLine();
                    numA = Double.parseDouble(texto.trim());
                    System.out.println("");
                    
                    System.out.println("|_|_"+numA+"_|_| = "+Math.floor(numA));
                }
                case "4" -> {
                    System.out.println("Ingresa el número x para redondeo "
                                            + "con función entera techo.");
                    texto = sc.nextLine();
                    numA = Double.parseDouble(texto.trim());
                    System.out.println("");
                    
                    System.out.println("|-|-"+numA+"-|-| = "+Math.ceil(numA));
                }
                case "5" -> {
                    System.out.println("Ingresa el número x para truncarlo");
                    texto = sc.nextLine();
                    numA = Double.parseDouble(texto.trim());
                    System.out.println("Ingresa el número n de las cifras "
                                            + "donde se trunca.");
                    texto = sc.nextLine();
                    numB = Double.parseDouble(texto.trim());
                    System.out.println("");
                    
                    double resultado = Math.floor((Math.pow(10, numB)*numA))/Math.pow(10, numB);
                    
                    System.out.println("|_|_(10^"+numB+" * "+numA+")_|_|/10^"+numB+" = "+resultado + "\n");
                }
                case "6" -> {
                    System.out.println("Ingresa el número x para redondearlo");
                    texto = sc.nextLine();
                    numA = Double.parseDouble(texto.trim());
                    System.out.println("Ingresa el número n de las cifras de redondeo.");
                    texto = sc.nextLine();
                    numB = Double.parseDouble(texto.trim());
                    System.out.println("");
                    
                    double resultado = (Math.floor(Math.pow(10, numB)*numA + 0.5))/Math.pow(10, numB);
                    
                    System.out.println("(|_|_(10^"+numB+" * "+numA+" + 0.5)_|_|)/10^"+numB+ " = "+resultado+ "\n");
                }
                default ->{
                    if(opcion != "0" || opcion != "1" || opcion != "2" 
                           || opcion != "3" || opcion != "4" || opcion != "5" 
                           || opcion != "6" || opcion != "S")
                        System.out.println("Escoja una de las opciones indicadas."+ "\n");
                }
            }
        } while (!"S".equals(opcion));
        
        
    }

    
}
