package ec.com.empresa.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/app")
public class IndexController {
	/*
	 * Aternativa 1
	 */
//	@RequestMapping(value = "index", method = RequestMethod.GET)
//	public String inicio() {
//		return "index";
//	}

	/*
	 * Alternativa 2
	 */
//	@GetMapping(value = { "/", "/home", "/index" })
//	public String index(Map<String, Object> mapa) {
//		mapa.put("titulo", "Titulo Spring");
//		mapa.put("subTitulo", "Hola Spring..! Por fin salió");
//		return "index";
//	}

	/*
	 * Alternativa 3
	 */

//	@GetMapping({"/","/home","index"})
//	public ModelAndView index(ModelAndView mav) {
//		mav.addObject("titulo","Spring");
//		mav.addObject("subTitulo","Hola Spring");
//		mav.setViewName("index");
//		return mav;
//	}

	/*
	 * Alternativa 4
	 */
	
	@Value("${text.index.controller.titulo}")
	private String titulo;
	
	@Value("${text.index.controller.subtitulo}")
	private String subTitulo;
	
	@GetMapping(value = { "/", "/home", "/index" })
	public String index(Model model) {
		//model.addAttribute("titulo", "Titulo Spring");
		model.addAttribute("titulo", titulo);
		//model.addAttribute("subTitulo", "Hola Spring con Model");
		model.addAttribute("subTitulo", subTitulo);
		return "inicio";
	}

}
