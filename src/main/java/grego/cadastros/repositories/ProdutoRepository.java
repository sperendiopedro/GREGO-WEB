package grego.cadastros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grego.cadastros.models.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
