package gimnasio.app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppApplication {
    public static ArrayList<Director> ldir = new ArrayList<Director>();
    public static List<Socio> lsocios = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

        //TODO Registro socios + Controlador
        //TODO Tabla Menu Director.

        
        


		Director director = new Director ("11292716J");
        Socio socio1 = new Socio("socio@gimnasio.com");
        socio1.setNumero_socio(UUID.randomUUID());
        lsocios.add(socio1);

        director.setId(UUID.randomUUID());
        
        System.out.println("Id de director: " + director.getId());
        System.out.println("Numero de socio: " + socio1.getNumero_socio());;
	}

}

//* Link tutorial: https://spring.io/guides/gs/serving-web-content/

