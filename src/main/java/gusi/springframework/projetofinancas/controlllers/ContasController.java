package gusi.springframework.projetofinancas.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.projetofinancas.models.Conta;
import gusi.springframework.projetofinancas.orm.SomaCategoria;
import gusi.springframework.projetofinancas.repositories.ContasRepository;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

	@Autowired
	private ContasRepository contasRepository;
	
		
	
	@GetMapping("/{id}")
	public List<Conta> listarContas(@PathVariable Long id){
		List<Conta> contas = contasRepository.findByUsuarioId(id);
		return contas;
	}
	
	@GetMapping("/categorias/{id}")
	public List<SomaCategoria> listarContasCategoria(@PathVariable Long id) {		
		List<SomaCategoria> contas = contasRepository.somarCategorias(id);
		return contas;
		
	}	
	
	
	@GetMapping("/{id}/{mes}")
	public List<Conta> listarContas(@PathVariable Long id, @PathVariable String mes){
		List<Conta> contas = contasRepository.listarContasMes(id,mes);
		return contas;
	}
	
	@PostMapping
	public void cadastrarConta(@RequestBody Conta conta) { 
		contasRepository.save(conta);				
				
	}
	
	
}
