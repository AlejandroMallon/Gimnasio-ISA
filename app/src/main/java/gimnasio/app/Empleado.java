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

    public Empleado() {

    }

    public Empleado(String dni) {
        this.dni = dni;

    }
    

}
