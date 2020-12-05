
package cronometropack;

public class Minuto extends Manecilla{
  public static int minuto;

  public Minuto(int horario, int minuto){
    super(horario);
    Minuto.minuto=minuto;
  }
 
  public int avanzarm(int minutos){
          minutos++;
          Minuto.minuto=minutos;
          return Minuto.minuto;
  }
}
