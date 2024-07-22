package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.cadastros.models.UFD;

public interface UFDRepository extends JpaRepository<UFD, Long>{
	UFD findBySigla(String sigla); 
}
