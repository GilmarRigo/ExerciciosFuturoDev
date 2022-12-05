package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.dto.TelefoneRepresentationModel;
import br.com.futurodev.primeiraapi.dto.UsuarioRepresentationModel;
import br.com.futurodev.primeiraapi.input.UsuarioInput;
import br.com.futurodev.primeiraapi.model.TelefoneModel;
import br.com.futurodev.primeiraapi.model.UsuarioModel;
import br.com.futurodev.primeiraapi.repository.UsuarioRepository;
import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioContoller {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

  /*  @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> cadastrar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.CREATED);
    }*/

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> cadastrar(@RequestBody UsuarioInput usuarioInput){
        // Converte UsuarioInput em UsuarioModel
        UsuarioModel usu = toDomainObject(usuarioInput);
        // chama nosso service para salvar o UsuarioModel no bando de dados
        cadastroUsuarioService.salvar(usu);
        // mostramos o retorno com a resposta da requisição, convertemos UsuarioModel em RepresentationModel
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.CREATED);

    }

   /* @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> atualizar(@RequestBody UsuarioModel usuario){
        UsuarioModel usu = cadastroUsuarioService.salvar(usuario);
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.OK);
    }*/

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> atualizar(@RequestBody UsuarioInput usuarioInput){
        UsuarioModel usu = cadastroUsuarioService.salvar(toDomainObject(usuarioInput));
        return new ResponseEntity<UsuarioRepresentationModel>(toModel(usu), HttpStatus.OK);
    }


    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUsuario){
        cadastroUsuarioService.delete(idUsuario);
        return new ResponseEntity<String>("Usuário deletado com sucesso!",HttpStatus.OK);
    }

/*    @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioModel> getuserById(@PathVariable(value = "idUsuario") Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById(idUsuario);
        return new ResponseEntity<UsuarioModel>(usu, HttpStatus.OK);
    }*/

    @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<UsuarioRepresentationModel> getuserById(@PathVariable(value = "idUsuario") Long idUsuario){
        UsuarioModel usu = cadastroUsuarioService.getUserById(idUsuario);
        UsuarioRepresentationModel usuarioRepresentationModel = toModel(usu);

        return new ResponseEntity<UsuarioRepresentationModel>(usuarioRepresentationModel, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UsuarioRepresentationModel>> getUserByName(@RequestParam(name = "nome") String nome){

        //obtem a lista de usuário do tipo Model, nossas entidades
        List<UsuarioModel> usuarios = cadastroUsuarioService.getUserByName(nome);

        // nos convertemos o objeto do tipo UsuarioModel para RepresentationModel (DTO)
        List<UsuarioRepresentationModel> usuariosRepresentationModel = toCollectionModel(usuarios);
        return new ResponseEntity<List<UsuarioRepresentationModel>>(usuariosRepresentationModel, HttpStatus.OK);
    }

    // converte um objeto do tipo UsuarioModel para um objeto do tipo RepresentationModel

    private UsuarioRepresentationModel toModel(UsuarioModel usu) {
        UsuarioRepresentationModel usuarioRepresentationModel = new UsuarioRepresentationModel();
        usuarioRepresentationModel.setId(usu.getId());
        usuarioRepresentationModel.setNome(usu.getNome());
        usuarioRepresentationModel.setLogin(usu.getLogin());
        usuarioRepresentationModel.setSenha(usu.getSenha());
        usuarioRepresentationModel.setDataCadastro(usu.getDataCadastro());
        usuarioRepresentationModel.setDataAtualizacao(usu.getDataAtualizacao());


        for(int i = 0; i < usu.getTelefones().size(); i++){

            TelefoneRepresentationModel telefoneRepresentationModel = new TelefoneRepresentationModel();
            telefoneRepresentationModel.setTipo(usu.getTelefones().get(i).getTipo());
            telefoneRepresentationModel.setNumero(usu.getTelefones().get(i).getNumero());
            telefoneRepresentationModel.setId(usu.getTelefones().get(i).getId());

            usuarioRepresentationModel.getTelefones().add(telefoneRepresentationModel);
        }

        return usuarioRepresentationModel;
    }

    // Converte uma lista de objetos
    private List<UsuarioRepresentationModel> toCollectionModel(List<UsuarioModel> usuariosModel){
        return usuariosModel.stream()
                .map(usuarioModel -> toModel(usuarioModel))
                .collect((Collectors.toList()));
    }

    // Converter um objeto do tipo UsuarioInput para UsuarioModel para uma lista de objetos do tipo UsuarioRepresentationModel
    private UsuarioModel toDomainObject(UsuarioInput usuarioInput){

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioInput.getId());
        usuarioModel.setNome(usuarioInput.getNome());
        usuarioModel.setLogin(usuarioInput.getLogin());
        usuarioModel.setSenha(usuarioInput.getSenha());

        for(int i = 0; i < usuarioInput.getTelefones().size(); i++){

            TelefoneModel telefoneModel = new TelefoneModel();
            telefoneModel.setTipo(usuarioInput.getTelefones().get(i).getTipo());
            telefoneModel.setNumero(usuarioInput.getTelefones().get(i).getNumero());
            telefoneModel.setId(usuarioInput.getTelefones().get(i).getId());


           usuarioModel.getTelefones().add(telefoneModel);
        }

        return usuarioModel;

    }

}
