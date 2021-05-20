package gusi.springframework.projetofinancas.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import gusi.springframework.projetofinancas.models.Categoria;
import gusi.springframework.projetofinancas.models.Conta;

public class ContaDTO {

	private Long id; 
	private String nome;
	private Double valor;
	private LocalDate data;	
	private Categoria categoria;	
	private Long usuarioId;
	
	public ContaDTO(Conta conta) { 
		this.id = conta.getId();
		this.nome = conta.getNome();
		this.valor = conta.getValor();
		this.data = conta.getData();
		this.categoria = conta.getCategorias();
		this.usuarioId = conta.getUsuarioId();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public static List<ContaDTO> converter(List<Conta> contas) {
		return contas.stream().map(ContaDTO::new).collect(Collectors.toList()	);
	}
	
		
		
}
