package gusi.springframework.projetofinancas.controlllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.projetofinancas.dtos.UsuarioDTO;
import gusi.springframework.projetofinancas.models.Usuario;
import gusi.springframework.projetofinancas.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	
	@GetMapping
	public List<UsuarioDTO>listarUsuarios () { 		
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioDTO.converter(usuarios);
	}
	
	@GetMapping("/{id}")
	public List<UsuarioDTO>listarUsuarioId(@PathVariable Long id) {
		Optional<Usuario> usuarioId = usuarioRepository.findById(id);
		return UsuarioDTO.converter(usuarioId);
	}
	
	@PostMapping
	public void cadastrarUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
}
