package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
}
