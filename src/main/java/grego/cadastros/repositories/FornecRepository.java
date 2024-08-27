package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Fornecedor;
import grego.cadastros.models.UFD;

public interface FornecRepository extends JpaRepository<Fornecedor, Long>{
	
	@Query("SELECT u FROM Fornecedor u WHERE u.cnpj = :cnpj AND u.fornecEmp = :empresa")
	Optional<Fornecedor> findByCnpjAndFornecEmp(@Param("cnpj") String cnpj, @Param("empresa") Empresa empresa);

}
