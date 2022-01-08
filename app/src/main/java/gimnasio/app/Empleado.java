package gimnasio.app;

import java.util.Date;
import java.util.UUID;

public class Empleado {

    private String dni;
    private String nombre;
    private Date fecha_nacimiento;
    private double salario;
    private String telefono;
    private String contraseña;
    private UUID id;
    private String tipo_empleado;
    private String correo;

    public Empleado() {

    }

    public Empleado(String dni) {
        this.dni = dni;

    }

    public Empleado (String nombre, String correo, String passw){
        this.nombre=nombre;
        this.contraseña=passw;
        this.correo=correo;
    }
    

    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


   

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    




}
