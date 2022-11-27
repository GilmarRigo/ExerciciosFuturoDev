package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.Pedido;
import br.com.futurodev.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void deleteClienteByid(Long idCliente){
        clienteRepository.deleteById((idCliente));
    }

   /* public Cliente getClienteById(Long idCliente){
        return clienteRepository.findById(idCliente).get();
    }*/

    public List<Cliente> getClientes(){return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long idCliente){
        return clienteRepository.findById(idCliente).get();
    }
}
