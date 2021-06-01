package gusi.springframework.projetofinancas.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import gusi.springframework.projetofinancas.models.Categoria;
import gusi.springframework.projetofinancas.models.Conta;

public class ContaDTO {

	private Long id; 
	private String nome;
	private Double valor;
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private LocalDate data;	
	private Categoria categoria;	
	private Long usuario;
	private Long pagador;
	
	
	
	
	public ContaDTO(Long id, String nome, Double valor, LocalDate data, Categoria categoria, Long usuario, Long pagador) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.data = data;
		this.categoria = categoria;
		this.usuario= usuario;
		this.pagador = pagador;
	}



	public ContaDTO(Conta conta) { 
		this.id = conta.getId();
		this.nome = conta.getNome();
		this.valor = conta.getValor();
		this.data = conta.getData();
		this.categoria = conta.getCategorias();
		this.usuario = conta.getUsuario();
		this.pagador = conta.getPagador();
		
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
		return usuario;
	}


	public Long getPagadorId() {
		return pagador;
	}



	public static List<ContaDTO> converter(List<Conta> contas) {
		return contas.stream().map(ContaDTO::new).collect(Collectors.toList()	);
	}
	

		
		
}
