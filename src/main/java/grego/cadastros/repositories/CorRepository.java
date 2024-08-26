package grego.cadastros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.cadastros.models.Cor;

public interface CorRepository extends JpaRepository<Cor, Long> {

}
