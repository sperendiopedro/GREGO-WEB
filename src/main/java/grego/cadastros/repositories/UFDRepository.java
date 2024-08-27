package grego.cadastros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.UFD;

public interface UFDRepository extends JpaRepository<UFD, Long> {
	
	@Query("SELECT u FROM UFD u WHERE u.sigla = :sigla AND u.ufdEmp = :empresa")
	Optional<UFD> findBySiglaAndUfdEmp(@Param("sigla") String sigla, @Param("empresa") Empresa empresa);

}