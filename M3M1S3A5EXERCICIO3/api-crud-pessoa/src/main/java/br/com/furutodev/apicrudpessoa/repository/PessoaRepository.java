package br.com.furutodev.apicrudpessoa.repository;

import br.com.furutodev.apicrudpessoa.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {


}
