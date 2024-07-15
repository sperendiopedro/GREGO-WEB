package grego.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import grego.models.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
}
