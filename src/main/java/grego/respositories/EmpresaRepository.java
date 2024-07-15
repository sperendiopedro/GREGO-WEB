package grego.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grego.models.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
