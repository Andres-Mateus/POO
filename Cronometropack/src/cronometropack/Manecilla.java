package cronometropack;

public class Manecilla{
  private int horario;
  private int segundos;
  private int minutos;
  private int horas;
  private String label;
 
  
 public Manecilla(int horario){
    this.horario=horario; 
    this.segundos=0;
    this.minutos=0;
    this.horas=0;
    this.label="";
  }
 
public int getHorario(){
    return this.horario;
} 

public void setHorario(int horario){
    this.horario=horario;
}

public int getSegundos() {
    return segundos;
}

public void setSegundos(int segundos) {
    this.segundos = segundos;
}

public int getMinutos() {
    return minutos;
}

public void setMinutos(int minutos) {
     this.minutos = minutos;
}

public int getHoras() {
     return horas;
}

public String getLabel() {
    return label;    
}

public void setLabel(String label) {
    this.label = label;
}

public void setHoras(int horas) {
     this.horas = horas;    
}

public void MoverManecilla(){
        Hora hor = new Hora(this.horario, this.horas);
        Minuto min= new Minuto(this.horario, this.minutos);
        Segundo seg= new Segundo(this.horario, this.segundos);
         if(Segundo.segundo<59){
             this.horario=1;
         }else if(Segundo.segundo==59){
             this.horario=2;
             this.minutos = min.avanzarm(this.minutos);    
             this.segundos=-1;
             if(this.segundos==-1){
                 this.horario=1;
             }
         }
         if(Segundo.segundo ==59 && Minuto.minuto==60){
             this.horario=3;
             this.horas= hor.avanzarh(this.horas);
             this.minutos=0;
             Minuto.minuto=0;
             this.segundos=-1;
             if(this.segundos==-1 ){
                 this.horario=1;
             }
         }
         if(Hora.hora==23 && Minuto.minuto==59 && Segundo.segundo==59){
             this.segundos=0;
             this.minutos=0;
             this.horas=0;
         }  
         this.segundos = seg.avanzars(this.segundos);
         ActualizarLabel(Hora.hora, Minuto.minuto,Segundo.segundo);
 }
   
  public void ActualizarLabel(int hora, int minuto, int segundo){
      label = (hora+" : "+minuto+" : "+segundo);
      GUI.setTexto(label);
  }
  public void Reestablecer(){ 
      ActualizarLabel(0,0,0);
  }
}