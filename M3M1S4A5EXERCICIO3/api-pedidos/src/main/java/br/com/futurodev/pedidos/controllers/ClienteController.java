package br.com.futurodev.pedidos.controllers;

import br.com.futurodev.pedidos.dto.ClienteRepresentationModel;
import br.com.futurodev.pedidos.input.ClienteInput;
import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.Pedido;
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
    //private ClienteRepresentationModel clienteRepresentationModel;

    @PostMapping
    public ResponseEntity<ClienteRepresentationModel> cadastrar(@RequestBody ClienteInput clienteInput) {
        Cliente cli = toDomainObject(clienteInput);
        cadastroClienteService.salvar(cli);
        return new ResponseEntity<ClienteRepresentationModel>(toModel(cli), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> cliente = cadastroClienteService.getClientes();
        return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
    }

    private ClienteRepresentationModel toModel(Cliente cli) {
        ClienteRepresentationModel clienteRepresentationModel = new ClienteRepresentationModel();
        clienteRepresentationModel.setId(cli.getId());
        clienteRepresentationModel.setNome(cli.getNome());
        clienteRepresentationModel.setCpf(cli.getCpf());
        clienteRepresentationModel.setRg(cli.getRg());

        return clienteRepresentationModel;
    }

    // Converte uma lista de objetos
    private List<ClienteRepresentationModel> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect((Collectors.toList()));
    }

    // Converter um objeto do tipo UsuarioInput para UsuarioModel para uma lista de objetos do tipo UsuarioRepresentationModel
    private Cliente toDomainObject(ClienteInput clienteInput) {

        Cliente cliente = new Cliente();
        cliente.setId(clienteInput.getId());
        cliente.setNome(clienteInput.getNome());
        cliente.setCpf(clienteInput.getCpf());
        cliente.setRg(clienteInput.getRg());

        return cliente;


    }
}
