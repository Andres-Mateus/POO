package juegodados;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Registro {
    File ficherousuarios = new File("src/Registro/UsuariosJuegoDados.txt");  
    ArrayList<Jugador> lista = new ArrayList<Jugador>();
    Jugador usuario1 = null;
    public Registro(){
    
    }
    
    public void comprobararchivo(){
        try{
            if(ficherousuarios.exists()){
                
            }else{
                ficherousuarios.createNewFile();
                JOptionPane.showMessageDialog(null,"La base de datos a sido creada");
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"No se ha encontrado la base dde datos.\nSe ha creado una nueva base de datos");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
    }
    
    public void asignardatos(Jugador jugador1){
        try{
            if(ficherousuarios.exists()){
   
            }else{
                ficherousuarios.createNewFile();
                JOptionPane.showMessageDialog(null,"La base de datos a sido creada");
            }
            
            FileWriter Fescribir = new FileWriter("src/Registro/UsuariosJuegoDados.txt", true);
            Fescribir.write(jugador1.getNombre() +" "+jugador1.getContrasena()+" "+ jugador1.getCredito());
            Fescribir.write("\r\n");
            Fescribir.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
    }
    
    public Jugador buscardatos(String usuario, Jugador jugador1){
        try{
            BufferedReader Fleer = new BufferedReader(new FileReader("src/Registro/UsuariosJuegoDados.txt"));
            
            String linealeida="";
            
            while((linealeida = Fleer.readLine())!=null){
                if(linealeida.indexOf(usuario)!=-1){
                    
                    String[] secciones = linealeida.split(" ");
                    
                    jugador1.setNombre(secciones[0]);
                    jugador1.setContrasena(secciones[1]);
                    jugador1.setCredito(Integer.parseInt(secciones[2]));
                }
                    
            }
            Fleer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
        return jugador1;
    }
    
    public boolean comprobarUsuario(String usuario, String contrasena){
       boolean indicador=false;
        try{
            BufferedReader Fleer = new BufferedReader(new FileReader("src/Registro/UsuariosJuegoDados.txt"));
            
            String linealeida="";
            String textocomprobar="";
            if(contrasena==""){
                textocomprobar = (usuario +" ");
            }else{
                textocomprobar = (usuario +" "+contrasena+ " ");
            }
            
            while((linealeida = Fleer.readLine())!=null){
                if(linealeida.indexOf(textocomprobar)!=-1){
                    indicador=true;
                }    
            }
            Fleer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
       return indicador;
    }
    
    public void actualizar_datos(String usuario, Jugador jugadoract){
        GestorFichero gestor = new GestorFichero();       
        try{
            BufferedReader Fleer = new BufferedReader(new FileReader(ficherousuarios));
            String linealeida="";
            
            String datosviejos = null;
            String datosnuevos = null; 
            if(lista.size()==0){
                almacenardatos();
            }
            
            for (Jugador jugador:lista){
                if(jugador.getNombre().equals(usuario)){
                    datosviejos = (jugador.getNombre() +" "+jugador.getContrasena()+ " " + Integer.toString(jugador.getCredito()));
                    jugador.setCredito(jugadoract.getCredito());
                    datosnuevos = (jugador.getNombre() +" "+jugador.getContrasena()+ " " + Integer.toString(jugador.getCredito()));
                }
            }   
            Fleer.close();
            gestor.actualizarFichero(ficherousuarios, datosviejos, datosnuevos);
            actualizar_array();
       }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
       }

    }
    
    public void almacenardatos(){
        try{
            BufferedReader Fleer = new BufferedReader(new FileReader("src/Registro/UsuariosJuegoDados.txt"));
            
            String linealeida= null;
            
            while((linealeida = Fleer.readLine())!=null){
                StringTokenizer mtokens = new StringTokenizer(linealeida," ");
                String nombre = mtokens.nextToken().trim();
                String contrasena = mtokens.nextToken().trim();
                String credito = mtokens.nextToken().trim();
                
                int creditoOperar = Integer.parseInt(credito);
                
                usuario1 = new Jugador(nombre, contrasena, creditoOperar);
                
                lista.add(usuario1);
            }
         Fleer.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }    
    }
    
    public void actualizar_array(){
        lista.clear();
        almacenardatos();
    }
}

