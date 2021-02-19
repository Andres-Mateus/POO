package juegodados;

public class Jugador {
    private String nombre;
    private String contrasena;
    private int credito;
    private int apuesta;

    public Jugador(String nombre, String contrasena, int credito) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.credito = credito;
    }
    
    public String getNombre(){
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public int getCredito(){
        return credito;
    }
    

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public void setCredito(int credito){
        this.credito = credito;
    }   
}

