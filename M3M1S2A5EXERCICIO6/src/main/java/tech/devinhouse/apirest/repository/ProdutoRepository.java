package tech.devinhouse.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.apirest.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
