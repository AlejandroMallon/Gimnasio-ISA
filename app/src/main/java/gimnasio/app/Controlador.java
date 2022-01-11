package gimnasio.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	

	

	@GetMapping(value = "/tablaSocios")
    public String tablaSocios(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
		model.addAttribute("titulo", "nombreAplicacion");
        model.addAttribute("socios", AppApplication.lsocios);

        return "lista";

	
}

		@GetMapping("/menuDirector")
		public String menuDirector(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
				Model model) {
			model.addAttribute("name", name);
			return "menuDirector";
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
		/*@GetMapping("/tablaSocios")
		public String tablaSocios(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
				Model model) {
			model.addAttribute("name", name);
			return "tablaSocios";
		}*/

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
					modelo.setViewName("/menuDirector");

				}

			}
			if (!encontrado) {
				modelo.setViewName("/error");
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
			String t_cuota = req.getParameter("tipo_cuota");
			char tipo_cuota = t_cuota.charAt(0);

			Socio socio = new Socio(nombre, telefono, email, cuenta_bancaria, tipo_cuota);

			AppApplication.lsocios.add(socio);
			modelo.setViewName("menuDirector");
			return modelo;

		}
}
