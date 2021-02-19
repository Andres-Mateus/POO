
package juegodados;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class GestorFichero {
    
    public GestorFichero(){
    }
    
    public void actualizarFichero(File Fantiguo, String lineavieja, String lineanueva){
        Random numaleatorio = new Random(3816L);
        String rutaFnuevo = Fantiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
        
        File Fnuevo = new File(rutaFnuevo);
        try{
            if(Fantiguo.exists()){
                BufferedReader Fleer = new BufferedReader(new FileReader(Fantiguo));
                String linealeida;
                
                while((linealeida=Fleer.readLine())!=null){
                    if(linealeida.equals(lineavieja)){
                        escribirFichero(Fnuevo,lineanueva);
                        escribirFichero(Fnuevo,"\r\n");
                    }else{
                        escribirFichero(Fnuevo,linealeida);
                        escribirFichero(Fnuevo,"\r\n");
                    }
                }
                
                Fleer.close();
                borrarFichero(Fantiguo);
                Fnuevo.renameTo(Fantiguo);
            }else{
                JOptionPane.showMessageDialog(null,"El Fichero no existe");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
    }
    
    public void borrarFichero(File fichero){
        try{
            if(fichero.exists())
                fichero.delete();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
    }
    
    public void escribirFichero(File fichero, String texto){
        try{
            if(fichero.exists())
               fichero.createNewFile(); 
            
            BufferedWriter Fescribir = new BufferedWriter(new FileWriter(fichero,true));
            Fescribir.write(texto);
            Fescribir.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Se progujo el error: " + e.getMessage());
        }
    }

}
