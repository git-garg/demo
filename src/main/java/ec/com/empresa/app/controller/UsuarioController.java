package ec.com.empresa.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.com.empresa.app.model.Usuario;

@Controller
@RequestMapping(value = "app")
public class UsuarioController {

	@GetMapping(value = "usuario")
	public String obtenerUsurio(Model model) {

		Usuario usuario = obtenerUsuario("Gabriel", "Reyes", "greyes@dominio.com");

		model.addAttribute("titulo", "Usuario - " + usuario.getNombre());
		model.addAttribute(usuario);

		return "usuario";
	}

	private Usuario obtenerUsuario(String nombre, String apellido, String email) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		return usuario;
	}

	@GetMapping(value = { "/listaUsuario", "/usuarios" } /* La url que se debe usar en el navegador */)
	public String obtenerListaUsuario(Model model) {

//		List<Usuario> listaUsuario = new ArrayList<>();
//		listaUsuario.add(obtenerUsuario("Gabriel", "Reyes", "greyes@dominio.com"));
//		listaUsuario.add(obtenerUsuario("Michelle", "Donoso", "mdonoso@dominio.com"));
//		listaUsuario.add(obtenerUsuario("Fabián", "Gómez", "fgomez@dominio.com"));

//		listaUsuario = obtenerUsuarios();

		model.addAttribute("titulo", "Lista de usuarios");
//		model.addAttribute("listaUsuario", listaUsuario);

		return "listaUsuario";
	}

	@ModelAttribute("listaUsuario" /* Nombre del atributo que se usa en la vista */)
	public List<Usuario> obtenerListaUsuario() {
		return obtenerUsuarios();
	}

	private List<Usuario> obtenerUsuarios() {
		return Arrays.asList(obtenerUsuario("Paul", "Reyes", "preyes@dominio.com"),
				obtenerUsuario("Gabriel", "Reyes", "greyes@dominio.com"),
				obtenerUsuario("Michelle", "Donoso", "mdonoso@dominio.com"),
				obtenerUsuario("Fabián", "Gómez", "fgomez@dominio.com"));
	}

}
