package gusi.springframework.projetofinancas.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusi.springframework.projetofinancas.models.Pagador;
import gusi.springframework.projetofinancas.repositories.PagadorRepository;

@RestController
@RequestMapping("api/usuarios/pagadores")
public class PagadorController {

	@Autowired
	private PagadorRepository pagadorRepository;

	@GetMapping
	public List<Pagador> listarPagadores() {
		return pagadorRepository.findAll();
	}

	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrarPagador(@RequestBody  Pagador pagador) {

		pagadorRepository.save(pagador);
	}

}
