package Conexion_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion {
    
    Connection miConexion = null;
    static String bd = "AlmacenEnsambles";
    static String user = "postgres";
    static String password = "12345";
    static String ip = "localhost";
    static String puerto = "5432";
    static String ruta = ("jdbc:postgresql://"+ip+":"+puerto+"/"+bd);
    static String mensaje = "";

    public Connection setConexion(){
        
        try{
            Class.forName("org.postgresql.Driver");
            miConexion = DriverManager.getConnection(ruta, user, password);
            
            if(miConexion != null){
                System.out.println("Se conecto corectamente la Base de Datos: "+bd);
            }
        }catch(Exception e){
                mensaje = e.getMessage();
                System.out.println(getMensaje());
        }  

        return miConexion;
    }
    
    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        Conexion.mensaje = mensaje;
    }

    public Connection getMiConexion() {
        return miConexion;
    }
    
    public void desconectarBD(){
        miConexion=null;
    }
}
