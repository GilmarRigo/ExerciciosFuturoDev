package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.model.Pedido;
import br.com.futurodev.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CadastroPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public void deletePedidoById(Long idPedido){
        pedidoRepository.deleteById((idPedido));
    }

    public Pedido getPedidoById(Long idPedido){
        return pedidoRepository.findById(idPedido).get();
    }

    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }

    public List<Pedido> getPedidoByIdCliente(Long idCliente){
        return pedidoRepository.getPedidosByIdCliente(idCliente);
    }

}
