package gusi.springframework.projetofinancas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gusi.springframework.projetofinancas.models.Conta;
import gusi.springframework.projetofinancas.orm.SomaCategoria;


public interface ContasRepository extends JpaRepository<Conta, Long>{

	
	List<Conta> findByUsuarioId(Long id);

	@Query(value = "SELECT  c.categorias, sum(c.valor) valor FROM conta c WHERE c.usuario_id = :id GROUP BY c.categorias", nativeQuery = true)
	List<SomaCategoria> somarCategorias(Long id);	
	

	@Query(value = "SELECT * FROM conta c WHERE c.usuario_id = :id and MONTH(data) = :mes", nativeQuery = true)
	List<Conta> listarContasMes(Long id, String mes);
}
