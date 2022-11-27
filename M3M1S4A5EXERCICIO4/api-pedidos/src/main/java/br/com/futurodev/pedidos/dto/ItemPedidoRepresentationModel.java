package br.com.futurodev.pedidos.dto;


import br.com.futurodev.pedidos.model.ItemPedido;
import br.com.futurodev.pedidos.model.Pedido;
import br.com.futurodev.pedidos.model.Produto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemPedidoRepresentationModel {

    @EqualsAndHashCode.Include

    private Long id;

    private Long idProduto;

    private String descricaoProduto;

    private double valorItem;

    private double quantidade;

}
