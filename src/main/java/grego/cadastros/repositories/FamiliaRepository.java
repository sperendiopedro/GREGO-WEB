package grego.cadastros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import grego.cadastros.models.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
}
