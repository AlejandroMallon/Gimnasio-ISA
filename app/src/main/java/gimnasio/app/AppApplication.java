package gimnasio.app;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		Director director = new Director ("11292716J");

        Socio socio1 = new Socio("socio@gimnasio.com");

        director.setId(UUID.randomUUID());
        socio1.setNumero_socio(UUID.randomUUID());
        System.out.println("Id de director: " + director.getId());
        System.out.println("Numero de socio: " + socio1.getNumero_socio());;
	}

}

//* Link tutorial: https://spring.io/guides/gs/serving-web-content/

