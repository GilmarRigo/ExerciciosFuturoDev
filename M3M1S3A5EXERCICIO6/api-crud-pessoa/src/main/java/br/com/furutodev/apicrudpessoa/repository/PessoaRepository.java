package br.com.furutodev.apicrudpessoa.repository;

import br.com.furutodev.apicrudpessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    @Query(value = " select c from PessoaModel c where c.nome like %?1%")
    ArrayList<PessoaModel> getPessoaByName(String nome);


}
