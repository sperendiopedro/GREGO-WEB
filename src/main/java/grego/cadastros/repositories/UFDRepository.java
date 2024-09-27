package grego.cadastros.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grego.cadastros.models.Empresa;
import grego.cadastros.models.UFD;

public interface UFDRepository extends JpaRepository<UFD, Long> {
	Optional<UFD> findBySigla(String sigla); 
}