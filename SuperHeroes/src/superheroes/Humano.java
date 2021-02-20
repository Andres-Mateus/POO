package superheroes;

public class Humano extends SuperHeroe implements Combativo, SuperFuerte{

  @Override
  public String posicionAtaque(){
    return "El humano alza los brazos y apareta las piernas en diagonal";
  }

  @Override
  public String concentracion(){
    return "El humano se enfoca en los movimientos que va a realizar y en los movimientos de su oponente";
  }

  @Override
  public String golpear(){
    return "El humano lanza puñetazos y patadas en el cuerpo del oponente";
  }

  @Override
  public String esquivar(){
    return "El humano desplaza todo su cuerpo, evitando los ataques del oponente";
  }

  @Override
  public String romper(){
    return "El humano usa sus puños y piernas para romper objetos";
  }
  @Override
  public String cargar(){
    return "El humano flexiona las piernas y con sus brazos alza los objetos";
  }
  @Override
  public String saltarconimpulso(){
    return "El humano flexiona las piernas, levanta los brazos y se impulsa hacia arriba";
  }
  @Override
  public String resistenciacorporal(){
    return "El humano con sus músculos recibe los impactos, pero aumenta el dolor en su cuerpo";
  }
}