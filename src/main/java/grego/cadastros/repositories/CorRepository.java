package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Cor;
import grego.cadastros.models.Empresa;

public interface CorRepository extends JpaRepository<Cor, Long> {
	@Query("SELECT u FROM Cor u WHERE u.descr = :descr AND u.corEmp = :corEmp")
	Optional<Cor> findByDescrAndEmp(@Param("descr") String descr, @Param("corEmp") Empresa emp);
}
