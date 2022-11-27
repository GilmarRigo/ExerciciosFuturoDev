package br.com.futurodev.pedidos.repository;

import br.com.futurodev.pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("from Produto p where p.descricao like %?1%")
    List<Produto> getProdutosByDescricao(String descricao);

}
