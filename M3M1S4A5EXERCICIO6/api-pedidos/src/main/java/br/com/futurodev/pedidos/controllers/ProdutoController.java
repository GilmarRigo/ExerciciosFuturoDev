package br.com.futurodev.pedidos.controllers;

import br.com.futurodev.pedidos.dto.ClienteRepresentationModel;
import br.com.futurodev.pedidos.dto.ProdutoRepresentationModel;
import br.com.futurodev.pedidos.input.ClienteInput;
import br.com.futurodev.pedidos.input.ProdutoInput;
import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.Produto;
import br.com.futurodev.pedidos.service.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;
    private ProdutoRepresentationModel produtoRepresentationModel;


    @PostMapping
    public ResponseEntity<ProdutoRepresentationModel> cadastrar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = toDomainObject(produtoInput);
        cadastroProdutoService.salvar(produto);
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.CREATED);
    }

   /* @PutMapping
    public ResponseEntity<ProdutoRepresentationModel> atualizar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = cadastroProdutoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }*/

    @PutMapping
    public ResponseEntity<ProdutoRepresentationModel> atualizar (@RequestBody ProdutoInput produtoInput) {
        Produto produto = toDomainObject(produtoInput);
        cadastroProdutoService.salvar(produto);
        return new ResponseEntity<ProdutoRepresentationModel>(toModel(produto), HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto) {
        cadastroProdutoService.deleteById(idProduto);
        return new ResponseEntity<String>("Produto ID: " + idProduto + ": deletado com sucesso!", HttpStatus.OK);
    }


    @GetMapping(value = "/produto/{idProduto}")
    public ResponseEntity<ProdutoRepresentationModel> getProdutoById(@PathVariable(value = "idProduto") Long idProduto) {
        ProdutoRepresentationModel produtoRepresentationModel = toModel(cadastroProdutoService.getProdutoById(idProduto));
        return new ResponseEntity<ProdutoRepresentationModel>(produtoRepresentationModel, HttpStatus.OK);
    }

    @GetMapping(value = "/produto")
    public ResponseEntity<List<ProdutoRepresentationModel>> getProdutosByName(
            @RequestParam(name = "descricao") String descricao) {
        List<Produto> produtos = cadastroProdutoService.getProdutosByDescricao(descricao);
        List<ProdutoRepresentationModel> produtosRepresentationModel = toCollectionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModel, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProdutoRepresentationModel>> getProdutos() {
        List<Produto> produtos = cadastroProdutoService.getProdutos();
        List<ProdutoRepresentationModel> produtosRepresentationModel = toCollectionModel(produtos);
        return new ResponseEntity<List<ProdutoRepresentationModel>>(produtosRepresentationModel, HttpStatus.OK);
    }

    private Produto toDomainObject(ProdutoInput produtoInput) {
        Produto produto = new Produto();
        produto.setId(produtoInput.getId());
        //produto.setId(produtoInput.getIdProduto());
        produto.setDescricao(produtoInput.getDescricao());
        produto.setPrecoCompra(produtoInput.getPrecoCompra());
        produto.setPrecoVenda(produtoInput.getPrecoVenda());
        produto.setDecricaoReduzida(produtoInput.getDescricaoReduzida());
        return produto;
    }

    private ProdutoRepresentationModel toModel(Produto produto) {
        ProdutoRepresentationModel produtoRepresentationModel = new ProdutoRepresentationModel();
        produtoRepresentationModel.setId(produto.getId());
        produtoRepresentationModel.setDescricao(produto.getDescricao());
        produtoRepresentationModel.setPrecoCompra(produto.getPrecoCompra());
        produtoRepresentationModel.setPrecoVenda(produto.getPrecoVenda());
        produtoRepresentationModel.setDescricaoReduzida((produto.getDecricaoReduzida()));
        return produtoRepresentationModel;
    }

    private List<ProdutoRepresentationModel> toCollectionModel(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto -> toModel(Produto))
                .collect(Collectors.toList());

    }
}