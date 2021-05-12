package gusi.springframework.projetofinancas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gusi.springframework.projetofinancas.models.Contas;


public interface ContasRepository extends JpaRepository<Contas, Long>{

}
