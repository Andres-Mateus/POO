
package cronometropack;

public class Hora extends Manecilla{
  public static int hora; 

  public Hora(int horario, int hora){
        super(horario);
        Hora.hora=hora;
   }
  public int avanzarh(int horas){
      horas++;   
      Hora.hora=horas;
      return Hora.hora;
  }
}
