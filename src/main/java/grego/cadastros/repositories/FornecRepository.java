package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.cadastros.models.Fornecedor;

public interface FornecRepository extends JpaRepository<Fornecedor, Long>{
	Optional<Fornecedor> findByCnpj(String cnpj); 
}
