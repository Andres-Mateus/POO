package superheroes;

public class Mago extends SuperHeroe implements Transformante, Elemental, Telequinetico{

  public String copiarobjeto(){
    return "El mago recita un hechizo y apunta con su barita el objeto que va a copiar, multiplicandolo";
  }

  public String modificarmateria(){
    return "El mago junta sus manos, posandolas sobre un objeto y con su maná modifica la estructura"+"\n"+"atómica del objeto";
  }

  public String modificarse(){
    return "El mago dispersa su maná desde el pecho hasta todo su cuerpo, recita un hechizo y se transforma";
  }

  public String restaurarmateria(){
    return "El mago junta sus manos, posandolas sobre un objeto destruido, recita un hechizo de restauración"+"\n"+"y devuelve el objeto a su forma original";
  } 

  public String generarElemento(){
    return "El mago imagina un elelmento en su mente, recita un hechizo y lo crea desde la punta de su barita";
  }

  public String controlarElemento(){
    return "El mago apunta con su barita hacia un un elemento y lo mueve en la dirección de su barita";
  } 

  public String combinarElemento(){
    return "El mago reune dos o más elementos, posa sus manos sobre ellos, los impregna de maná y recita un"+"\n"+"conjuro para combinarlos";
  }

  public String desaparecerElemento(){
    return "El mago apunta su barita a un objeto, recita un conjuro y lo desaparece";   
  }

  public String lanzarObjetos(){
    return "El mago concentra maná en sus manos y las apunta hacia un objeto para lanzarlo";
  }

  public String elevarObjetos(){
    return "El mago concentra maná en sus manos y las apunta hacia un objeto para elevarlo";
  }

  public String aplastarObjetos(){
    return "El mago concentra maná en sus manos, las apunta hacia un objeto y las cierra para aplastar el"+"\n"+"objeto";
  }
  
  public String levitarObjetos(){
    return "El mago impregana de maná un objeto y recita un corto conjuro para hacer que levite";
  }
}