package gusi.springframework.projetofinancas.controlllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import gusi.springframework.projetofinancas.orm.SomaPagadores;
import gusi.springframework.projetofinancas.orm.TotalMensal;
import gusi.springframework.projetofinancas.repositories.ContasRepository;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

	@Autowired
	private ContasRepository contasRepository;
		

	//CADASTRAR CONTAS
	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaDTO> cadastrarConta(@RequestBody @Valid Conta conta) {

		if (ContaDTO.class.getDeclaredFields().toString().isEmpty()) {
			return ResponseEntity.badRequest().build();
		} else {
			contasRepository.save(conta);
			return ResponseEntity.ok(new ContaDTO(conta.getId(), conta.getNome(), conta.getValor(),
					conta.getData(), conta.getCategorias(), conta.getUsuario(), conta.getPagador()));
		}
	}

	//LISTAR CONTAS DO USUÁRIO
	@GetMapping("/{id}")
	public ResponseEntity<List<ContaDTO>> listarContas(@PathVariable Long id) {

		if (contasRepository.findByUsuarioOrderByDataDesc(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			List<Conta> contas = contasRepository.findByUsuarioOrderByDataDesc(id);
			List<ContaDTO> result = ContaDTO.converter(contas);
			return ResponseEntity.ok().body(result);
		}
	}

	//LISTAR CONTAS DA CATEGORIA POR ANO
	@GetMapping("/categorias/{id}/{ano}")	
	public ResponseEntity<List<SomaCategoria>> listarContasCategoria(@PathVariable Long id, @PathVariable String ano) {

		if (id == null | ano == null) {
			return ResponseEntity.notFound().build();
		} else {
			List<SomaCategoria> contas = contasRepository.listarContasCategoria(id, ano);
			
			return ResponseEntity.ok(contas);
		}

	}
	
	//LISTAR CONTAS DA CATEGORIA POR NOME/MES/ANO
	@GetMapping("/categoria/{id}/{nome}/{mes}/{ano}")
	public ResponseEntity<SomaCategoria> listarContasCategoria(@PathVariable Long id, 
			@PathVariable String nome, @PathVariable String mes, @PathVariable String ano) {

		if (nome == null | mes == null) {
			return ResponseEntity.notFound().build();
		} else {
			Optional<SomaCategoria> contas = contasRepository.somarCategoriaNomeMes(id,nome, mes,ano);
			return ResponseEntity.ok(contas.get());
		}

	}

	//LISTAR CONTAS POR MES/ANO
	@GetMapping("/{id}/{mes}/{ano}")
	public ResponseEntity<List<ContaDTO>> listarContas(@PathVariable Long id, @PathVariable String mes,
			@PathVariable String ano) {

		if (id == null | mes == null | ano == null) {
			return ResponseEntity.notFound().build();
		} else {
			List<Conta> contas = contasRepository.listarContasMesAno(id, mes, ano);
			List<ContaDTO> result = ContaDTO.converter(contas);
			return ResponseEntity.ok().body(result);
		}
	}

	//LISTAR TOTAL MENSAL DAS CONTAS POR MES/ANO
	@GetMapping("/totalmensal/{id}/{mes}/{ano}")
	public ResponseEntity<List<TotalMensal>> listarTotalMensal(@PathVariable Long id, @PathVariable String mes,
			@PathVariable String ano) {
		if (id == null | mes == null | ano == null) {
			return ResponseEntity.notFound().build();
		} else {
			List<TotalMensal> contas = contasRepository.listarTotalMensal(id, mes, ano);
			return ResponseEntity.ok().body(contas);
		}
	}
	
	
	//LISTAR CONTAS POR PAGADORES/MES/ANO
	@GetMapping("/pagadores/{id}/{mes}/{ano}")
	public ResponseEntity<List<SomaPagadores>> listarPagadoresMesAno(@PathVariable Long id, @PathVariable String mes, @PathVariable String ano ) {
		if(id == null | mes == null | ano ==null) {
			return ResponseEntity.notFound().build();
		} else { 
			List<SomaPagadores> contaPagadores = contasRepository.contasPagadores(id, mes, ano);
			return ResponseEntity.ok().body(contaPagadores);
		}
	}
	
	

	//DELETAR ALGUMA CONTA
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarConta(@PathVariable Long id) {
		if (id == null) {
			return ResponseEntity.notFound().build();
		} else {
			contasRepository.deleteById(id);
			return new ResponseEntity<>("Conta Deletada", HttpStatus.OK);
		}
	}

}
