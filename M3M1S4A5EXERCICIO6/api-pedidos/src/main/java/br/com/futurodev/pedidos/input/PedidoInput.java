package br.com.futurodev.pedidos.input;

import br.com.futurodev.pedidos.model.Cliente;
import br.com.futurodev.pedidos.model.FormaPagamento;
import br.com.futurodev.pedidos.model.ItemPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class PedidoInput {

    //@EqualsAndHashCode.Include
    //private Long id;

    private Long idPedido;

    private Long idCliente;

    private Long idFormaPagamento;

    //private Long idProduto;

    //private List<ItemPedidoInput> itensPedido = new ArrayList<>();
    private List<ItemPedidoInput> itensPedido;
}
