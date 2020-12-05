package cronometropack;

public class Cronometro{
   private Manecilla mover; 
    public Cronometro() {
       this.mover= new Manecilla(0);
    }
  public void iniciar(){
      mover.MoverManecilla();
  }
  
  public void resetear(){
      mover.setHoras(0);
      mover.setMinutos(0);
      mover.setSegundos(0);
      mover.Reestablecer();
  }
}