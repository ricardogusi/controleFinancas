package gusi.springframework.projetofinancas.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ManyToOne;

import gusi.springframework.projetofinancas.models.Contas;
import gusi.springframework.projetofinancas.models.Usuario;

public class ContasDTO {

	private Long id; 
	private String nome;
	private Double valor;
	private LocalDate data;	
	private String tipo;
	@ManyToOne
	private Usuario usuario;
	
	public ContasDTO(Contas conta) { 
		this.id = conta.getId();
		this.nome = conta.getNome();
		this.valor = conta.getValor();
		this.data = conta.getData();
		this.tipo = conta.getTipo();
		this.usuario = conta.getUsuario();
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

	public String getTipo() {
		return tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public static List<ContasDTO> converter(List<Contas> contas) {
		return contas.stream().map(ContasDTO::new).collect(Collectors.toList()	);
	}
	
	
	
	
}
