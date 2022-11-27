package br.com.futurodev.pedidos.controllers;

import br.com.futurodev.pedidos.dto.ClienteRepresentationModel;
import br.com.futurodev.pedidos.dto.ProdutoRepresentationModel;
import br.com.futurodev.pedidos.input.ClienteInput;
import br.com.futurodev.pedidos.input.ProdutoInput;
import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.Pedido;
import br.com.futurodev.pedidos.model.Produto;
import br.com.futurodev.pedidos.service.CadastroClienteService;
import br.com.futurodev.pedidos.service.CadastroPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")

public class ClienteController {

    @Autowired
    private CadastroClienteService cadastroClienteService;
    private ClienteRepresentationModel clienteRepresentationModel;

    @PostMapping
    public ResponseEntity<ClienteRepresentationModel> cadastrar (@RequestBody ClienteInput clienteInput) {
        Cliente cli = toDomainObject(clienteInput);
        cadastroClienteService.salvar(cli);
        return new ResponseEntity<ClienteRepresentationModel>(toModel(cli), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteRepresentationModel> atualizar (@RequestBody ClienteInput clienteInput) {
        Cliente cli = toDomainObject(clienteInput);
        cadastroClienteService.salvar(cli);
        return new ResponseEntity<ClienteRepresentationModel>(toModel(cli), HttpStatus.OK);
    }
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> cliente = cadastroClienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idCliente) {
        cadastroClienteService.deleteClienteByid(idCliente);
        return new ResponseEntity<String>("Cliente ID: " + idCliente + ": deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/cliente/{Cliente}")
    public ResponseEntity<ClienteRepresentationModel> getClienteById(@PathVariable(value = "idCliente") Long idCliente) {
        ClienteRepresentationModel clienteRepresentationModel = toModel(cadastroClienteService.getClienteById(idCliente));
        return new ResponseEntity<ClienteRepresentationModel>(clienteRepresentationModel, HttpStatus.OK);
    }

    private ClienteRepresentationModel toModel(Cliente cli) {
        ClienteRepresentationModel clienteRepresentationModel = new ClienteRepresentationModel();
        clienteRepresentationModel.setId(cli.getId());
        clienteRepresentationModel.setNome(cli.getNome());
        clienteRepresentationModel.setCpf(cli.getCpf());
        clienteRepresentationModel.setRg(cli.getRg());

        return clienteRepresentationModel;
    }


    private List<ClienteRepresentationModel> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect((Collectors.toList()));
    }


    private Cliente toDomainObject(ClienteInput clienteInput) {

        Cliente cliente = new Cliente();
        cliente.setId(clienteInput.getId());
        cliente.setNome(clienteInput.getNome());
        cliente.setCpf(clienteInput.getCpf());
        cliente.setRg(clienteInput.getRg());

        return cliente;

    }
}
