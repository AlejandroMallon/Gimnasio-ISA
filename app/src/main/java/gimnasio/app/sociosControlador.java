package gimnasio.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller
// @RequestMapping("socios")
// public class sociosControlador {

//     public static final String VISTA_LISTA = "lista";
//     public static final String VISTA_FORMULARIO = "formulario";

//     @PostMapping("/tablaSocios")
//     public ModelAndView listarModelAndView() {
//         ModelAndView mav = new ModelAndView();
//         mav.addObject("titulo", "name");
//         for(int i=0;i<AppApplication.lsocios.size();i++){
//             mav.addObject("socios", AppApplication.lsocios.get(i));
//         }
//         mav.setViewName(VISTA_LISTA);

//         return mav;
//     }

// }
