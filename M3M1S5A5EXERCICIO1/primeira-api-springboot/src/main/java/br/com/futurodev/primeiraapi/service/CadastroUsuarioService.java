package br.com.futurodev.primeiraapi.service;


import br.com.futurodev.primeiraapi.model.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvar(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public UsuarioModel getUserById(Long idUsuario){
        return usuarioRepository.findById(idUsuario).get();
    }

    public List<UsuarioModel> getUserByName(String nome){
        return usuarioRepository.getUserByName(nome);

    }


}
