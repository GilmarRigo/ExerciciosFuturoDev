package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
}
