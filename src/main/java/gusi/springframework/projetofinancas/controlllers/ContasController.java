package gusi.springframework.projetofinancas.controlllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.projetofinancas.dtos.ContasDTO;
import gusi.springframework.projetofinancas.models.Contas;
import gusi.springframework.projetofinancas.models.Usuario;
import gusi.springframework.projetofinancas.repositories.ContasRepository;
import gusi.springframework.projetofinancas.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

	@Autowired
	private ContasRepository contasRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@GetMapping("/{id}")
//	public List<ContasDTO>listarContas(@PathVariable Long id){
//		Optional<Usuario> user = usuarioRepository.findById(id);
//		
//		List<Contas> contas = contasRepository.findAll();
//		return ContasDTO.converter(contas);
//	}
	
}
