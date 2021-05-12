package gusi.springframework.projetofinancas.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contas {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	private Double valor;
	private LocalDate data;	
	private String tipo;
	@ManyToOne
	private Usuario usuario;


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
	
	
	
	
}
