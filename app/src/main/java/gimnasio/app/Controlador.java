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
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/menuDirector")
	public String menuDirector(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "menuDirector";
	}

	@GetMapping("/iniciarSesion")
	public String iniciaSesion(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "iniciarSesion";
	}

	@GetMapping("/error")
	public String error(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "error";
	}
	


	@RequestMapping("validador")
	public ModelAndView getValidaLogin(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelo = new ModelAndView();
		String usuario = req.getParameter("u");
		String password = req.getParameter("p");
		if(usuario.equals("admin") && password.equals("12345")){
			modelo.setViewName("/menuDirector");
			
		}
		else{
			modelo.setViewName("/error");
		}
		return modelo;
	}

	@RequestMapping("altaDirector")
	public ModelAndView getAltaDirector(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView modelo = new ModelAndView();
		String nombre = req.getParameter("nombre");
		String correo = req.getParameter("correo");
		String password = req.getParameter("p");

		Director dir = new Director(nombre, correo, password);

		modelo.setViewName("menuDirector");
		
		
		

		return modelo;
	}


}
