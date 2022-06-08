package ec.com.empresa.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parametros")
public class ParametrosController {

	private static final String VALOR_POR_DEFECTO = "No existe valor de parametro..";

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parametros del request HTTP GET - URL");
		return "parametro/index";
	}

	@RequestMapping(value = "/cadena" /* La url que se debe escribir en el navegador */)
	public String parametro(
			@RequestParam(name = "texto", required = false, defaultValue = VALOR_POR_DEFECTO) String texto,
			Model model) {

		model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
		model.addAttribute("respuesta", "El valor del parametro es: " + texto);

		return "parametro/ver" /* nombre de la pagina html y la ruta en el proyecto */;
	}
	
	@RequestMapping(value = "/mix-parametros" /* La url que se debe escribir en el navegador */)
	public String parametro(
			@RequestParam String saludo,@RequestParam Integer numero, Model model) {

		model.addAttribute("titulo", "Recibir varios parametros del request HTTP GET - URL");
		model.addAttribute("respuesta", "El valor del saludo es: '" + saludo + "' el valor del numero es: '" + numero + "'");

		return "parametro/ver" /* nombre de la pagina html y la ruta en el proyecto */;
	}
	
	@RequestMapping(value = "/mix-parametros-request" /* La url que se debe escribir en el navegador */)
	public String parametro(HttpServletRequest request,  Model model) {

		model.addAttribute("titulo", "Recibir varios parametros del request HTTP GET - URL");
		
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e ) {
			numero = 0;
		}
		
		model.addAttribute("respuesta", "El valor del saludo es: '" + saludo + "' el valor del numero es: '" + numero + "'");

		return "parametro/ver" /* nombre de la pagina html y la ruta en el proyecto */;
	}
}
