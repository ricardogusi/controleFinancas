package gusi.springframework.projetofinancas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gusi.springframework.projetofinancas.models.Conta;
import gusi.springframework.projetofinancas.orm.SomaCategoria;
import gusi.springframework.projetofinancas.orm.TotalMensal;


public interface ContasRepository extends JpaRepository<Conta, Long>{

	
	List<Conta> findByUsuarioId(Long id);

	@Query(value = "SELECT  c.categorias, sum(c.valor) VALOR FROM conta c WHERE c.usuario_id = :id "
			+ "and YEAR(data) = :ano GROUP BY c.categorias", nativeQuery = true)
	Optional<SomaCategoria> somarCategorias(Long id, String ano);	
	
	@Query(value = "SELECT  c.categorias, sum(c.valor) VALOR FROM conta c WHERE c.usuario_id = :id "
			+ "and MONTH(data) = :mes and YEAR(data) = :ano and c.categorias LIKE  :nome  GROUP BY c.categorias", nativeQuery = true)
	Optional<SomaCategoria> somarCategoriaNomeMes(Long id,String nome, String mes, String ano);	
	

	@Query(value = "SELECT * FROM conta c WHERE c.usuario_id = :id and MONTH(data) = :mes and YEAR(data) = :ano", nativeQuery = true)
	List<Conta> listarContasMesAno(Long id, String mes, String ano);

	@Query(value = "SELECT SUM(c.valor) VALOR FROM conta c WHERE c.usuario_id = :id "
			+ "and MONTH(data) = :mes and YEAR(data) = :ano", nativeQuery = true)
	List<TotalMensal> listarTotalMensal(Long id, String mes, String ano);
}