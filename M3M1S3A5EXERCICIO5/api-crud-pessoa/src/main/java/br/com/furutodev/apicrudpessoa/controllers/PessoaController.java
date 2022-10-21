package br.com.furutodev.apicrudpessoa.controllers;


import br.com.furutodev.apicrudpessoa.model.PessoaModel;
import br.com.furutodev.apicrudpessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa){
        PessoaModel pes = pessoaRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaModel> getPessoaById(@PathVariable(value = "idPessoa") Long idPessoa){
        PessoaModel pes = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar(@RequestBody PessoaModel pessoa){
        PessoaModel pes = pessoaRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(pes, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Contato deletado com sucesso.", HttpStatus.OK);
    }


}
