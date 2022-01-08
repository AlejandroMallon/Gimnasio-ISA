package gimnasio.app;

public class Director extends Empleado {

    public Director (){

    }
    
    public Director (String dni){
        super(dni);
    }

    public Director (String nombre, String correo, String passw){
        super(nombre, correo, passw);
    }

    
}
