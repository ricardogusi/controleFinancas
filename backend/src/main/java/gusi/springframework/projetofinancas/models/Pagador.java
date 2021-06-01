package gusi.springframework.projetofinancas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pagador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;	
	@NotBlank
	private String nome;		
	@NotNull	
	private Long usuario;

	@OneToMany(mappedBy = "pagador")
	private List<Conta> contas = new ArrayList<>();

	public Pagador() {

	}	
	

	public Pagador(String nome, Usuario usuario, List<Conta> contas) {

		this.nome = nome;
		this.usuario = usuario.getId();
		this.contas = contas;
	}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public Long getUsuario() {
		return usuario;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	

}
