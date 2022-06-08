package ec.com.empresa.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

//	@GetMapping("string/{texto}")
//	public String variables(@PathVariable(name = "texto")  String otroTexto, Model model) {
//		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
//		model.addAttribute("respuesta", "El texto enviado en la ruta es: " + otroTexto);
//		return "variables/ver";
//	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
		model.addAttribute("varTexto", "Esto es un texto en variable");
		model.addAttribute("varNumero", "36");
		
		return "variables/index";
	}

	@GetMapping("string/{texto}")
	public String variablesDos(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("respuesta", "El texto enviado en la ruta es: " + texto);
		return "variables/ver";
	}

	@GetMapping("string/{texto}/{numero}")
	public String variablesDos(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("respuesta", "El texto enviado en la ruta es: " + texto + " y el número es: " + numero);
		return "variables/ver";
	}

}
