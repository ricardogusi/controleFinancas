package gusi.springframework.projetofinancas.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.projetofinancas.dtos.ContaDTO;
import gusi.springframework.projetofinancas.models.Conta;
import gusi.springframework.projetofinancas.orm.SomaCategoria;
import gusi.springframework.projetofinancas.orm.TotalMensal;
import gusi.springframework.projetofinancas.repositories.ContasRepository;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

	@Autowired
	private ContasRepository contasRepository;
	
	@PostMapping
	@Transactional
	public void cadastrarConta(@RequestBody Conta conta) { 
		contasRepository.save(conta);				
				
	}		
	
	@GetMapping("/{id}")
	public List<ContaDTO> listarContas(@PathVariable Long id){
		List<Conta> contas = contasRepository.findByUsuarioId(id);
		return ContaDTO.converter(contas);
	}
	
	@GetMapping("/categorias/{id}/{ano}")
	public List<SomaCategoria> listarContasCategoria(@PathVariable Long id, @PathVariable String ano) {		
		List<SomaCategoria> contas = contasRepository.somarCategorias(id, ano);
		return contas;
		
	}	
	
	
	@GetMapping("/{id}/{mes}/{ano}")
	public List<ContaDTO> listarContas(@PathVariable Long id, @PathVariable String mes, @PathVariable String ano){
		List<Conta> contas = contasRepository.listarContasMesAno(id,mes, ano);
		return ContaDTO.converter(contas);
	}
	
	@GetMapping("/totalmensal/{id}/{mes}/{ano}")
	public List<TotalMensal> listarTotalMensal(@PathVariable Long id, @PathVariable String mes, @PathVariable String ano) { 
		List<TotalMensal> contas = contasRepository.listarTotalMensal(id,mes,ano);
		return contas;
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletarConta(@PathVariable Long id) {
		contasRepository.deleteById(id);		
	}
	
	
}
