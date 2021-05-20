package gusi.springframework.projetofinancas.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Conta {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	private Double valor;
	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;	
	@Enumerated(EnumType.STRING)
	private  Categoria categorias ;	
	private Long usuarioId;


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
	
	
	
}
