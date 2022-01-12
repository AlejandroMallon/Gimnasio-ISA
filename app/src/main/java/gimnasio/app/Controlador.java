package gimnasio.app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/menuDirector")
	public String menuDirector(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "menuDirector";
	}

	@GetMapping("/volver")
	public String volver(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "volver";
	}

	@GetMapping("/iniciarSesion")
	public String iniciaSesion(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "iniciarSesion";
	}

	@GetMapping("/registroSocio")
	public String registroSocio(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "registroSocio";
	}

	@GetMapping("/error")
	public String error(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "error";
	}

	@GetMapping("/tablaSocios")
	public String tablaSocios(Model model) {
		List<String> socioNombre = new ArrayList<>();
		List<String> socioEmail = new ArrayList<>();
		for (int i = 0; i < AppApplication.lsocios.size(); i++) {
			socioEmail.add(AppApplication.lsocios.get(i).getEmail());
			socioNombre.add(AppApplication.lsocios.get(i).getNombre());
		}
		model.addAttribute("mensaje", "Hola buenas");
		model.addAttribute("sociosEmail", socioEmail);
		model.addAttribute("sociosNombre", socioNombre);
		model.addAttribute("socios", AppApplication.lsocios);

		return "tablaSocios";
	}

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") UUID idSocio) {
		System.out.println("Eliminando  socio con id: " + idSocio);
		for (int i = 0; i < AppApplication.lsocios.size(); i++) {
			if (AppApplication.lsocios.get(i).getNumero_socio().equals(idSocio)) {
				AppApplication.lsocios.remove(i);
				System.out.println("holaaaa " + idSocio);

			} else {

			}
		}
		return "delete";
	}

	@RequestMapping("validador")
	public ModelAndView getValidaLogin(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelo = new ModelAndView();
		boolean encontrado = false;
		String usuario = req.getParameter("u");
		String password = req.getParameter("p");
		for (int i = 0; i < AppApplication.ldir.size(); i++) {
			if (usuario.equals(AppApplication.ldir.get(i).getNombre())
					&& password.equals(AppApplication.ldir.get(i).getContraseña())) {
				encontrado = true;
				modelo.setViewName("menuDirector");

			}

		}
		if (!encontrado) {
			modelo.setViewName("error");
		}

		return modelo;
	}

	@RequestMapping("altaDirector")
	public ModelAndView getAltaDirector(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelo = new ModelAndView();
		String nombre = req.getParameter("nombre");
		String correo = req.getParameter("correo");
		String password = req.getParameter("p");

		Director dir = new Director(nombre, correo, password);

		AppApplication.ldir.add(dir);
		modelo.setViewName("iniciarSesion");
		return modelo;
	}

	@RequestMapping("altaSocio")
	public ModelAndView getAltaSocio(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView modelo = new ModelAndView();
		String nombre = req.getParameter("nombre");
		String telefono = req.getParameter("telefono");
		String email = req.getParameter("email");
		String cuenta_bancaria = req.getParameter("cuenta_bancaria");
		String tipo_cuota = req.getParameter("tipo_cuota");

		Socio socio = new Socio(nombre, telefono, email, cuenta_bancaria, tipo_cuota);
		socio.setNumero_socio(UUID.randomUUID());
		AppApplication.lsocios.add(socio);
		modelo.setViewName("volver");
		return modelo;

	}
}
