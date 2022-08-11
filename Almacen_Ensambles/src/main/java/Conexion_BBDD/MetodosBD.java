package Conexion_BBDD;

import Business.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class MetodosBD {
    Conexion miConexion;
    private PreparedStatement miStatement;
    private Statement miStatementConstante;
    private int filasAfectadas = 0;
    private Empleado empleado;
    
    public MetodosBD(){
        miConexion= new Conexion();
        miStatement= null;
        empleado = new Empleado();
    } 
    
    public void ejecutarSQL(String sql){
        miConexion.setConexion();
        try{
            miStatement = miConexion.getMiConexion().prepareStatement(sql);
            miStatement.executeUpdate();
            filasAfectadas = miStatement.executeUpdate(sql);
            miStatement.close();
            miConexion.desconectarBD();
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
    public int InsertarRegistro(String nomTabla, Object[] datos){
        filasAfectadas = 0;
        try{
            String cadenaInsercion = ("INSERT INTO "+nomTabla + " VALUES ("+"'"+datos[0]+"'");
            
            for (int i = 1; i <= datos.length; i++) {
                
                if(i < datos.length){
                    cadenaInsercion += (",'"+datos[i]+"'");
                }else
                    cadenaInsercion += ")"; 
            }
            
            JOptionPane.showMessageDialog(null, cadenaInsercion);
            
            ejecutarSQL(cadenaInsercion);
            System.out.println("Registro Almacenado Correctamente en la tabla "+nomTabla+"!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return filasAfectadas;
    }
    
    public void actualizarRegistro(String nomTabla, String columna 
                                        ,String nuevoValor, String nomId, String valorId){
        try{
            String cadena = ("UPDATE "+nomTabla + " SET "
                                        +columna+"='"+nuevoValor+"' WHERE "
                                        +nomId+"='"+valorId+"'; ");
            
            
            
            JOptionPane.showMessageDialog(null, cadena);
            
            ejecutarSQL(cadena);
            System.out.println("Registro Actualizado Correctamente en la tabla "+nomTabla+"!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public Empleado getRegistroEmpleado(String valorId){
        miConexion.setConexion();
        try{
            String cadena=("SELECT * FROM Empleado WHERE idEmpleado='"+valorId+"';");

            miStatementConstante=miConexion.getMiConexion().createStatement();

            ResultSet miResultset=miStatementConstante.executeQuery(cadena);

            if (miResultset.next()) {
                empleado.setIdEmpleado(miResultset.getString("idEmpleado"));
                empleado.setIdAlmacen(miResultset.getString("idAlmacen"));
                empleado.setIdCargoEmpleado(miResultset.getString("idCargoEmpleado"));
                empleado.setDocumento(miResultset.getString("documento"));
                empleado.setDireccion(miResultset.getString("direccion"));
                empleado.setTelefono(miResultset.getString("telefono"));
                empleado.setCorreo(miResultset.getString("correo"));
                empleado.setNombreCompleto(miResultset.getString("nombreCompleto"));
            }else{
                empleado.setIdEmpleado("");
                empleado.setIdAlmacen("");
                empleado.setIdCargoEmpleado("");
                empleado.setDocumento("");
                empleado.setDireccion("");
                empleado.setTelefono("");
                empleado.setCorreo("");
                empleado.setNombreCompleto("");
                
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
            }
            
            miStatementConstante.close();
            miConexion.desconectarBD();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
       return empleado;
    }
    
    public String getcodCliente(String cedula){
        miConexion.setConexion();
        String codCliente = "0"; 
        try{
            String cadena=("SELECT * FROM Persona WHERE idenperson='"+cedula+"';");

            miStatementConstante=miConexion.getMiConexion().createStatement();

            ResultSet miResultset=miStatementConstante.executeQuery(cadena);
            codCliente = miResultset.getString("idpersona");
            if (codCliente.equals("") || codCliente.equals(null)) {
                codCliente = "vacio";
            }
            System.out.println(codCliente);
            miStatementConstante.close();
            miConexion.desconectarBD();
        }catch(Exception e){
            codCliente = "vacio";
            
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
       return codCliente;
    }
    
    public String[] getDatosColumna(String nomTabla, String nomColumna){
        miConexion.setConexion();
        String[] datos = new String[200]; 
        int contador = 0;
        try{
            String cadena=("SELECT * FROM "+nomTabla);

            miStatementConstante=miConexion.getMiConexion().createStatement();

            ResultSet miResultset=miStatementConstante.executeQuery(cadena);
            
            while (miResultset.next()) {
                datos[contador] = miResultset.getString(nomColumna.trim());
                System.out.println(datos[contador]);
                contador++;
            }
            
            miStatementConstante.close();
            miConexion.desconectarBD();
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
       return datos;
    }
    
    public String[] getDatosRegistroDetalleFactura(String id, String valorId){
        miConexion.setConexion();
        String[] datos = new String[200]; 
        try{
            String cadena=("SELECT * FROM detallefactura WHERE "+id+"='"+valorId+"';");

            miStatementConstante=miConexion.getMiConexion().createStatement();

            ResultSet miResultset=miStatementConstante.executeQuery(cadena);
           
            
            while (miResultset.next()) {
                datos[0] = miResultset.getString("item");
                datos[1] = miResultset.getString("idtipodetallefk");
                datos[2] = miResultset.getString("idRef");
                datos[3] = miResultset.getString("cantidad");
                datos[4] = miResultset.getString("precio");
            }
            
            
            miStatementConstante.close();
            miConexion.desconectarBD();
        }catch(Exception e){
    
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
       return datos;
    }
    
    public void eliminarRegistro(String nomTabla, String nomId, String valorId){
        miConexion.setConexion();
        try{
            String cadena=("DELETE FROM "+nomTabla+" WHERE "+nomId+"='"+valorId+"';");
            
            miStatementConstante = miConexion.getMiConexion().createStatement();
            
            miStatementConstante.executeUpdate(cadena);
            miStatementConstante.close();
            miConexion.desconectarBD();
            System.out.println("Se elimino el registro correctamente.");
            JOptionPane.showMessageDialog(null, "Se elimino el registro correctamente.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
        }
    }
}
