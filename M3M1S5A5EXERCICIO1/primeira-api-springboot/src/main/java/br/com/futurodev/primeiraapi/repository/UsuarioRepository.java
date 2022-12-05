package br.com.futurodev.primeiraapi.repository;

import br.com.futurodev.primeiraapi.model.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

   @Query(value = " select c from Usuario c where c.nome like %?1% ")
    ArrayList<Usuario> getUserByName(String nome);

   @Query(value = "select u from Usuario u where u.login = ?1")
   Usuario findUserByLogin(String login);

}
