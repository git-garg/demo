package ec.com.empresa.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "cliente")
public class ClienteController {

	@GetMapping(value = { "/", "lista" })
	public String obtenerListCliente(Model model) {
		model.addAttribute("tituloCliente", "Lista cliente");
		model.addAttribute("nombreCliente", "Nombre de la Empresa");
		return "listaCliente";
	}
}
