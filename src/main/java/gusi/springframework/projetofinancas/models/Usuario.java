package gusi.springframework.projetofinancas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Contas> contas = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getSenha() {
		return senha;
	}


	public List<Contas> getContas() {
		return contas;
	}


	public void setContas(List<Contas> contas) {
		this.contas = contas;
	}	
	
	
}