package br.com.futurodev.pedidos.service;

import br.com.futurodev.pedidos.model.FormaPagamento;
import br.com.futurodev.pedidos.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroFormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento getFormaPagamentoById(Long idFormaPagamento){
        return formaPagamentoRepository.findById(idFormaPagamento).get();
    }

}
