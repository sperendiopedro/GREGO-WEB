package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.Familia;
import grego.cadastros.models.UFD;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
	@Query("SELECT u FROM Familia u WHERE u.descr = :descr AND u.famEmp = :empresa")
	Optional<Familia> findBySiglaAndUfdEmp(@Param("descr") String descr, @Param("empresa") Empresa empresa);
}