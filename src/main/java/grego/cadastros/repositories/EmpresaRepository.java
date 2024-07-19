package grego.cadastros.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.cadastros.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	Empresa findByCnpj(String cnpj);
}
