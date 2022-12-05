package br.com.futurodev.primeiraapi.controllers;

import br.com.futurodev.primeiraapi.model.ProdutoModel;
import br.com.futurodev.primeiraapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired // IC/CD/CDI Injeção de Dependecia
    private ProdutoRepository produtoRepository;

    /**
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostrarvalor/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping(value = "/mostrarnome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String mostrarnome(@PathVariable String nome) {
        return "Olá " + nome;
    }

    @RequestMapping(value = "/produto/{descricao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String descricao) {

        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        produtoRepository.save(produto); //grava no banco de dados um produto

        return "Produto " + descricao + " registrado com sucesso!";
    }

    @GetMapping(value = "/produtos")
    @ResponseBody // Retorna os dados no corpo da resposta
    public ResponseEntity<List<ProdutoModel>> listaProdutos() {

        List<ProdutoModel> produtos = produtoRepository.findAll(); // Consulta no banco de dados todos os produtos

        return new ResponseEntity<List<ProdutoModel>>(produtos, HttpStatus.OK); // Retorna a lista JSON

    }

    @PostMapping(value = "/produto/salvar") /* Mapeia URL */
    @ResponseBody /* Descreve a resposta informandp que o retorno será no corpo da requisição */
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produto) { /* Recebe os dados para salvar */

        ProdutoModel prod = produtoRepository.save(produto);
        return new ResponseEntity<ProdutoModel>(prod, HttpStatus.CREATED);

}


    @DeleteMapping(value = "/produto/delete") /* Mapeia URL */
    @ResponseBody /* Descrição da resposta */
    public ResponseEntity<String>delete(@RequestParam Long idProduto){ /* Recebe da requisição o parâmetro */

        produtoRepository.deleteById(idProduto);

        return new ResponseEntity<String>("Produto deletado com sucesso.", HttpStatus.OK);


}

    /*
    @GetMapping(value = "/hello/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@PathVariable String nome){
        return "Olá " + nome;
    }
    */


}
