package gusi.springframework.projetofinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gusi.springframework.projetofinancas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
