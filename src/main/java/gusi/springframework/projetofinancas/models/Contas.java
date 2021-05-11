package gusi.springframework.projetofinancas.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contas {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	private Double valor;
	private LocalDate data;
	
	
	private Tipo tipo;

	public Contas(String nome, Double valor, LocalDate data, Tipo tipo) {
		this.nome = nome;
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
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

	public Tipo getTipo() {
		return tipo;
	}
	
	
	
	
}
