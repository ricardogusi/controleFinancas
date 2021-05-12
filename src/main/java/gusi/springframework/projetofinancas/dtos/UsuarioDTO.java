package gusi.springframework.projetofinancas.dtos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import gusi.springframework.projetofinancas.models.Usuario;

public class UsuarioDTO {

	private Long id; 
	private String nome;
	private String email;
	
	public UsuarioDTO(Usuario usuario) { 
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return  usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	public static List<UsuarioDTO> converter(Optional<Usuario> usuarioId) {
		return usuarioId.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	
}
