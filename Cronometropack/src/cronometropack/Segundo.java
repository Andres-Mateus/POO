
package cronometropack;

public class Segundo extends Manecilla{
  public static int segundo;
 
  public Segundo(int horario, int segundo){
   super(horario);
    Segundo.segundo=segundo;
  }
  public int avanzars(int segundos){
      if(getHorario()==1){
        segundos++;  
        Segundo.segundo=segundos;
      }else{
          return segundo;
      }
      return segundo;
  }
}