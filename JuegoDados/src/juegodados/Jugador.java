package juegodados;

public class Jugador {
    private static int id; 
    private String nombre;
    private String contrasena;
    private int credito;
    private int apuesta;

    public Jugador(int id, String nombre, String contrasena, int credito) {
        Jugador.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.credito = credito;
    }

    public static int getId() {
        return id;
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
    
    public void setId(int id){
        Jugador.id = id;
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

