package Main;

/*import Business.Empleado;
import Business.TablaBD;
import Conexion_BBDD.MetodosBD;
import java.util.ArrayList;
import java.util.Scanner;*/

import javax.swing.*;
import Ventanas.VentanaFactura;

public class Main {
    
    public static void main(String[] args){
        /*MetodosBD registro = new MetodosBD();
        ArrayList<TablaBD> tablasAEnsamble = new ArrayList<>(); 
        Scanner sc = new Scanner(System.in);
        
        tablasAEnsamble = cargarTablas(tablasAEnsamble);
        String opcion = "0";*/
        
        VentanaFactura ventanaFactura = new VentanaFactura();
        
        ventanaFactura.setVisible(true);
        
    }
    

}
