package gusi.springframework.projetofinancas.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Conta {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	private Double valor;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	@NotNull
	@Enumerated(EnumType.STRING)
	private  Categoria categorias ;
	
	private Long usuarioId;

	
	public Conta() { 
		
	}
	
	
	public Conta(Long id, String nome, Double valor, LocalDate data, Categoria categorias) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.data = data;
		this.categorias = categorias;
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
	
	
	public Categoria getCategorias() {
		return categorias;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", nome=" + nome + ", valor=" + valor + ", data=" + data
				+ ", categorias=" + categorias + "]";
	}	
	
	
	
	
	
}
