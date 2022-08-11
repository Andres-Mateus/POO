/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author andresfelipe
 */
public class Empleado {
    private String idEmpleado;
    private String idAlmacen;
    private String idCargoEmpleado;
    private String documento;
    private String direccion;
    private String telefono;
    private String correo;
    private String nombreCompleto;

    public Empleado() {
        this.idEmpleado = "";
        this.idAlmacen = "";
        this.idCargoEmpleado = "";
        this.documento = "";
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
        this.nombreCompleto = "";
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getIdCargoEmpleado() {
        return idCargoEmpleado;
    }

    public void setIdCargoEmpleado(String idCargoEmpleado) {
        this.idCargoEmpleado = idCargoEmpleado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    @Override
    public String toString(){
        return ("idEmpleado: "+this.idEmpleado+"\n"+
                "idAlmacen: "+this.idAlmacen+"\n"+
                "idCargoEmpleado: "+this.idCargoEmpleado+"\n"+
                "documento: "+this.documento+"\n"+
                "direccion: "+this.direccion+"\n"+
                "telefono: "+this.telefono+"\n"+
                "correo: "+this.correo+"\n"+
                "nombreCompleto: "+this.nombreCompleto+"\n"
                );
    }
    
    
}
