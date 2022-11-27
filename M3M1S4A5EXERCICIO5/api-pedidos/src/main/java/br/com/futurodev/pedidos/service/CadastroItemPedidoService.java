package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.model.ItemPedido;
import br.com.futurodev.pedidos.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CadastroItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public void deleteItemPedidoById(Long idItemPedido){
        itemPedidoRepository.deleteById(idItemPedido);
    }

    public ItemPedido getItemPedidoById(Long idItemPedido){
        return itemPedidoRepository.findById(idItemPedido).get();
    }

    @Transactional
    public void deleteItemPedido(ItemPedido itemPedido){
        itemPedidoRepository.delete(itemPedido);
    }
}
