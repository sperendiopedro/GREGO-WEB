package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Acabmat;
import grego.cadastros.models.Empresa;

public interface AcabmatRepository extends JpaRepository<Acabmat, Long>{
	@Query("SELECT u FROM Acabmat u WHERE u.descr = :descr AND u.acabmatEmp = :acabmatEmp")
	Optional<Acabmat> findByDescrAndEmp(@Param("descr") String descr, @Param("acabmatEmp") Empresa acabmatEmp); 
}
