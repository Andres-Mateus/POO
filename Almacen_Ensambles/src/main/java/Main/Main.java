/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Business.Empleado;
import Business.TablaBD;
import Conexion_BBDD.MetodosBD;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andresfelipe
 */
public class Main {
    
    static int buscarTabla(String nombre, ArrayList<TablaBD> tablasAEnsamble){
        
        TablaBD tablaABuscar = tablasAEnsamble.stream()
                    .filter(tabla -> tabla.getNomTabla().equals(nombre))
                    .findAny()
                    .orElse(null);
        return tablasAEnsamble.indexOf(tablaABuscar);
    }
    
    
    public static void main(String[] args){
        MetodosBD registro = new MetodosBD();
        ArrayList<TablaBD> tablasAEnsamble = new ArrayList<>(); 
        Scanner sc = new Scanner(System.in);
        
        tablasAEnsamble = cargarTablas(tablasAEnsamble);
        String opcion = "0";
        /*
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[0] = 2;
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[1] = 1;
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[2] = 1;
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[3] = 46763712;
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[4] = "Calle_53_Norte";
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[5] = 3688045;
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[6] = "Andres@outlook.com";
        tablasAEnsamble.get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont()[7] = "Andres_Ramírez";
        registro.InsertarRegistro("Empleado", tablasAEnsamble
                .get(buscarTabla("Empleado", tablasAEnsamble))
                .getTablaCont());
        
        registro.eliminarRegistro("Empleado", "idEmpleado", "2");
        */
        do{ 
            System.out.println("Elija una opción para manejar el CRUD: "
                    + "\n C = Crear Registro"
                    + "\n R = Mostrar Registro"
                    + "\n U = Actualizar Registro"
                    + "\n D = Eliminar Registro"
                    + "\n S = Salir"
            );
            opcion = sc.nextLine();
            String tabla = "";
            String columna = "";
            String nuevoValor = "";
            String nomId = "";
            String valorId = "";
            Empleado empleado1 = new Empleado();        
            switch(opcion){
                case "C" -> {
                    System.out.println("Funciona");
                    
                    System.out.println("Escriba el nombre de la tabla.");
                    tabla = sc.nextLine();
                    int limite = tablasAEnsamble.get(buscarTabla(tabla,tablasAEnsamble))
                    .getTablaCont().length;
                    System.out.println("Limite:" +limite);
                    int contador = 0;
                    while(contador < limite){
                    tablasAEnsamble.get(buscarTabla(tabla,tablasAEnsamble))
                    .getTablaCont()[contador] = sc.nextLine();
                    System.out.println("Contador: "+contador);
                    contador++;
                    }
                    registro.InsertarRegistro(tabla,tablasAEnsamble
                    .get(buscarTabla(tabla,tablasAEnsamble))
                    .getTablaCont());
                     
                }
                case "R" -> {
                    System.out.println("Escriba el id del registro en la tabla Empleados.");
                    valorId = sc.nextLine();
                    empleado1 = registro.getRegistroEmpleado(valorId);
                    System.out.println(empleado1.toString());
                }
                case "U" -> {
                    System.out.println("Escriba el nombre de la tabla.");
                    tabla = sc.nextLine();
                    
                    System.out.println("Escriba el nombre de la columna.");
                    columna = sc.nextLine();
                    
                    System.out.println("Escriba el valor nuevo a insertar en el registro.");
                    nuevoValor = sc.nextLine();
                    
                    System.out.println("Escriba el nombre del Id de la tabla.");
                    nomId = sc.nextLine();
                    
                    System.out.println("Escriba el valor del Id de la tabla.");
                    valorId = sc.nextLine();
                    
                    registro.actualizarRegistro(tabla, columna, nuevoValor, nomId, valorId);
                }
                case "D" -> {
                    System.out.println("Escriba el nombre de la tabla.");
                    tabla = sc.nextLine();
                    
                    System.out.println("Escriba el nombre del Id de la tabla.");
                    nomId = sc.nextLine();
                    
                    System.out.println("Escriba el valor del Id de la tabla.");
                    valorId = sc.nextLine();
                    
                    registro.eliminarRegistro(tabla, nomId, valorId);
                }
                default -> System.out.println("Escoja una de las opciones indicadas.");
            }
        }while(!"S".equals(opcion));
        
        
        //ingresarDatos(tablasAEnsamble, registro);
       
        
        
        //Añadir datos Empleado
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[1] = 1;
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[2] = 2;
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[3] = 24563712;
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[4] = "Calle_53_Norte";
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[5] = 3689045;
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[6] = "lorena@gmail.com";
        tablasAEnsamble.get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont()[7] = "Andre_Lorena_Vargas_Pizarro";

        registro.InsertarRegistro("Empleado",tablasAEnsamble
                            .get(buscarTabla("Empleado",tablasAEnsamble))
                            .getTablaCont());
        registro.actualizarRegistro("Empleado", "nombrecompleto"
                                    , "Laura_Andrea_Vargas_Pizarro", "idEmpleado", "1");
            
            
       
       
    }
    
    static ArrayList<TablaBD> cargarTablas(ArrayList<TablaBD> tablasAEnsamble){
        //objetos por tabla
        tablasAEnsamble.add(new TablaBD("Empleado", new Object[8]));
        
        tablasAEnsamble.add(new TablaBD("CargoEmpleado", new Object[3]));
        tablasAEnsamble.add(new TablaBD("HistorialCargo", new Object[3]));
        
        tablasAEnsamble.add(new TablaBD("Almacen", new Object[6])); 
        tablasAEnsamble.add(new TablaBD("DetalleComp", new Object[4])); 
        tablasAEnsamble.add(new TablaBD("Componente", new Object[5])); 
        tablasAEnsamble.add(new TablaBD("Marca", new Object[3])); 
        
        tablasAEnsamble.add(new TablaBD("Inventario", new Object[3]));
        
        tablasAEnsamble.add(new TablaBD("Existencia", new Object[2])); 
        tablasAEnsamble.add(new TablaBD("EstadoComp", new Object[2]));
        
        tablasAEnsamble.add(new TablaBD("HistorialCompraComputador", new Object[2]));
        tablasAEnsamble.add(new TablaBD("ComputadorArmado", new Object[7]));
        tablasAEnsamble.add(new TablaBD("TarjetaVideo", new Object[6]));
        tablasAEnsamble.add(new TablaBD("Ram", new Object[6]));
        tablasAEnsamble.add(new TablaBD("TarjetaVideo", new Object[6]));
        tablasAEnsamble.add(new TablaBD("Procesador", new Object[4]));
        tablasAEnsamble.add(new TablaBD("FuentePoder", new Object[7]));
        tablasAEnsamble.add(new TablaBD("Chasis", new Object[4]));
        tablasAEnsamble.add(new TablaBD("TarjetaMadre", new Object[8]));
        
        
        return tablasAEnsamble;
    }
    
    static void ingresarDatos(ArrayList<TablaBD> tablasAEnsamble, MetodosBD registro){
        try{
            /*
            //Datos TarjetaMadre
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[1] = "Socket_AM4";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[2] = "B450M";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[3] = "Gigabyte";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[4] = "DS3H";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[5] = "Windows_7,10";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[6] = "DDR4";
            tablasAEnsamble.get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont()[7] = "1000_TB";
            
            registro.InsertarRegistro("TarjetaMadre",tablasAEnsamble
                                .get(buscarTabla("TarjetaMadre",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Chasis
            tablasAEnsamble.get(buscarTabla("Chasis",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Chasis",tablasAEnsamble))
                                .getTablaCont()[1] = "ATX";
            tablasAEnsamble.get(buscarTabla("Chasis",tablasAEnsamble))
                                .getTablaCont()[2] = "Gear";
            tablasAEnsamble.get(buscarTabla("Chasis",tablasAEnsamble))
                                .getTablaCont()[3] = "V6";
            
            registro.InsertarRegistro("Chasis",tablasAEnsamble
                                .get(buscarTabla("Chasis",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos FuentePoder
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[1] = "Evga";
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[2] = "100-W1-0500-KR";
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[3] = "500_W";
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[4] = "110-250_VCA";
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[5] = "Negro";
            tablasAEnsamble.get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont()[6] = "50-60_Hz";
            
            registro.InsertarRegistro("FuentePoder",tablasAEnsamble
                                .get(buscarTabla("FuentePoder",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Procesador
            tablasAEnsamble.get(buscarTabla("Procesador",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Procesador",tablasAEnsamble))
                                .getTablaCont()[1] = "5";
            tablasAEnsamble.get(buscarTabla("Procesador",tablasAEnsamble))
                                .getTablaCont()[2] = "3.6_GHz";
            tablasAEnsamble.get(buscarTabla("Procesador",tablasAEnsamble))
                                .getTablaCont()[3] = "6";
            
            registro.InsertarRegistro("Procesador",tablasAEnsamble
                                .get(buscarTabla("Procesador",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos TarjetaVideo
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[1] = "NVIDIA";
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[2] = "GeForce_GTX";
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[3] = "129x111_mm";
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[4] = "GDDR5-8Gz";
            tablasAEnsamble.get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont()[5] = "NVIDIA";
            
            registro.InsertarRegistro("TarjetaVideo",tablasAEnsamble
                                .get(buscarTabla("TarjetaVideo",tablasAEnsamble))
                                .getTablaCont());
            
            
            //Datos Ram
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[1] = "8_Gb";
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[2] = "DDR4_1.2v";
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[3] = "Kingston";
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[4] = "2400_MHz";
            tablasAEnsamble.get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont()[5] = "Integrado";
            
            registro.InsertarRegistro("Ram",tablasAEnsamble
                                .get(buscarTabla("Ram",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos ComputadorArmado
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[2] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[3] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[4] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[5] = 1;
            tablasAEnsamble.get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont()[6] = 1;
            
            registro.InsertarRegistro("ComputadorArmado",tablasAEnsamble
                                .get(buscarTabla("ComputadorArmado",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos HistorialCompraComputador
            tablasAEnsamble.get(buscarTabla("HistorialCompraComputador",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("HistorialCompraComputador",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
            
            registro.InsertarRegistro("HistorialCompraComputador",tablasAEnsamble
                                .get(buscarTabla("HistorialCompraComputador",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos EstadoComp
            tablasAEnsamble.get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont()[1] = "Disponible";
            
            registro.InsertarRegistro("EstadoComp",tablasAEnsamble
                                .get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont());
            
            tablasAEnsamble.get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont()[0] = 2;
            tablasAEnsamble.get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont()[1] = "No Disponible";
            
            registro.InsertarRegistro("EstadoComp",tablasAEnsamble
                                .get(buscarTabla("EstadoComp",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Existencia
            tablasAEnsamble.get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
            
             registro.InsertarRegistro("Existencia",tablasAEnsamble
                                .get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont());
             
            tablasAEnsamble.get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont()[1] = 2;
            
            registro.InsertarRegistro("Existencia",tablasAEnsamble
                                .get(buscarTabla("Existencia",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Inventario
            tablasAEnsamble.get(buscarTabla("Inventario",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Inventario",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
            tablasAEnsamble.get(buscarTabla("Inventario",tablasAEnsamble))
                                .getTablaCont()[2] = 1;
            
            registro.InsertarRegistro("Inventario",tablasAEnsamble
                                .get(buscarTabla("Inventario",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Marca
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[1] = "NVIDIA";
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[2] = "tarjetas_de_video.";
            
            registro.InsertarRegistro("Marca",tablasAEnsamble
                                .get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont());
            
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[0] = 2;
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[1] = "Intel";
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[2] = "procesadores.";
            
            registro.InsertarRegistro("Marca",tablasAEnsamble
                                .get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont());
            
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[0] = 3;
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[1] = "Evga";
            tablasAEnsamble.get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont()[2] = "chasis.";
            
            registro.InsertarRegistro("Marca",tablasAEnsamble
                                .get(buscarTabla("Marca",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Componente
            tablasAEnsamble.get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont()[1] = 2;
            tablasAEnsamble.get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont()[2] = "Procesador_64bit.";
            tablasAEnsamble.get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont()[3] = 34;
            tablasAEnsamble.get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont()[4] = 12500.50;
            
            registro.InsertarRegistro("Componente",tablasAEnsamble
                                .get(buscarTabla("Componente",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos DetalleComp
            tablasAEnsamble.get(buscarTabla("DetalleComp",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("DetalleComp",tablasAEnsamble))
                                .getTablaCont()[1] = 2;
            tablasAEnsamble.get(buscarTabla("DetalleComp",tablasAEnsamble))
                                .getTablaCont()[2] = 1;
            tablasAEnsamble.get(buscarTabla("DetalleComp",tablasAEnsamble))
                                .getTablaCont()[3] = 3450;
            
            registro.InsertarRegistro("DetalleComp",tablasAEnsamble
                                .get(buscarTabla("DetalleComp",tablasAEnsamble))
                                .getTablaCont());
            
            //Datos Almacen
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[2] = 1;
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[3] = "Calle_16_Norte";
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[4] = 4659838;
            tablasAEnsamble.get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont()[5] = "GEA@gmail.com";
            
            registro.InsertarRegistro("Almacen",tablasAEnsamble
                                .get(buscarTabla("Almacen",tablasAEnsamble))
                                .getTablaCont());
            
            //Añadir datos HistorialCargo
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[1] = "2018-06-18";
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[2] = "2021-08-20";
        
        registro.InsertarRegistro("HistorialCargo",tablasAEnsamble
                                .get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont());
        
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[0] = 2;
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[1] = "2020-04-10";
        tablasAEnsamble.get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont()[2] = "2022-01-29";
        
        registro.InsertarRegistro("HistorialCargo",tablasAEnsamble
                                .get(buscarTabla("HistorialCargo",tablasAEnsamble))
                                .getTablaCont());
        
        //Añadir datos CargoEmpleado
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[0] = 1;
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[1] = 1;
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[2] = "10,000,000_COP";
        
        registro.InsertarRegistro("CargoEmpleado",tablasAEnsamble
                                .get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont());
        
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[0] = 2;
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[1] = 2;
        tablasAEnsamble.get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont()[2] = "5,000,000_COP";
        
        registro.InsertarRegistro("CargoEmpleado",tablasAEnsamble
                                .get(buscarTabla("CargoEmpleado",tablasAEnsamble))
                                .getTablaCont());
            
        */
                                
        }catch(IndexOutOfBoundsException e){
            System.out.println("No se encontro el elemento.");
        }
    }
}
