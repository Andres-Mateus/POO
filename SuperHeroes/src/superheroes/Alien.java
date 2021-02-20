package superheroes;

public class Alien extends SuperHeroe implements Telequinetico, Volador, Combativo{

  public String lanzarObjetos(){
    return "Usando su mente, el alien señala con sus pequeñas manos la direccion a la cual el objeto sale volando";
  }

  public String elevarObjetos(){
    return "El alien concentra la fuerza de su mente para levantar el objeto a la distancia";
  }

  public String aplastarObjetos(){
    return "El alien cierra sus puños con la mirada fija en el objeto seleccionado haciendo que este se compacte";
  }
  public String levitarObjetos() {
        return "El alien cierra sus ojos, se enfoca en un objeto y con el poder de su mente lo eleva";
  }
  
  public String levitar(){
    return "El alien extiende sus brazos con las palmas de sus manos en direccion al suelo, concentrando"+"\n"+"su fuerza en las mismas y elevandose";
  }

  public String impulsar(){
    return "El alien abre y cierra sus manos afectando el campo gravitatorio a su alrededor y de esta manera"+"\n"+"aumentando su velocidad";
  }

  public String volar(){
    return "El alien transforma sus brazos para que se tornen de una forma alada, la cual  le da total control de"+"\n"+"movimiento en el aire";
  }

  public String aterrizar(){
    return "El alien convierte sus piernas en tentaculos para agarrarse de las superficies con sus ventosas y"+"\n"+"mantenerse firme despues de finalizar su vuelo";
  }
  
  public String posicionAtaque(){
    return "El alien muestra unos afilados colmillos en señal de advertencia mientras contrae sus piernas"+"\n"+"preparandose para embestir al enemigo";
  }

  public String concentracion(){
    return "El alien cierra sus ojos mientras escucha donde se encuentra el enemigo";
  }

  public String golpear(){
    return "El alien da un gran grito mientras embiste contra el enemigo con la fuerza de todo su cuerpo";
  }

  public String esquivar(){
    return "El alien por medio de su sentido del oido predice el proximo ataque del enemigo y repentinamente esquiva"+"\n"+"antes de ser impactado";
  }

 
  
}