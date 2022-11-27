package br.com.futurodev.pedidos.dto;


import br.com.futurodev.pedidos.model.Pedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteRepresentationModel {

    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String cpf;

    private String rg;

    private List<Pedido> pedidos =  new ArrayList<>();


}
