package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Query("SELECT u FROM Produto u WHERE u.descr = :descr AND u.prodEmp = :prodEmp")
	Optional<Produto> findByDescAndProdEmp(@Param("descr") String desc, @Param("prodEmp") Empresa prodEmp); 
}
