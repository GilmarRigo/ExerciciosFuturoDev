package br.com.futurodev.pedidos.input;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoInput {

    @EqualsAndHashCode.Include
    private Long id;

    private Long idPedido;

    private Long idProduto;

    private double quantidade;

    private double valorItem;
}
