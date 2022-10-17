package tech.devinhouse.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.apirest.model.Produto;
import tech.devinhouse.apirest.repository.ProdutoRepository;
import java.util.List;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private ProdutoRepository produtoRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = "/produto/{descricao}/{estoque}/{valorUnitario}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(@PathVariable String descricao, @PathVariable Integer estoque, @PathVariable double valorUnitario){
        Produto novoProduto = new Produto();
        novoProduto.setDescricao(descricao);
        novoProduto.setEstoque(estoque);
        novoProduto.setValorUnitario(valorUnitario);
        produtoRepository.save(novoProduto);
        return "Item registrado com sucesso!";
    }

    @GetMapping(value = "/produtos")
    @ResponseBody
    public ResponseEntity<List<Produto>> listarProdutos(){

        List<Produto> produtos = produtoRepository.findAll();

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @PostMapping(value = "/produto/salvar")
    @ResponseBody
    public ResponseEntity<Produto> salvar(@RequestBody Produto novoProduto){
        Produto prod = produtoRepository.save(novoProduto);
        return new ResponseEntity<Produto>(prod, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/produto/delete")
    public ResponseEntity<String> delete(@RequestParam Long idProduto){
        produtoRepository.deleteById(idProduto);
        return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);

    }
}
