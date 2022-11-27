package br.com.futurodev.pedidos.controllers;

import br.com.futurodev.pedidos.dto.ItemPedidoRepresentationModel;
import br.com.futurodev.pedidos.dto.PedidoRepresentationModel;
import br.com.futurodev.pedidos.input.PedidoInput;
import br.com.futurodev.pedidos.model.*;
import br.com.futurodev.pedidos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pedidos")

public class PedidoController {

    @Autowired
    private CadastroPedidoService cadastroPedidoService;

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamentoService;

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @Autowired
    private CadastroItemPedidoService cadastroItemPedidoService;

    @PostMapping
    public ResponseEntity<PedidoRepresentationModel> cadastrar(@RequestBody PedidoInput pedidoInput) {
        Pedido pedido = cadastroPedidoService.salvar(toDomainObject(pedidoInput));
        return new ResponseEntity<PedidoRepresentationModel>(toRepresentationModel(pedido), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PedidoRepresentationModel> atualizar(@RequestBody PedidoInput pedidoInput) {
        Pedido pedido = cadastroPedidoService.salvar(toDomainObject((pedidoInput)));
        return new ResponseEntity<PedidoRepresentationModel>(toRepresentationModel(pedido), HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPedido){
        cadastroPedidoService.deletePedidoById((idPedido));
        return new ResponseEntity<String>("Pedido de ID " + idPedido + "deletado.", HttpStatus.OK);
    }

    @GetMapping(value = "/{idPedido}")
    public ResponseEntity<PedidoRepresentationModel> getUserById(@PathVariable(value = "idPedido") Long idPedido) {
        Pedido pedido = cadastroPedidoService.getPedidoById(idPedido);
        PedidoRepresentationModel pedidoRepresentationModel = toRepresentationModel(cadastroPedidoService.getPedidoById(idPedido));
        return new ResponseEntity<PedidoRepresentationModel>(pedidoRepresentationModel, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PedidoRepresentationModel>> getPedidos() {
        List<Pedido> pedidos = cadastroPedidoService.getPedidos();
        return new ResponseEntity<List<PedidoRepresentationModel>>(toCollectionRepresentationModel(pedidos), HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{idCliente}")
    public ResponseEntity<List<PedidoRepresentationModel>> getPedidoByIdCliente(
            @PathVariable(name = "idCliente") Long idCliente) {

        List<Pedido> pedidos = cadastroPedidoService.getPedidoByIdCliente(idCliente);
        List<PedidoRepresentationModel> pedidosRM = toCollectionRepresentationModel(pedidos);

        return new ResponseEntity<List<PedidoRepresentationModel>>(pedidosRM, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idPedido}/item/{idItemPedido}")
    @ResponseBody
    public ResponseEntity<String> deleteItemPedidoById(@RequestParam(name = "idPedido") Long idPedido,
                                                       @RequestParam(name = "idItemPedido") Long idItemPedido){

        ItemPedido itemPedido = cadastroItemPedidoService.getItemPedidoById(idItemPedido);
        cadastroItemPedidoService.deleteItemPedido(itemPedido);
        return new ResponseEntity<String>("Item de ID: "+idItemPedido+" deletado.",HttpStatus.OK);
    }

    private PedidoRepresentationModel toRepresentationModel(Pedido pedido){
        PedidoRepresentationModel pedidoRepresentationModel = new PedidoRepresentationModel();
        pedidoRepresentationModel.setId(pedido.getId());
        pedidoRepresentationModel.setIdCliente(pedido.getCliente().getId());
        pedidoRepresentationModel.setNomeCliente(pedido.getCliente().getNome());
        pedidoRepresentationModel.setIdFormaPagamento(pedido.getFormaPagamento().getId());
        pedidoRepresentationModel.setFormaPagamentoDescricao(pedido.getFormaPagamento().getDescricao());

        for (int i = 0; i < pedido.getItensPedido().size(); i++) {
            ItemPedidoRepresentationModel itemPedidoRepresentationModel = new ItemPedidoRepresentationModel();
            itemPedidoRepresentationModel.setId(pedido.getItensPedido().get(i).getId());
            itemPedidoRepresentationModel.setIdProduto(pedido.getItensPedido().get(i).getProduto().getId());
            itemPedidoRepresentationModel.setDescricaoProduto(pedido.getItensPedido().get(i).getProduto().getDescricao());
            itemPedidoRepresentationModel.setQuantidade(pedido.getItensPedido().get(i).getQuantidade());
            itemPedidoRepresentationModel.setValorItem(pedido.getItensPedido().get(i).getValorItem());

            pedidoRepresentationModel.getItensPedido().add(itemPedidoRepresentationModel);

        }

        return pedidoRepresentationModel;
    }


    private Pedido toDomainObject(PedidoInput pedidoInput){

        Pedido pedido = new Pedido();

        pedido.setId(pedidoInput.getIdPedido());
        pedido.setCliente(cadastroClienteService.getClienteById(pedidoInput.getIdCliente()));
        pedido.setFormaPagamento(cadastroFormaPagamentoService.getFormaPagamentoById(pedidoInput.getIdFormaPagamento()));

        for (int i = 0; i < pedidoInput.getItensPedido().size(); i++) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setId(pedidoInput.getIdPedido());
            itemPedido.setId(pedidoInput.getItensPedido().get(i).getId());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(cadastroProdutoService.getProdutoById(pedidoInput.getItensPedido().get(i).getIdProduto()));



           // itemPedido.setProduto(cadastroProdutoService.getProdutoById(pedidoInput.getItensPedido().get(i).getIdProduto()));


              if(itemPedido.getProduto().getId() == null){
                itemPedido.setValorItem(cadastroProdutoService
                        .getProdutoById(pedidoInput
                                .getItensPedido().get(i)
                                .getIdProduto()).getPrecoVenda());

            }else{
                itemPedido.setValorItem(pedidoInput.getItensPedido().get(i).getValorItem());
            }
            itemPedido.setQuantidade(pedidoInput.getItensPedido().get(i).getQuantidade());


            pedido.getItensPedido().add(itemPedido);


        }

        return pedido;
    }
    private List<PedidoRepresentationModel> toCollectionRepresentationModel(List<Pedido> pedidos){
        return pedidos.stream()
                .map(Pedido -> toRepresentationModel(Pedido))
                .collect(Collectors.toList());
    }

}



